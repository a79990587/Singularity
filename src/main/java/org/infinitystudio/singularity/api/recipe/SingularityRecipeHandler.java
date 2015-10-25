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
package org.infinitystudio.singularity.api.recipe;

import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

import org.infinitystudio.singularity.api.SingularityRecipe;

import com.google.common.collect.Maps;

/**
 * Craft progress class.
 */
public class SingularityRecipeHandler {
    public static int totalRecipeId = 0;

    private static Map<ItemStack[], SingularityRecipe> recipeList = Maps.newHashMap();

    public static boolean addRecipe(SingularityRecipe singularityRecipe) {
        if (recipeList.containsKey(singularityRecipe.getIn())) {
            return false;
        }
        singularityRecipe.setID(SingularityRecipeHandler.totalRecipeId);
        recipeList.put(singularityRecipe.getIn(), singularityRecipe);
        SingularityRecipeHandler.totalRecipeId++;
        return true;

    }

    public static SingularityRecipe getRecipe(ItemStack[] in) {
        if (recipeList.containsKey(in)) {
            SingularityRecipe Result = recipeList.get(in);
        }
        return null;
    }

    public static SingularityRecipe getRecipeById(int id) {
        if (SingularityRecipeHandler.totalRecipeId < id) {
            return null;
        }

        for (Map.Entry<ItemStack[], SingularityRecipe> r : recipeList.entrySet()) {
            if (r.getValue().getID() == id) {
                return r.getValue();
            }
        }
        return null;
    }

    public static SingularityRecipe[] getAllRecipes() {
        return ((SingularityRecipe[]) recipeList.values().toArray());
    }
}
