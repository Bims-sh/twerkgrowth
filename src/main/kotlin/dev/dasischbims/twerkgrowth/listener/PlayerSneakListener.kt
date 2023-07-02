package dev.dasischbims.twerkgrowth.listener

import dev.dasischbims.twerkgrowth.INSTANCE
import dev.dasischbims.twerkgrowth.util.GrowthHelper
import dev.dasischbims.twerkgrowth.util.Logger
import org.bukkit.block.BlockFace
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerToggleSneakEvent
import org.bukkit.metadata.FixedMetadataValue

class PlayerSneakListener: Listener {
    @EventHandler
    fun onPlayerSneak(event: PlayerToggleSneakEvent) {
        val player = event.player
        if (player.isSneaking) return

        val cooldownDuration = INSTANCE.config.get("cooldown")?: return Logger.console.warn("Cooldown time not found, please check your config.yml!")
        val cooldown = if (cooldownDuration !is Double) cooldownDuration.toString().toDoubleOrNull() ?: return else cooldownDuration
        val cooldownStartTime = player.getMetadata("tgr_cooldown").firstOrNull()?.asLong() ?: 0
        val currentTime = System.currentTimeMillis()

        if (currentTime >= cooldownStartTime + cooldown * 1000) {
            val world = player.world
            val block = player.location.block
            val radius = if (INSTANCE.config.get("radius") !is Double) return Logger.console.warn("Radius is not an double, please check your config.yml!") else INSTANCE.config.get("radius") as Double

            val growBlock = GrowthHelper().getNearestGrowable(world, block.location, radius) ?: return
            growBlock.applyBoneMeal(BlockFace.UP)
            player.setMetadata("tgr_cooldown", FixedMetadataValue(INSTANCE, currentTime))
        }
    }
}