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

import org.infinitystudio.singularity.SingularityCreativeTab;
import org.infinitystudio.singularity.api.Resource;

import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import org.infinitystudio.singularity.api.SingularityEnums;

/**
 * @author Lasm_Gratel
 *
 */
public abstract class MachineBlockContainer extends SingularityBlockContainer {
    private Resource produceResource;
    private Resource consumeResource;
    private Resource storageResource;
    private SingularityEnums.ResourceInteractType resourceInteractType;
    private boolean canProduce;

    /**
     * Instance a block.
     *
     * @param material
     *            The material
     * @param name
     *            The name of the block
     * @param resource
     *            Uses/Produce resource
     * @param resourceInteractType
     *            Whether this machine produce resource or consume resource?
     */
    public MachineBlockContainer(Material material, String name, SingularityCreativeTab creativeTab, Resource resource,
                                 SingularityEnums.ResourceInteractType resourceInteractType) {
        super(material, name, creativeTab);
        if (resourceInteractType == SingularityEnums.ResourceInteractType.Output)
            produceResource = resource;
        else
            consumeResource = resource;
        this.resourceInteractType = resourceInteractType;
    }

    public Resource getResource() {
        if (resourceInteractType == SingularityEnums.ResourceInteractType.Output)
            return produceResource;
        else
            return consumeResource;
    }

    public void setResource(Resource resource,
                            SingularityEnums.ResourceInteractType resourceInteractType) {
        if (resourceInteractType == SingularityEnums.ResourceInteractType.Output)
            produceResource = resource;
        else
            consumeResource = resource;
        this.resourceInteractType = resourceInteractType;
    }

    /**
     * @return storageResource
     */
    public Resource getStorageResource() {
        return storageResource;
    }

    /**
     * @param storageResource 要设置的 storageResource
     */
    public void setStorageResource(Resource storageResource) {
        this.storageResource = storageResource;
    }

    /**
     * @param storageResource 要增加的 storageResource
     */
    public void addStorageResource(Resource storageResource) {
        this.storageResource.setQuantity(storageResource.getQuantity() + this.storageResource.getQuantity());
    }

    /**
     * @param storageResource 要減少的 storageResource
     */
    public void delStorageResource(Resource storageResource) {
	this.storageResource.setQuantity(this.storageResource.getQuantity() - storageResource.getQuantity());
    }

    /**
     * @return resourceInteractType
     */
    public SingularityEnums.ResourceInteractType getResourceInteractType() {
        return resourceInteractType;
    }

    /**
     * @param resourceInteractType 要设置的 resourceInteractType
     */
    public void setResourceInteractType(SingularityEnums.ResourceInteractType resourceInteractType) {
        this.resourceInteractType = resourceInteractType;
    }

    /**
     * @return canProduce
     */
    public boolean canProduce() {
        return canProduce;
    }

    /**
     * @param canProduce 要设置的 canProduce
     */
    public void setCanProduce(boolean canProduce) {
        this.canProduce = canProduce;
    }

    /**
     * @see net.minecraft.block.ITileEntityProvider#createNewTileEntity(net.minecraft.world.World, int)
     */
    @Override
    public abstract TileEntity createNewTileEntity(World world, int p_149915_2_);

    /**
     * @return The class of the used TileEntity.
     */
    public abstract Class<? extends TileEntity> getTileEntityClass();
    
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
