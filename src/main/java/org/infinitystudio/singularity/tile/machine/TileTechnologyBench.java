/**
 * Singularity Mod for Minecraft.
 * Copyright (C) 2015 Infinity Studio.
 * <p/>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * @license GPLv3
 */
package org.infinitystudio.singularity.tile.machine;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IChatComponent;
import org.infinitystudio.singularity.api.resource.Resource;
import org.infinitystudio.singularity.api.tile.SingularityBaseMachineTile;

/**
 * @author Lasm_Gratel
 */
public class TileTechnologyBench extends SingularityBaseMachineTile {

    private final byte LIMIT = 1;
    private final String NAME = "tileTechnologyBench";
    private ItemStack[] inventory = new ItemStack[6];
    private Resource resourceUsage;

    public TileTechnologyBench() {
        resourceUsage = new Resource(null, null);
    }

    /**
     * Returns the number of slots in the inventory.
     *
     * @return the number of slots in the inventory
     */
    @Override
    public int getSizeInventory() {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return inventory[index];
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        // TODO: Change the resourceUsage by checking Recipe list.
        return inventory[index].splitStack(count);
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int index) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        inventory[index] = stack;
        // TODO: Change the resourceUsage by checking Recipe list.
    }

    @Override
    public int getInventoryStackLimit() {
        return LIMIT;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return true;
    }

    @Override
    public void openInventory(EntityPlayer player) {

    }

    @Override
    public void closeInventory(EntityPlayer player) {

    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        if (index != inventory.length + 1) {
            return getRunningState();
        } else {
            return false;
        }
    }

    @Override
    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value) {

    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public IChatComponent getDisplayName() {
        return null;
    }

    @Override
    public Resource getResourceUsage() {
        return resourceUsage;
    }
}
