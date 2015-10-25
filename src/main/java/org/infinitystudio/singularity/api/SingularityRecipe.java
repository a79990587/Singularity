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

import net.minecraft.item.ItemStack;

/**
 * Craft Recipes.
 * @author Lasm_Gratel
 *
 */
public class SingularityRecipe {

    /**
     * @id   "系统分配 合成表唯一ID"
     * @in   "输入的物品"
     * @out  "输出的物品"
     * @cost "能量消耗"
     * @type "机器种类"
     */

    private int id;
    private ItemStack[] in;
    private ItemStack[] out;
    private int cost;
    private Class type;

    public SingularityRecipe(ItemStack[] in, ItemStack[] out, int cost, Class type) {
        this.in = in;
        this.out = out;
        this.cost = cost;
        this.type = type;
    }

    public Class getType() {
        return type;
    }

    public ItemStack[] getOut() {
        return out;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
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
