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

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * Craft progress class.
 */
public class CommonRecipeHandler {
    public int totalRecipeId = 0;

    private Map<ItemStack[], CommonRecipe> recipeList = Maps.newHashMap();

    public boolean addRecipe(CommonRecipe commonRecipe) {
        if (recipeList.containsKey(commonRecipe.getIn()) || !commonRecipe.available) return false;

        commonRecipe.setID(this.totalRecipeId);
        recipeList.put(commonRecipe.getIn(), commonRecipe);
        this.totalRecipeId++;
        return true;
    }

    public CommonRecipe getRecipe(ItemStack[] in) {
        if (recipeList.containsKey(in)) return recipeList.get(in);
        return null;
    }

    public CommonRecipe getRecipeById(int id) {
        if (this.totalRecipeId < id) return null;

        for (Map.Entry<ItemStack[], CommonRecipe> r : recipeList.entrySet())
            if (r.getValue().getID() == id)
                return r.getValue();
        return null;
    }

    public CommonRecipe[] getAllRecipes() {
        return (CommonRecipe[]) recipeList.values().toArray();
    }
}
