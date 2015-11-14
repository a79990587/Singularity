package org.infinitystudio.singularity.api;

import net.minecraftforge.fml.common.registry.GameRegistry;
import org.infinitystudio.singularity.block.SingularityBaseBlock;
import org.infinitystudio.singularity.block.machine.BlockComputer;
import org.infinitystudio.singularity.block.machine.BlockTechnologyBench;

/**
 * @author Blealtan
 */
public class SingularityHandlers {

    public static BlockComputer blockComputer = new BlockComputer();
    public static BlockTechnologyBench blockTechnologyBench = new BlockTechnologyBench();

    protected static void registerBlock(SingularityBaseBlock block) {
        GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
    }

    public static void registerBlocks() {
        registerBlock(blockComputer);
        registerBlock(blockTechnologyBench);
    }

    public static void registerItems() {

    }

    public static void registerRecipes() {

    }
}
