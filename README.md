# TwerkGrowth Plugin
TwerkGrowth is a Minecraft 1.20 plugin that allows players to grow trees and plants by twerking on them. It adds a fun and unique way to interact with the game's environment and encourages players to engage in creative and entertaining gameplay.

Heavily inspired by the idea of the [TwerkItMeal](https://github.com/ticticboooom/TwerkItMeal) mod which had its last release for Minecraft 1.16.4.

## Table of Contents
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Commands](#commands)
- [Permissions](#permissions)
- [Configuration](#configuration)
- [Support](#support)
- [License](#license)

## Features
Grow trees and plants by twerking on them
Configurable radius for the twerking effect
Adjustable cooldown period between twerks

## Installation
1. Download the latest version of TwerkGrowth from the [releases page](https://github.com/DasIschBims/twerkgrowth/releases/latest).
2. Place the downloaded JAR file in the plugins folder of your Minecraft server.
3. Start or restart the server to load the plugin.

## Usage
To use TwerkGrowth, follow these steps:

1. Find a tree or plant that you want to grow.
2. Stand near the tree or plant within the configured radius.
3. Sneak near the tree or plant.
4. Watch as the tree or plant grows!

## Commands
TwerkGrowth provides the following command:

**/tgr** or **/twerkgrowthreload**: Reloads the plugin's configuration.

Description: Reloads the configuration file for TwerkGrowth.
Permission: **twerkgrowth.reload**

## Permissions
TwerkGrowth uses the following permission:

**twerkgrowth.reload**: Allows players to reload the plugin's configuration.
Description: Grants permission to use the **/tgr** or **/twerkgrowthreload** command.
Default: OP (Operator)
## Configuration
The TwerkGrowth plugin configuration file allows you to customize the plugin's behavior. The configuration file is located in the plugin's folder and can be edited with a text editor.

### Cooldown
The `cooldown` setting determines the time players need to wait between twerking actions. It is measured in seconds and supports decimals for more precise values.

```yaml
cooldown: 0.5
```

### Radius
The radius setting defines the range within which twerking actions can trigger growth for trees and plants. It is measured in blocks and also supports decimal values.

```yaml
radius: 2.5
```

In this example, the radius is set to 2.5 blocks.
Feel free to adjust these values according to your preferences and server gameplay balance.

## Support
If you encounter any problems or bugs while using TwerkGrowth, please [open an issue](https://github.com/DasIschBims/twerkgrowth/issues/new) on the GitHub repository. I will do my best to address the issue as soon as possible.

> :warning: Please make sure to describe the issue in detail and provide any relevant information that may help me reproduce the issue. This includes the version of the plugin you are using, the version of Minecraft you are running, and any other plugins you are using that may be related to the issue.

## License
TwerkGrowth is licensed under the [MIT License](LICENSE).