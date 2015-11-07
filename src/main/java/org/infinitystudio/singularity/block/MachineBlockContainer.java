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
package org.infinitystudio.singularity.block;

import java.util.Random;

import org.infinitystudio.singularity.api.Energy;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * @author Lasm_Gratel
 *
 */
public abstract class MachineBlockContainer extends BlockContainer {
    private Energy produceEnergy;
    private Energy consumeEnergy;
    private Energy storageEnergy;
    private boolean outputOrInput;
    private boolean canProduce;

    /**
     * Instance a block.
     *
     * @param material
     *            The material
     * @param name
     *            The name of the block
     * @param energy
     *            Uses/Produce energy
     * @param outputOrInput
     *            Whether this machine produce energy or consume energy?
     */
    public MachineBlockContainer(Material material, String name, Energy energy, boolean outputOrInput) {
        super(material);
        if (outputOrInput)
            produceEnergy = energy;
        else
            consumeEnergy = energy;
        this.outputOrInput = outputOrInput;
    }

    public Energy getEnergy() {
        if (outputOrInput)
            return produceEnergy;
        else
            return consumeEnergy;
    }

    public void setEnergy(Energy energy, boolean outputOrInput) {
        if (outputOrInput)
            produceEnergy = energy;
        else
            consumeEnergy = energy;
        this.outputOrInput = outputOrInput;
    }

    /**
     * @return storageEnergy
     */
    public Energy getStorageEnergy() {
        return storageEnergy;
    }

    /**
     * @param storageEnergy
     *            要设置的 storageEnergy
     */
    public void setStorageEnergy(Energy storageEnergy) {
        this.storageEnergy = storageEnergy;
    }

    /**
     * @param storageEnergy
     *            要增加的 storageEnergy
     */
    public void addStorageEnergy(Energy storageEnergy) {
        this.storageEnergy.setEnergy(storageEnergy.getEnergy()+this.storageEnergy.getEnergy());
    }

    /**
     * @param storageEnergy
     *            要減少的 storageEnergy
     */
    public void delStorageEnergy(Energy storageEnergy) {
	this.storageEnergy.setEnergy(this.storageEnergy.getEnergy()-storageEnergy.getEnergy());
    }

    /**
     * @return outputOrInput
     */
    public boolean isOutputOrInput() {
        return outputOrInput;
    }

    /**
     * @param outputOrInput 要设置的 outputOrInput
     */
    public void setOutputOrInput(boolean outputOrInput) {
        this.outputOrInput = outputOrInput;
    }

    /**
     * @return canProduce
     */
    public boolean isCanProduce() {
        return canProduce;
    }

    /**
     * @param canProduce 要设置的 canProduce
     */
    public void setCanProduce(boolean canProduce) {
        this.canProduce = canProduce;
    }
    /*
     * @see net.minecraft.block.ITileEntityProvider#createNewTileEntity(net.minecraft.world.World, int)
     */
    @Override
    public abstract TileEntity createNewTileEntity(World world, int p_149915_2_);
    
    private void dropItems(World world, int x, int y, int z){
        Random rand = new Random();

        TileEntity tileEntity = world.getTileEntity(x, y, z);
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

                        EntityItem entityItem = new EntityItem(world,
                                        x + rx, y + ry, z + rz,
                                        new ItemStack(item.getItem(), item.stackSize, item.getItemDamage()));

                        if (item.hasTagCompound()) {
                                entityItem.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
                        }

                        float factor = 0.05F;
                        entityItem.motionX = rand.nextGaussian() * factor;
                        entityItem.motionY = rand.nextGaussian() * factor + 0.2F;
                        entityItem.motionZ = rand.nextGaussian() * factor;
                        world.spawnEntityInWorld(entityItem);
                        item.stackSize = 0;
                }
        }
}
}
