/**
 *  Singularity Mod for Minecraft.
 *  Copyright (C) 2015 Infinity Studio.
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *  @license GPLv3
*/
package org.infinitystudio.singularity.api;

import org.infinitystudio.singularity.api.recipe.SingularityRecipeHandler;
import org.infinitystudio.singularity.block.SingularityBlock;
import org.infinitystudio.singularity.item.SingularityItem;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * The Singularity Mod's Registery.
 * @author Darkhighness
 *
 */
public class SingularityRegistery extends GameRegistry {
    public static void registerIngotWithOreDictionary(SingularityItem Ingot) {
        OreDictionary.registerOre(Ingot.getName(), Ingot);
    }

    public static void registerBlockWithOreDictionary(SingularityBlock Block) {
        OreDictionary.registerOre(Block.getName(), Block);
    }

    public static boolean addRecipe(SingularityRecipe singularityRecipe) {
       return SingularityRecipeHandler.addRecipe(singularityRecipe);
    }

    public static SingularityRecipe getRecipe(ItemStack[] in) {
        return SingularityRecipeHandler.getRecipe(in);
    }

    public static SingularityRecipe getRecipeById(int id) {
        return SingularityRecipeHandler.getRecipeById(id);
    }

    public static SingularityRecipe[] getAllRecipes() {
        return SingularityRecipeHandler.getAllRecipes();
    }

}
