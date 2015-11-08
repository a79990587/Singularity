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
package org.infinitystudio.singularity.api.recipe;

import net.minecraft.item.ItemStack;

/**
 * Craft recipes.
 *
 * @author Lasm_Gratel
 */
public class CommonRecipe {

    public boolean available;
    //Only one id
    private int id;
    //Input
    private ItemStack[] in;
    //Output
    private ItemStack[] out;

    public CommonRecipe(ItemStack[] in, ItemStack[] out) {
        this.in = in;
        this.out = out;
        available = true;
    }

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id 要设置的 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return in
     */
    public ItemStack[] getIn() {
        return in;
    }

    /**
     * @param in 要设置的 in
     */
    public void setIn(ItemStack[] in) {
        this.in = in;
    }

    /**
     * @return out
     */
    public ItemStack[] getOut() {
        return out;
    }

    /**
     * @param out 要设置的 out
     */
    public void setOut(ItemStack[] out) {
        this.out = out;
    }
    
}
