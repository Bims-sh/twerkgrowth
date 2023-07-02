package dev.dasischbims.twerkgrowth

import dev.dasischbims.twerkgrowth.util.Logger
import org.bukkit.plugin.java.JavaPlugin

lateinit var INSTANCE: Main
class Main : JavaPlugin() {
    override fun onEnable() {
        INSTANCE = this

        initPlugin()
        Logger.console.info("Plugin enabled!")
    }

    override fun onLoad() {
        INSTANCE = this
        Logger.console.info("Plugin loaded!")
    }

    override fun onDisable() {
        INSTANCE.saveConfig()
        Logger.console.info("Plugin disabled!")
    }
}
