package dev.dasischbims.twerkgrowth.commands

import dev.dasischbims.twerkgrowth.INSTANCE
import dev.dasischbims.twerkgrowth.util.Logger
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class ReloadPlugin: CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        INSTANCE.reloadConfig()

        return if (sender !is Player) {
            Logger.console.info("Plugin reloaded!")
            true
        } else {
            Logger.chat.send("<green>Plugin reloaded!", sender)
            true
        }
    }
}