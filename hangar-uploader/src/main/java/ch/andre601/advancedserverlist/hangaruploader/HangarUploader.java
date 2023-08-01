/*
 * MIT License
 *
 * Copyright (c) 2022-2023 Andre_601
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package ch.andre601.advancedserverlist.hangaruploader;

import ch.andre601.advancedserverlist.hangaruploader.version.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.mime.FileBody;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.client5.http.entity.mime.StringBody;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpMessage;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HangarUploader{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(HangarUploader.class);
    private static final String API_URL = "https://hangar.papermc.io/api/v1/";
    
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final String apiKey;
    private ActiveJWT activeJWT;
    
    public HangarUploader(String apiKey){
        this.apiKey = apiKey;
    }
    
    public static void main(String[] args) throws IOException{
        LOGGER.info("Starting Jar file...");
        if(args.length < 3){
            throw new IllegalStateException("Application requires HANGAR_TOKEN, RELEASE_TAG, PRERELEASE and RELEASE_BODY to work");
        }
        
        final Namespace project = new Namespace("Andre_601", "AdvancedServerList");
        
        String apiToken = args[0];
        String version = args[1].startsWith("v") ? args[1].substring(1) : args[1];
        boolean isPreRelease = args[2].equalsIgnoreCase("true");
        String body = System.getenv("GITHUB_RELEASE_BODY");
        
        LOGGER.info("Version:         {}", version);
        LOGGER.info("Is Prerelease:   {}", isPreRelease);
        LOGGER.info("Release Message:");
        LOGGER.info(body);
        
        final List<Path> filePaths = List.of(
            new File("bukkit/target/AdvancedServerList-Bukkit-" + version + ".jar").toPath(),
            new File("bungeecord/target/AdvancedServerList-BungeeCord-" + version + ".jar").toPath(),
            new File("velocity/target/AdvancedServerList-Velocity-" + version + ".jar").toPath()
        );
        final List<Dependency> paperDependencies = List.of(
            Dependency.fromNamespace(
                "ViaVersion",
                false,
                new Namespace("ViaVersion", "ViaVersion")
            ),
            Dependency.fromUrl(
                "PlaceholderAPI",
                false,
                "https://www.spigotmc.org/resources/6245/"
            )
        );
        final List<Dependency> bungeeDependencies = List.of(
            Dependency.fromNamespace(
                "PAPIProxyBridge",
                false,
                new Namespace("William278", "PAPIProxyBridge")
            )
        );
        final List<Dependency> velocityDependencies = List.of(
            Dependency.fromNamespace(
                "PAPIProxyBridge",
                false,
                new Namespace("William278", "PAPIProxyBridge")
            )
        );
        
        final List<MultipartObject> fileInfo = List.of(
            new MultipartObject(List.of(Platform.PAPER), null),
            new MultipartObject(List.of(Platform.WATERFALL), null),
            new MultipartObject(List.of(Platform.VELOCITY), null)
        );
        
        final Version versionUpload = new Version(
            version,
            Map.of(
                Platform.PAPER, paperDependencies,
                Platform.WATERFALL, bungeeDependencies,
                Platform.VELOCITY, velocityDependencies
            ),
            Map.of(
                Platform.PAPER, List.of("1.19.x", "1.20.x"),
                Platform.WATERFALL, List.of("1.19.x", "1.20.x"),
                Platform.VELOCITY, List.of("3.2")
            ),
            body,
            fileInfo,
            isPreRelease ? "Beta" : "Release"
        );
        
        HangarUploader uploader = new HangarUploader(apiToken);
        try(CloseableHttpClient client = HttpClients.createDefault()){
            uploader.uploadVersion(client, project, versionUpload, filePaths);
        }catch(ParseException ex){
            LOGGER.error("Encountered ParseException while performing a request.", ex);
        }
    }
    
    public void uploadVersion(HttpClient client, Namespace namespace, Version versionUpload, List<Path> filePaths) throws IOException, ParseException{
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addPart("versionUpload", new StringBody(GSON.toJson(versionUpload), ContentType.APPLICATION_JSON));
        
        for(Path path : filePaths){
            builder.addPart("files", new FileBody(path.toFile(), ContentType.DEFAULT_BINARY));
        }
    
        HttpPost post = new HttpPost(API_URL + "projects/" + namespace + "/upload");
        post.setEntity(builder.build());
        this.addAuthHeader(client, post);
        
        LOGGER.info("Uploading release...");
        final boolean success = client.execute(post, response -> {
            if(response.getCode() != 200){
                LOGGER.error("Error while uploading version. Received response code {}: {}", response.getCode(), response.getReasonPhrase());
                LOGGER.error("Body: {}", EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8));
                return false;
            }
            return true;
        });
        if(!success){
            throw new RuntimeException("Error uploading version!");
        }
        LOGGER.info("Upload complete!");
        System.exit(0);
    }
    
    private synchronized void addAuthHeader(HttpClient client, HttpMessage message) throws IOException{
        LOGGER.info("Applying Authorization Header...");
        if(this.activeJWT != null && !this.activeJWT.hasExpired()){
            message.addHeader("Authorization", this.activeJWT.jwt());
            LOGGER.info("Authorization Header applied. Expires at {}", getDate(this.activeJWT.expiresAt()));
            return;
        }
        
        LOGGER.info("Current JWT expired. Requesting new one...");
        ActiveJWT jwt = client.execute(new HttpPost(API_URL + "authenticate?apiKey=" + this.apiKey), response -> {
            if(response.getCode() == 400){
                LOGGER.error("Bad JWT request; is the API-token valid?");
                return null;
            }else
            if(response.getCode() != 200){
                LOGGER.error("Received non-successful response code {}: {}", response.getCode(), response.getReasonPhrase());
                return null;
            }
            
            final String json = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
            final JsonObject jsonObject = GSON.fromJson(json, JsonObject.class);
            final String token = jsonObject.getAsJsonPrimitive("token").getAsString();
            final long expiresIn = jsonObject.getAsJsonPrimitive("expiresIn").getAsLong();
    
            LOGGER.info("Received new JWT!");
            return new ActiveJWT(token, System.currentTimeMillis() + expiresIn);
        });
        
        if(jwt == null){
            throw new RuntimeException("Error getting JWT.");
        }
        
        this.activeJWT = jwt;
        
        LOGGER.info("Authorization Header applied. Expires at {}", getDate(this.activeJWT.expiresAt()));
        message.addHeader("Authorization", jwt.jwt());
    }
    
    private synchronized String getDate(long timestamp){
        return timestamp + " (" + new Date(timestamp) + ")";
    }
    
    private record ActiveJWT(String jwt, long expiresAt){
        
        public boolean hasExpired(){
            return System.currentTimeMillis() < this.expiresAt + TimeUnit.SECONDS.toMillis(3);
        }
    }
}
