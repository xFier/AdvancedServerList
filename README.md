# AdvancedServerList
![platform] ![tested]

AdvancedServerList is a plugin made for SpigotMC, PaperMC, BungeeCord/Waterfall and Velocity. It allows you to create server list profiles to display based on priority and conditions.

## What is a Server List Profile?
A Server List Profile refers to a YAML file located in the plugin's `profiles` directory.  
It allows you to configure specific aspects of the server display in the MC-Client's multiplayer server list, such as the MOTD, player count text, player count hover or Favicon.

> [*Read More*][profiles]

### Conditions
Thanks to conditions can you determine when a profile should be displayed in the player’s server list, to allow displaying specific text (i.e. a warning when they are using an outdated version).

When multiple profiles exist that have valid conditions will the one with the highest priority (Higher number = higher priority) be selected. Having no conditions makes the profile automatically return true.

> [*Read More*][conditions]

### Placeholders
Placeholders can be used within conditions to further customize them. They can also be used in any other text option (motd, playerCount and players) to display their respective values.
The format is `${<target> <identifier>}` which was adopted from BungeeTabListPlus. Depending on what platform you use the plugin on are only specific placeholders available.

When using the SpigotMC/PaperMC version can you also use placeholders from [PlaceholderAPI][placeholderapi] using its `%<identifier>_<values>%` placeholder format. PlaceholderAPI needs to be installed for that.

> [*Read More*][placeholders]

### Formatting
The plugin uses the MiniMessage format for a consistent, easy way of formatting your text.
Only certain options are usable for each option. As an example does motd support HEX colours and gradients, while the other options only support default colour codes.

> [*Read More*][minimessage]

## Downloads
AdvancedServerList can be downloaded from the following places:

[![dl-modrinth]][modrinth] [![dl-spigot]][spigot] [![dl-hangar]][hangar]

## Statistics

This plugin sends statistics to [bStats] to display.  
You can disable this in the `config.yml` by setting `send_statistics` to `false`.

- [BungeeCord][bstats-bungee]
- [Paper/Spigot][bstats-spigot]
- [Velocity][bstats-velocity]

## Screenshots
Here are screenshots showing the plugin in action. Do you have your own screenshots that you would like to share? Let me know and I may add them here with proper credit.

![showcase]

![features]

<!-- Links -->
[profiles]: https://github.com/Andre601/AdvancedServerList/wiki/Profiles
[conditions]: https://github.com/Andre601/AdvancedServerList/wiki/Profiles#conditions
[placeholders]: https://github.com/Andre601/AdvancedServerList/wiki/Profiles#placeholders
[minimessage]: https://github.com/Andre601/AdvancedServerList/wiki/Profiles#minimessage

[placeholderapi]: https://www.spigotmc.org/resources/6245/

[modrinth]: https://modrinth.com/mod/advancedserverlist
[spigot]: https://www.spigotmc.org/resources/102910/
[hangar]: https://hangar.benndorf.dev/Andre_601/AdvancedServerList

[bstats]: https://bstats.org
[bstats-bungee]: https://bstats.org/plugin/bungeecord/AdvancedServerList/15585
[bstats-spigot]: https://bstats.org/plugin/bukkit/AdvancedServerList/15584
[bstats-velocity]: https://bstats.org/plugin/velocity/AdvancedServerList/15587

<!-- images -->
[showcase]: https://cdn.discordapp.com/attachments/417019799365746690/990379003250626580/unknown.png
[features]: https://cdn.discordapp.com/attachments/990389158944055366/1004042735973568522/2022-08-02_17.03.40.jpg

