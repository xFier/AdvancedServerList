/*
 * MIT License
 *
 * Copyright (c) 2022 Andre_601
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

package ch.andre601.advancedserverlist.spigot.events;

import ch.andre601.advancedserverlist.core.interfaces.events.GenericEventWrapper;
import ch.andre601.advancedserverlist.core.interfaces.core.PluginCore;
import ch.andre601.advancedserverlist.core.profiles.players.GenericPlayer;
import ch.andre601.advancedserverlist.core.profiles.replacer.placeholders.PlayerPlaceholders;
import ch.andre601.advancedserverlist.core.profiles.replacer.placeholders.ServerPlaceholders;
import ch.andre601.advancedserverlist.spigot.SpigotCore;
import ch.andre601.advancedserverlist.spigot.SpigotPlayer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.AdventureComponentConverter;
import com.comphenix.protocol.wrappers.WrappedServerPing;
import me.clip.placeholderapi.PlaceholderAPI;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import java.util.List;
import java.util.Map;

public class ProtocolLibEventWrapper implements GenericEventWrapper<OfflinePlayer, WrappedServerPing.CompressedImage>{
    
    private final SpigotCore plugin;
    private final PacketEvent event;
    private final WrappedServerPing ping;
    
    private final Map<String, String> hostAddresses;
    
    public ProtocolLibEventWrapper(SpigotCore plugin, PacketEvent event, Map<String, String> hostAddresses){
        this.plugin = plugin;
        this.event = event;
        this.ping = event.getPacket().getServerPings().read(0);
        
        this.hostAddresses = hostAddresses;
    }
    
    @Override
    public void setMaxPlayers(int maxPlayers){
        ping.setPlayersMaximum(maxPlayers);
    }
    
    @Override
    public void setMotd(Component component){
        ping.setMotD(AdventureComponentConverter.fromComponent(component));
    }
    
    @Override
    public void hidePlayers(){
        ping.setPlayersVisible(false);
    }
    
    @Override
    public void setPlayerCount(String name){
        ping.setVersionName(name);
        ping.setVersionProtocol(-1);
    }
    
    @Override
    public void setPlayers(List<String> players, GenericPlayer<OfflinePlayer> player, PlayerPlaceholders playerPlaceholders, ServerPlaceholders serverPlaceholders){
        ping.setPlayers(
            plugin.createPlayers(players, player.getPlayer(), playerPlaceholders, serverPlaceholders)
        );
    }
    
    @Override
    public void setFavicon(String favicon){
        WrappedServerPing.CompressedImage fav = plugin.getFaviconHandler().getFavicon(favicon, image -> {
            try{
                return WrappedServerPing.CompressedImage.fromPng(image);
            }catch(Exception ex){
                return null;
            }
        });
        
        if(fav == null){
            plugin.getPluginLogger().warn("Cannot apply valid favicon. See previous messages for reasons");
            ping.setFavicon(ping.getFavicon());
        }else{
            ping.setFavicon(fav);
        }
    }
    
    // Not used in ProtocolLib
    @Override
    public void updateEvent(){}
    
    @Override
    public boolean isInvalidProtocol(){
        return event.getPlayer().getAddress() == null;
    }
    
    @Override
    public int getProtocolVersion(){
        return ping.getVersionProtocol();
    }
    
    @Override
    public int getOnlinePlayers(){
        return ping.getPlayersOnline();
    }
    
    @Override
    public int getMaxPlayers(){
        return ping.getPlayersMaximum();
    }
    
    @Override
    public String getPlayerIP(){
        return event.getPlayer().getAddress() == null ? "UNKNOWN" : event.getPlayer().getAddress().getHostString();
    }
    
    @Override
    public String parsePAPIPlaceholders(String text, GenericPlayer<OfflinePlayer> player){
        if(plugin.getServer().getPluginManager().isPluginEnabled("PlaceholderAPI"))
            return PlaceholderAPI.setPlaceholders(player.getPlayer(), text);
        
        return text;
    }
    
    @Override
    public String getVirtualHost(){
        String host = this.resolveHost(event.getPlayer().getAddress());
        if(host == null)
            return null;
        
        return hostAddresses.get(host);
    }
    
    @Override
    public PluginCore<WrappedServerPing.CompressedImage> getPlugin(){
        return plugin;
    }
    
    @Override
    public GenericPlayer<OfflinePlayer> createPlayer(String name, int protocol){
        OfflinePlayer player = Bukkit.getPlayerExact(name);
        
        if(player == null){
            //noinspection deprecation
            player = Bukkit.getOfflinePlayer(name);
            
            return new SpigotPlayer(player.hasPlayedBefore() ? player : null, name, protocol);
        }
        
        return new SpigotPlayer(player, name, protocol);
    }
}
