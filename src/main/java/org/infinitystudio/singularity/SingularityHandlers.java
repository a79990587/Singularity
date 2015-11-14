package org.infinitystudio.singularity;

import net.minecraftforge.fml.common.registry.GameRegistry;
import org.infinitystudio.singularity.block.SingularityBaseBlock;
import org.infinitystudio.singularity.block.machine.BlockComputer;
import org.infinitystudio.singularity.block.machine.BlockTechnologyBench;
import org.infinitystudio.singularity.item.ItemComputerCoprocessor;
import org.infinitystudio.singularity.item.SingularityBaseItem;

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

    public static ItemComputerCoprocessor itemComputerCoprocessor = new ItemComputerCoprocessor();

    protected static void registerItem(SingularityBaseItem item) {
        GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
    }

    public static void registerItems() {
        registerItem(itemComputerCoprocessor);
    }

    public static void registerRecipes() {

    }
}