<!-- Badges -->
[platform]: https://img.shields.io/badge/Platforms-Spigot%20%7C%20Paper%20%7C%20BungeeCord%20%7C%20Velocity-blue?style=for-the-badge&logo=data:image/svg%2bxml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAyNCAyNCIgd2lkdGg9IjI0IiBoZWlnaHQ9IjI0IiBmaWxsPSJ3aGl0ZSI+PHBhdGggZmlsbC1ydWxlPSJldmVub2RkIiBkPSJNMTEuMDYzIDEuNDU2YTEuNzUgMS43NSAwIDAxMS44NzQgMGw4LjM4MyA1LjMxNmExLjc1IDEuNzUgMCAwMTAgMi45NTZsLTguMzgzIDUuMzE2YTEuNzUgMS43NSAwIDAxLTEuODc0IDBMMi42OCA5LjcyOGExLjc1IDEuNzUgMCAwMTAtMi45NTZsOC4zODMtNS4zMTZ6bTEuMDcxIDEuMjY3YS4yNS4yNSAwIDAwLS4yNjggMEwzLjQ4MyA4LjAzOWEuMjUuMjUgMCAwMDAgLjQyMmw4LjM4MyA1LjMxNmEuMjUuMjUgMCAwMC4yNjggMGw4LjM4My01LjMxNmEuMjUuMjUgMCAwMDAtLjQyMmwtOC4zODMtNS4zMTZ6Ij48L3BhdGg+PHBhdGggZmlsbC1ydWxlPSJldmVub2RkIiBkPSJNMS44NjcgMTIuMzI0YS43NS43NSAwIDAxMS4wMzUtLjIzMmw4Ljk2NCA1LjY4NWEuMjUuMjUgMCAwMC4yNjggMGw4Ljk2NC01LjY4NWEuNzUuNzUgMCAwMS44MDQgMS4yNjdsLTguOTY1IDUuNjg1YTEuNzUgMS43NSAwIDAxLTEuODc0IDBsLTguOTY1LTUuNjg1YS43NS43NSAwIDAxLS4yMzEtMS4wMzV6Ij48L3BhdGg+PHBhdGggZmlsbC1ydWxlPSJldmVub2RkIiBkPSJNMS44NjcgMTYuMzI0YS43NS43NSAwIDAxMS4wMzUtLjIzMmw4Ljk2NCA1LjY4NWEuMjUuMjUgMCAwMC4yNjggMGw4Ljk2NC01LjY4NWEuNzUuNzUgMCAwMS44MDQgMS4yNjdsLTguOTY1IDUuNjg1YTEuNzUgMS43NSAwIDAxLTEuODc0IDBsLTguOTY1LTUuNjg1YS43NS43NSAwIDAxLS4yMzEtMS4wMzV6Ij48L3BhdGg+PC9zdmc+

[tested]: https://img.shields.io/badge/Tested%20Versions-1.19%20%7C%201.19.1%20%7C%201.19.2-blue?style=for-the-badge&logo=image/svg%2bxml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAyNCAyNCIgd2lkdGg9IjI0IiBoZWlnaHQ9IjI0IiBmaWxsPSJ3aGl0ZSI+PHBhdGggZD0iTTE3LjI4IDkuMjhhLjc1Ljc1IDAgMDAtMS4wNi0xLjA2bC01Ljk3IDUuOTctMi40Ny0yLjQ3YS43NS43NSAwIDAwLTEuMDYgMS4wNmwzIDNhLjc1Ljc1IDAgMDAxLjA2IDBsNi41LTYuNXoiPjwvcGF0aD48cGF0aCBmaWxsLXJ1bGU9ImV2ZW5vZGQiIGQ9Ik0zLjc1IDJBMS43NSAxLjc1IDAgMDAyIDMuNzV2MTYuNWMwIC45NjYuNzg0IDEuNzUgMS43NSAxLjc1aDE2LjVBMS43NSAxLjc1IDAgMDAyMiAyMC4yNVYzLjc1QTEuNzUgMS43NSAwIDAwMjAuMjUgMkgzLjc1ek0zLjUgMy43NWEuMjUuMjUgMCAwMS4yNS0uMjVoMTYuNWEuMjUuMjUgMCAwMS4yNS4yNXYxNi41YS4yNS4yNSAwIDAxLS4yNS4yNUgzLjc1YS4yNS4yNSAwIDAxLS4yNS0uMjVWMy43NXoiPjwvcGF0aD48L3N2Zz4=

