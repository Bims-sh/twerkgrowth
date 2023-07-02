package dev.dasischbims.twerkgrowth.util

import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.World
import org.bukkit.block.Block
import kotlin.math.pow
import kotlin.math.sqrt


class GrowthHelper {
    fun getNearestGrowable(world: World, location: Location, radius: Double): Block? {
        val blocks = mutableListOf<Block>()

        val x = location.blockX
        val y = location.blockY
        val z = location.blockZ

        val rad = radius.toInt()

        for (i in -rad..rad) {
            for (j in -rad..rad) {
                for (k in -rad..rad) {
                    val block = world.getBlockAt(x + i, y + j, z + k)
                    if (isGrowable(block)) {
                        blocks.add(block)
                    }
                }
            }
        }

        blocks.sortBy { block ->
            val blockX = block.location.blockX
            val blockY = block.location.blockY
            val blockZ = block.location.blockZ

            val distance = sqrt(
                (blockX - x).toDouble().pow(2.0) + (blockY - y).toDouble().pow(2.0) + (blockZ - z).toDouble().pow(2.0)
            )

            distance
        }

        return if (blocks.isEmpty()) {
            null
        } else {
            blocks.first()
        }
    }

    private fun isGrowable(block: Block): Boolean {
        val growableBlocks = listOf(
            Material.OAK_SAPLING,
            Material.SPRUCE_SAPLING,
            Material.BIRCH_SAPLING,
            Material.JUNGLE_SAPLING,
            Material.ACACIA_SAPLING,
            Material.DARK_OAK_SAPLING,
            Material.CRIMSON_FUNGUS,
            Material.WARPED_FUNGUS,
            Material.CHERRY_SAPLING,
            Material.MANGROVE_PROPAGULE,
            Material.CARROT,
            Material.POTATO,
            Material.WHEAT,
            Material.BEETROOTS,
            Material.MELON_STEM,
            Material.PUMPKIN_STEM,
        )

        return growableBlocks.contains(block.type)
    }
}