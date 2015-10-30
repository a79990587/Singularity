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

/**
 * Craft recipes.
 * @author Lasm_Gratel
 */
public class SingularityRecipe {

    // 系统分配 合成表唯一ID
    private int id;
    // 输入的物品
    private ItemStack[] in;
    // 输出的物品
    private ItemStack[] out;

    public SingularityRecipe(ItemStack[] in, ItemStack[] out) {
        this.in = in;
        this.out = out;
    }

    public ItemStack[] getOut() {
        return out;
    }

    public void setOut(ItemStack[] out) {
        this.out = out;
    }

    public ItemStack[] getIn() {
        return in;
    }

    public void setIn(ItemStack[] in) {
        this.in = in;
    }

    public int getID() {
        return id;
    }

    public void setID(int ID) {
        this.id = ID;
    }
}
