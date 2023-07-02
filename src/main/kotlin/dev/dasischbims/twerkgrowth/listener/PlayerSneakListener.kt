package dev.dasischbims.twerkgrowth.listener

import dev.dasischbims.twerkgrowth.INSTANCE
import dev.dasischbims.twerkgrowth.util.GrowthHelper
import dev.dasischbims.twerkgrowth.util.Logger
import org.bukkit.block.BlockFace
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerToggleSneakEvent

class PlayerSneakListener: Listener {
    @EventHandler
    fun onPlayerSneak(event: PlayerToggleSneakEvent) {
        val player = event.player
        if (player.isSneaking) return

        val world = player.world
        val block = player.location.block
        val radius = INSTANCE.config.get("radius")

        if (radius !is Double) return Logger.console.warn("Radius is not an double, please check your config.yml!")

        val growBlock = GrowthHelper().getNearestGrowable(world, block.location, radius) ?: return
        growBlock.applyBoneMeal(BlockFace.UP)
    }
}