[dl-modrinth]: https://img.shields.io/badge/Modrinth-30b27b?style=for-the-badge&logo=data:image/svg%2bxml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbDpzcGFjZT0icHJlc2VydmUiIGZpbGwtcnVsZT0iZXZlbm9kZCIgc3Ryb2tlLWxpbmVqb2luPSJyb3VuZCIgc3Ryb2tlLW1pdGVybGltaXQ9IjEuNSIgY2xpcC1ydWxlPSJldmVub2RkIiB2aWV3Qm94PSIwIDAgNjggNjgiPjxwYXRoIGZpbGw9Im5vbmUiIGQ9Ik0uMDUgMGg2NnY2NmgtNjZ6Ii8+PGNsaXBQYXRoIGlkPSJhIj48cGF0aCBkPSJNLjA1IDBoNjZ2NjZoLTY2eiIvPjwvY2xpcFBhdGg+PGcgY2xpcC1wYXRoPSJ1cmwoI2EpIj48Y2xpcFBhdGggaWQ9ImIiPjxjaXJjbGUgY3g9IjMzLjA1IiBjeT0iMzMiIHI9IjMzIi8+PC9jbGlwUGF0aD48ZyBjbGlwLXBhdGg9InVybCgjYikiPjxjbGlwUGF0aCBpZD0iYyI+PHBhdGggZD0iTTgzLjA1LTE3aC0xMDBWODNoMTAwVi0xN1pNMjkuMDUxIDMyLjI5NWwuMDc3IDEuNzU3IDguODI5IDMyLjk2MyA3Ljg0NC0yLjEwMi04LjU5Ny0zMi4wOTRMNDMuMDA5LS4xMTNsLTcuOTk3LTEuNDEtNS45NjEgMzMuODE4WiIvPjwvY2xpcFBhdGg+PGcgY2xpcC1wYXRoPSJ1cmwoI2MpIj48cGF0aCBmaWxsPSIjRkZGIiBkPSJNMzMuMDUgMGMxOC4yMDYgMCAzMi45ODggMTQuNzg3IDMyLjk4OCAzM1M1MS4yNTYgNjYgMzMuMDUgNjZDMTQuODQzIDY2IC4wNjEgNTEuMjEzLjA2MSAzM1MxNC44NDMgMCAzMy4wNSAwWm0wIDljMTMuMjQgMCAyMy45ODggMTAuNzU1IDIzLjk4OCAyNFM0Ni4yOSA1NyAzMy4wNSA1N0MxOS44MDkgNTcgOS4wNjEgNDYuMjQ1IDkuMDYxIDMzUzE5LjgwOSA5IDMzLjA1IDlaIi8+PC9nPjxjbGlwUGF0aCBpZD0iZCI+PHBhdGggZD0iTS0xNi45NS0xN3Y0Nmg1MGwxLjM2OC4yNDFMODIuMDUgNDYuNTc4bC0yLjczNyA3LjUxN0wzMi4zNDQgMzdILTE2Ljk1djQ2aDEwMFYtMTdoLTEwMFoiLz48L2NsaXBQYXRoPjxnIGNsaXAtcGF0aD0idXJsKCNkKSI+PHBhdGggZmlsbD0iI0ZGRiIgZD0iTTMzLjA1LTE3YzI3LjU5NSAwIDUwIDIyLjQwNCA1MCA1MHMtMjIuNDA1IDUwLTUwIDUwYy0yNy41OTYgMC01MC0yMi40MDQtNTAtNTBzMjIuNDA0LTUwIDUwLTUwWm0wIDljMjIuNjI4IDAgNDEgMTguMzcxIDQxIDQxcy0xOC4zNzIgNDEtNDEgNDFjLTIyLjYyOSAwLTQxLTE4LjM3MS00MS00MXMxOC4zNzEtNDEgNDEtNDFaIi8+PC9nPjxjbGlwUGF0aCBpZD0iZSI+PHBhdGggZD0iTTMzLjA1LTE3YzI3LjU5NSAwIDUwIDIyLjQwNCA1MCA1MHMtMjIuNDA1IDUwLTUwIDUwYy0yNy41OTYgMC01MC0yMi40MDQtNTAtNTBzMjIuNDA0LTUwIDUwLTUwWm0wIDM5LjU0OWM1Ljc2NyAwIDEwLjQ1IDQuNjgzIDEwLjQ1IDEwLjQ1MSAwIDUuNzY4LTQuNjgzIDEwLjQ1MS0xMC40NSAxMC40NTEtNS43NjggMC0xMC40NTEtNC42ODMtMTAuNDUxLTEwLjQ1MSAwLTUuNzY4IDQuNjgzLTEwLjQ1MSAxMC40NTEtMTAuNDUxWiIvPjwvY2xpcFBhdGg+PGcgY2xpcC1wYXRoPSJ1cmwoI2UpIj48cGF0aCBmaWxsPSJub25lIiBzdHJva2U9IiNGRkYiIHN0cm9rZS13aWR0aD0iOSIgZD0ibTMzLjA1IDMzLTQ0LjgyOSAyNS44ODIiLz48L2c+PGNsaXBQYXRoIGlkPSJmIj48cGF0aCBkPSJNMzMuMDUtMTdjMjcuNTk1IDAgNTAgMjIuNDA0IDUwIDUwcy0yMi40MDUgNTAtNTAgNTBjLTI3LjU5NiAwLTUwLTIyLjQwNC01MC01MHMyMi40MDQtNTAgNTAtNTBabTAgMjUuMzZjMTMuNTk5IDAgMjQuNjQgMTEuMDQxIDI0LjY0IDI0LjY0UzQ2LjY0OSA1Ny42NCAzMy4wNSA1Ny42NEMxOS40NSA1Ny42NCA4LjQwOSA0Ni41OTkgOC40MDkgMzNTMTkuNDUgOC4zNiAzMy4wNSA4LjM2WiIvPjwvY2xpcFBhdGg+PGcgY2xpcC1wYXRoPSJ1cmwoI2YpIj48cGF0aCBmaWxsPSJub25lIiBzdHJva2U9IiNGRkYiIHN0cm9rZS13aWR0aD0iOSIgZD0ibTMzLjA1IDMzIDUwLTEzLjM5NyIvPjwvZz48cGF0aCBmaWxsPSIjRkZGIiBkPSJNMjAuMjkzIDM1Ljc0NiAxOC4wNSAyOGw4LTkgMTEtMyA0IDQtNiA2LTQgMS0zIDQgMS4xMiA0LjI0IDMuMTEyIDMuMDkgNC45NjQtLjU5OCAyLjg2Ni0yLjk2NCA4LjE5Ni0yLjE5NiAxLjQ2NCA1LjQ2NC04LjA5OCA4LjAyNkwyOS44OCA0OC40OWwtNS41ODctNS44MTUtNC02LjkyOVoiLz48L2c+PC9nPjwvc3ZnPg==

