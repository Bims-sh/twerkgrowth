package dev.dasischbims.twerkgrowth

import dev.dasischbims.twerkgrowth.commands.ReloadPlugin
import dev.dasischbims.twerkgrowth.listener.PlayerSneakListener
import org.bukkit.Bukkit
internal fun initPlugin() {
    INSTANCE.saveDefaultConfig()
    registerListeners()
    registerCommands()
}

internal fun registerCommands() {
    INSTANCE.getCommand("tgr")?.setExecutor(ReloadPlugin())
    INSTANCE.getCommand("tgr")?.tabCompleter = ReloadPlugin()
}

internal fun registerListeners() {
    val listeners = listOf(
        PlayerSneakListener()
    )

    val pluginManager = Bukkit.getPluginManager()
    listeners.forEach { listener ->
        pluginManager.registerEvents(listener, INSTANCE)
    }
}