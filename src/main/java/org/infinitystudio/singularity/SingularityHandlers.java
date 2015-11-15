package org.infinitystudio.singularity;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.infinitystudio.singularity.api.item.SingularityBaseItem;
import org.infinitystudio.singularity.api.block.SingularityBaseBlock;
import org.infinitystudio.singularity.block.decoration.BlockBasicLabWall;
import org.infinitystudio.singularity.block.fluid.BlockFluidAbyss;
import org.infinitystudio.singularity.block.machine.BlockComputer;
import org.infinitystudio.singularity.block.machine.BlockTechnologyBench;
import org.infinitystudio.singularity.fluid.FluidAbyss;
import org.infinitystudio.singularity.fluid.SingularityBaseFluid;
import org.infinitystudio.singularity.item.ItemComputerCoprocessor;

/**
 * @author Blealtan
 */
public class SingularityHandlers {

    public static BlockComputer blockComputer = new BlockComputer();
    public static BlockTechnologyBench blockTechnologyBench = new BlockTechnologyBench();
    public static BlockBasicLabWall blockBasicLabWall = new BlockBasicLabWall();    public static BlockFluidAbyss blockFluidAbyss = new BlockFluidAbyss();    public static ItemComputerCoprocessor itemComputerCoprocessor = new ItemComputerCoprocessor();
    public static FluidAbyss fluidAbyss = new FluidAbyss();

    protected static void registerBlock(Block block) {
        SingularityRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
    }

    public static void registerBlocks() {
        registerBlock(blockComputer);
        registerBlock(blockTechnologyBench);
        registerBlock(blockBasicLabWall);        registerBlock(blockFluidAbyss);    }

    protected static void registerItem(Item item) {
	SingularityRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
    }

    public static void registerItems() {
        registerItem(itemComputerCoprocessor);
    }

    public static void registerRecipes() {

    }
    
    public static void registerFluids() {
	registerFluid(fluidAbyss);
    }
    
    protected static void registerFluid(Fluid fluid) {
	FluidRegistry.registerFluid(fluid);
    }
}
