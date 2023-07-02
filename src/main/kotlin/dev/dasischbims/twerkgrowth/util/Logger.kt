package dev.dasischbims.twerkgrowth.util

import dev.dasischbims.twerkgrowth.INSTANCE
import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.entity.Player

class Logger {
    companion object {
        val chat = ChatLogger()
        val console = ConsoleLogger()
    }

    class ChatLogger {
        fun send(message: String, player: Player) {
            val miniMessage = MiniMessage.miniMessage()
            val parsed = miniMessage.deserialize(message)

            player.sendMessage(parsed)
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