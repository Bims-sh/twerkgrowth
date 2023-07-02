package dev.dasischbims.twerkgrowth.util

import dev.dasischbims.twerkgrowth.INSTANCE
import org.bukkit.Color
import org.bukkit.entity.Player

class Logger {
    // should have the option chat or console (usage: Logger.chat.info("Hello World!")) or Logger.console.error("Hello World!"))

    companion object {
        val chat = ChatLogger() // the chat logger sends to a specific player or to all players if no player is specified
        val console = ConsoleLogger()
    }

    class ChatLogger {
        fun send(message: String, player: Player) {
            player.sendPluginMessage(INSTANCE, "twerkgrowth:chat", message.toByteArray())
        }
    }

    class ConsoleLogger {
        fun info(message: String) {
            INSTANCE.logger.info(message)
        }

        fun warn(message: String) {
            INSTANCE.logger.warning(message)
        }

        fun error(message: String) {
            INSTANCE.logger.severe(message)
        }
    }
}