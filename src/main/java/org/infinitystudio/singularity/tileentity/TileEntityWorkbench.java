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
package org.infinitystudio.singularity.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

/**
 * @author Lasm_Gratel
 *
 */
public class TileEntityWorkbench extends TileEntity implements IInventory {

    private ItemStack[] inv;
    
    /**
     * 
     */
    public TileEntityWorkbench() {
	inv=new ItemStack[9];
    }

    /**
     * @see net.minecraft.inventory.IInventory#getSizeInventory()
     */
    @Override
    public int getSizeInventory() {
	return inv.length;
    }

    /**
     * @see net.minecraft.inventory.IInventory#getStackInSlot(int)
     */
    @Override
    public ItemStack getStackInSlot(int slot) {
	return inv[slot];
    }

    /**
     * @see net.minecraft.inventory.IInventory#decrStackSize(int, int)
     */
    @Override
    public ItemStack decrStackSize(int slot, int amt) {
        ItemStack stack = getStackInSlot(slot);
        if (stack != null) {
                if (stack.stackSize <= amt) {
                        setInventorySlotContents(slot, null);
                } else {
                        stack = stack.splitStack(amt);
                        if (stack.stackSize == 0) {
                                setInventorySlotContents(slot, null);
                        }
                }
        }
        return stack;
    }

    /**
     * @see net.minecraft.inventory.IInventory#getStackInSlotOnClosing(int)
     */
    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        ItemStack stack = getStackInSlot(slot);
        if (stack != null) {
                setInventorySlotContents(slot, null);
        }
        return stack;
    }

    /**
     * @see net.minecraft.inventory.IInventory#setInventorySlotContents(int, net.minecraft.item.ItemStack)
     */
    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        inv[slot] = stack;
        if (stack != null && stack.stackSize > getInventoryStackLimit()) {
                stack.stackSize = getInventoryStackLimit();
        }
    }

    /**
     * @see net.minecraft.inventory.IInventory#getInventoryName()
     */
    @Override
    public String getInventoryName() {
	return "singularity.tileentityworkbrench";
    }

    /**
     * @see net.minecraft.inventory.IInventory#hasCustomInventoryName()
     */
    @Override
    public boolean hasCustomInventoryName() {
	return true;
    }

    /**
     * @see net.minecraft.inventory.IInventory#getInventoryStackLimit()
     */
    @Override
    public int getInventoryStackLimit() {
	return 64;
    }

    /**
     * @see net.minecraft.inventory.IInventory#isUseableByPlayer(net.minecraft.entity.player.EntityPlayer)
     */
    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
    }

    /**
     * @see net.minecraft.inventory.IInventory#openInventory()
     */
    @Override
    public void openInventory() {
	
    }

    /**
     * @see net.minecraft.inventory.IInventory#closeInventory()
     */
    @Override
    public void closeInventory() {
	
    }

    /**
     * @see net.minecraft.inventory.IInventory#isItemValidForSlot(int, net.minecraft.item.ItemStack)
     */
    @Override
    public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
	return true;
    }

}
