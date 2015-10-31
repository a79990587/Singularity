/**
 * Singularity Mod for Minecraft. Copyright (C) 2015 Infinity Studio.
 * <p/>
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * <p/>
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * <p/>
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 *
 * @license GPLv3
 */
package org.infinitystudio.singularity.api;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import org.infinitystudio.singularity.api.recipe.CommonRecipe;
import org.infinitystudio.singularity.api.recipe.CommonRecipeHandler;
import org.infinitystudio.singularity.api.recipe.tech.TechbenchRecipe;
import org.infinitystudio.singularity.api.recipe.tech.TechbenchRecipeHandler;
import org.infinitystudio.singularity.api.recipe.workbench.WorkbenchRecipe;
import org.infinitystudio.singularity.api.recipe.workbench.WorkbenchRecipeHandler;
import org.infinitystudio.singularity.block.SingularityBlock;
import org.infinitystudio.singularity.item.SingularityItem;

/**
 * The Singularity Mod's Registery.
 * 
 * @author Darkhighness
 *
 */
public class SingularityRegistery extends GameRegistry
{

    /**
     * To register an ingot with OreDictionary.
     * 
     * @param Ingot
     *            The object to be registered.
     */
    public static void registerIngotWithOreDictionary(SingularityItem Ingot)
    {
	OreDictionary.registerOre(Ingot.getName(), Ingot);
    }

    /**
     * To register an block with OreDictionary.
     * 
     * @param Block
     *            The object to be registered.
     */
    public static void registerBlockWithOreDictionary(SingularityBlock Block)
    {
	OreDictionary.registerOre(Block.getName(), Block);
    }

    private static TechbenchRecipeHandler techbenchRecipeHandler = new TechbenchRecipeHandler();
    private static WorkbenchRecipeHandler workbenchRecipeHandler = new WorkbenchRecipeHandler();
    private static CommonRecipeHandler commonRecipeHandler = new CommonRecipeHandler();

    /**
     * To register a recipe.
     * 
     * @param commonRecipe
     *            The recipe object to be registered.
     * @return Whether the registration is succeeded (fail if and only if there
     *         are conflict recipes).
     */
    public static boolean registerRecipe(CommonRecipe commonRecipe)
    {
	if (commonRecipe instanceof WorkbenchRecipe)
	    return workbenchRecipeHandler.addRecipe((WorkbenchRecipe) commonRecipe);
	else if (commonRecipe instanceof TechbenchRecipe)
	    return techbenchRecipeHandler.addRecipe((TechbenchRecipe) commonRecipe);
	else
	    return commonRecipeHandler.addRecipe(commonRecipe);
    }

    /**
     * To get the possible recipe for the input items.
     * 
     * @param itemIn
     *            The item used in the recipe.
     * @return The recipe object.
     */
    public static TechbenchRecipe getTechbenchRecipe(ItemStack[] itemIn)
    {
	return techbenchRecipeHandler.getRecipe(itemIn);
    }

}