[dl-spigot]: https://img.shields.io/badge/Spigot-ed8106?style=for-the-badge&logo=data:image/svg%2bxml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCA1MTIgNTEyIiBmaWxsPSIjRkZGIj48cGF0aCBkPSJNNDE2IDQ4MGMwIDE3LjYyIDE0LjM4IDMyIDMyIDMyczMyLTE0LjM4IDMyLTMycy0zMi02NC0zMi02NFM0MTYgNDYyLjQgNDE2IDQ4MHpNMzUyIDE5MmgtMzguNTRDMjk3LjcgMTc4LjUgMjc3LjkgMTY4LjkgMjU2IDE2NFYxMTYuNUwyMjQgMTEzTDE5MiAxMTYuNVYxNjRDMTcwLjEgMTY5IDE1MC4zIDE3OC42IDEzNC41IDE5MkgxNkM3LjEyNSAxOTIgMCAxOTkuMSAwIDIwOHY5NkMwIDMxMi45IDcuMTI1IDMyMCAxNiAzMjBoOTIuNzhDMTI5LjQgMzU3LjggMTczIDM4NCAyMjQgMzg0czk0LjU5LTI2LjI1IDExNS4yLTY0SDM1MmMxNy42MiAwIDMyIDE0LjI5IDMyIDMxLjkxUzM5OC40IDM4NCA0MTYgMzg0aDY0YzE3LjYyIDAgMzItMTQuMzggMzItMzJDNTEyIDI2My42IDQ0MC40IDE5MiAzNTIgMTkyek04MS42MyA5NS44OEwyMjQgODAuODhsMTQyLjQgMTVDMzc1LjkgOTYuODggMzg0IDg5LjEyIDM4NCA3OS4xMlY0OC44OWMwLTEwLTguMTI1LTE3Ljc0LTE3LjYyLTE2Ljc0TDI1NiA0My43NVYxNkMyNTYgNy4xMjUgMjQ4LjkgMCAyNDAgMGgtMzJDMTk5LjEgMCAxOTIgNy4xMjUgMTkyIDE2djI3Ljc1TDgxLjYzIDMyLjE0QzcyLjEzIDMxLjE0IDY0IDM4Ljg5IDY0IDQ4Ljg5Vjc5LjEyQzY0IDg5LjEyIDcyLjEzIDk2Ljg4IDgxLjYzIDk1Ljg4eiIvPjwvc3ZnPg==

