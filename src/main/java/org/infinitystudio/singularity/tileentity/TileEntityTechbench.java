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
package org.infinitystudio.singularity.tileentity;

import java.util.Random;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * An Inventory TileEntity. There is 6 slots: slot1 slot2 slot3 slot4 slot5
 * |-------|-----|-----|-----| | slot6
 * 
 * @author Lasm_Gratel
 */
public class TileEntityTechbench extends TileEntity implements IInventory {

    private ItemStack[] inv;

    /**
     *
     */
    public TileEntityTechbench() {
	inv = new ItemStack[6];
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
     * @see net.minecraft.inventory.IInventory#setInventorySlotContents(int,
     *      net.minecraft.item.ItemStack)
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
	return 1;
    }

    /**
     * @see net.minecraft.inventory.IInventory#isUseableByPlayer(net.minecraft.entity.player.EntityPlayer)
     */
    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
	return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this
		&& player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
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
	Random rand = new Random();

	TileEntity tileEntity = worldObj.getTileEntity(xCoord, yCoord, zCoord);
	if (!(tileEntity instanceof IInventory)) {
	    return;
	}
	IInventory inventory = (IInventory) tileEntity;

	for (int i = 0; i < inventory.getSizeInventory(); i++) {
	    ItemStack item = inventory.getStackInSlot(i);

	    if (item != null && item.stackSize > 0) {
		float rx = rand.nextFloat() * 0.8F + 0.1F;
		float ry = rand.nextFloat() * 0.8F + 0.1F;
		float rz = rand.nextFloat() * 0.8F + 0.1F;

		EntityItem entityItem = new EntityItem(worldObj, xCoord + rx, yCoord + ry, zCoord + rz,
			new ItemStack(item.getItem(), item.stackSize, item.getItemDamage()));

		if (item.hasTagCompound()) {
		    entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
		}

		float factor = 0.05F;
		entityItem.motionX = rand.nextGaussian() * factor;
		entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
		entityItem.motionZ = rand.nextGaussian() * factor;
		worldObj.spawnEntityInWorld(entityItem);
		item.stackSize = 0;
	    }
	}
    }

    /**
     * @param slot
     *            Player selected slot.
     * @param itemstack
     *            Things in slot.
     * @see net.minecraft.inventory.IInventory#isItemValidForSlot(int,
     *      net.minecraft.item.ItemStack)
     */
    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
	if (slot == 6) {
	    return false;
	}
	return true;
    }

}
