package dev.dasischbims.twerkgrowth.commands

import dev.dasischbims.twerkgrowth.INSTANCE
import dev.dasischbims.twerkgrowth.util.Logger
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player

class ReloadPlugin: CommandExecutor, TabCompleter {
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

    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>?
    ): MutableList<String> {
        return mutableListOf()
    }
}