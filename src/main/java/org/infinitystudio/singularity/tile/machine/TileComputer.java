package org.infinitystudio.singularity.tile.machine;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IChatComponent;
import org.infinitystudio.singularity.item.ItemComputerCoprocessor;
import org.infinitystudio.singularity.tile.SingularityBaseInventory;
import org.infinitystudio.singularity.tile.SingularityBaseTileEntity;

/**
 * @author Blealtan
 */
public class TileComputer  extends SingularityBaseTileEntity implements IInventory {
    private final byte LIMIT = 16;
    private final String NAME = "tileComputer";
    private ItemStack inventory;
    private boolean isWorking = false;

    /**
     * Returns the number of slots in the inventory.
     * @return the number of slots in the inventory
     */
    @Override
    public int getSizeInventory() {
        return 1;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        return inventory;
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        return inventory.splitStack(count);
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int index) {
        return null;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        inventory = stack;
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
        return (stack.getItem() instanceof ItemComputerCoprocessor);
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

}