[dl-hangar]: https://img.shields.io/badge/Hangar%20(Beta)-444?style=for-the-badge&logo=data:image/svg%2bxml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAyNDEgMjI0LjUiPjxkZWZzPjxzdHlsZT4uYXtmaWxsOm5vbmU7fS5iLC5se2ZpbGw6I2ZmZjt9LmIsLmMsLmQsLmUsLmYsLmcsLmgsLmksLmp7ZmlsbC1ydWxlOmV2ZW5vZGQ7fS5je2ZpbGw6I2ZhMDt9LmR7ZmlsbDojYWFhO30uZXtmaWxsOiM1NWY7fS5me2ZpbGw6IzVmNTt9Lmd7ZmlsbDojNjdjYmRmO30uaHtmaWxsOiNmNTU7fS5pe2ZpbGw6I2Y1Zjt9Lmp7ZmlsbDojZmY1O30ua3tmaWxsOiM0NDQ7fTwvc3R5bGU+PC9kZWZzPjxyZWN0IGNsYXNzPSJhIiB4PSIyMS4yIiB5PSIxMy42IiB3aWR0aD0iMjE0LjciIGhlaWdodD0iMTk5Ljk0Ii8+PHBhdGggY2xhc3M9ImIiIGQ9Ik01NTAuOCwzOTkuNSwzOTEuMiw0NzUuMyw0NzIuNSw2MjRsMTU5LjYtNzUuOEw1NTAuOCwzOTkuNVoiIHRyYW5zZm9ybT0idHJhbnNsYXRlKC0zOTEuMiAtMzk5LjUpIi8+PHBhdGggY2xhc3M9ImMiIGQ9Ik01NTcsNDAxLjYsMzkzLjQsNDY5LjVsNzIuOCwxNTIuNEw2MjkuOSw1NTRaIiB0cmFuc2Zvcm09InRyYW5zbGF0ZSgtMzkxLjIgLTM5OS41KSIvPjxwYXRoIGNsYXNzPSJkIiBkPSJNNTYzLjIsNDA0LDM5NS45LDQ2My44bDY0LjIsMTU1LjgsMTY3LjMtNTkuOFoiIHRyYW5zZm9ybT0idHJhbnNsYXRlKC0zOTEuMiAtMzk5LjUpIi8+PHBhdGggY2xhc3M9ImUiIGQ9Ik01NjkuMiw0MDYuNiwzOTguOCw0NTguMmw1NS4zLDE1OC43LDE3MC40LTUxLjZMNTY5LjIsNDA2LjZaIiB0cmFuc2Zvcm09InRyYW5zbGF0ZSgtMzkxLjIgLTM5OS41KSIvPjxwYXRoIGNsYXNzPSJmIiBkPSJNNTc1LDQwOS42LDQwMiw0NTIuOGw0Ni4zLDE2MS4xLDE3My4xLTQzLjFaIiB0cmFuc2Zvcm09InRyYW5zbGF0ZSgtMzkxLjIgLTM5OS41KSIvPjxwYXRoIGNsYXNzPSJnIiBkPSJNNTgxLjEsNDEyLjVsLTE3NS41LDM1TDQ0My4yLDYxMWwxNzUuNS0zNUw1ODEuMSw0MTIuNVoiIHRyYW5zZm9ybT0idHJhbnNsYXRlKC0zOTEuMiAtMzk5LjUpIi8+PHBhdGggY2xhc3M9ImgiIGQ9Ik01ODYuMSw0MTYuMyw0MDkuMiw0NDIuNGwyOCwxNjQuOCwxNzYuOS0yNi4xLTI4LTE2NC44WiIgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoLTM5MS4yIC0zOTkuNSkiLz48cGF0aCBjbGFzcz0iaSIgZD0iTTU5MS40LDQyMC4xLDQxMy4yLDQzNy41bDE4LjcsMTY2TDYxMC4xLDU4Niw1OTEuNCw0MjAuMVoiIHRyYW5zZm9ybT0idHJhbnNsYXRlKC0zOTEuMiAtMzk5LjUpIi8+PHBhdGggY2xhc3M9ImoiIGQ9Ik01OTYuNCw0MjQuMWwtMTc4LjksOC43LDkuNCwxNjYuNiwxNzguOS04LjctOS40LTE2Ni42WiIgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoLTM5MS4yIC0zOTkuNSkiLz48cmVjdCBjbGFzcz0iayIgeD0iMzAuOSIgeT0iMjguOCIgd2lkdGg9IjE3OS4yIiBoZWlnaHQ9IjE2Ni44OCIvPjxwYXRoIGNsYXNzPSJsIiBkPSJNNTU0LjcsNTAyLjdjLTkuNy0zLjYtMjQsMTAuMi0zMSwzMS40YTgzLjksODMuOSwwLDAsMC0zLjUsMzUuOWwtNC41LTEuOWMtOC42LTI2LjctMy44LTU1LjksMTEuMS03N1oiIHRyYW5zZm9ybT0idHJhbnNsYXRlKC0zOTEuMiAtMzk5LjUpIi8+PHBhdGggY2xhc3M9ImwiIGQ9Ik01NjEsNTQ4LjNsLTMzLjItMTMuN2M2LjEtMTguNSwxNy40LTI5LjYsMjQuNy0yOS42YTcuOCw3LjgsMCwwLDEsMi4yLjRsLjYuM2MyLjYsMS4yLDEwLjUsOCw1LjcsNDIuNiIgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoLTM5MS4yIC0zOTkuNSkiLz48cGF0aCBjbGFzcz0ibCIgZD0iTTU0OS4xLDQ2Ni4yYTczLjQsNzMuNCwwLDAsMC0yNS44LDIzLjRjLTE0LjYsMjEuMi0xOS42LDQ5LjktMTIsNzYuN2E4Mi4yLDgyLjIsMCwwLDAsMy4zLDkuNWwtNDQuNS0xOC40Yy0xNi44LTQxLjItMS40LTkwLjMsMzQuNS0xMDkuN1oiIHRyYW5zZm9ybT0idHJhbnNsYXRlKC0zOTEuMiAtMzk5LjUpIi8+PC9zdmc+Cg==
