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
package org.infinitystudio.singularity.block;

import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import org.infinitystudio.singularity.SingularityCreativeTab;
import org.infinitystudio.singularity.api.resource.ResourceNetConnector;
import org.infinitystudio.singularity.api.resource.ResourcePacket;

import java.util.Random;

/**
 * @author Lasm_Gratel
 *
 */
public abstract class MachineBlockContainer extends SingularityBlockContainer {
    public ResourceNetConnector connector;

    /**
     * Instance of a machine block.
     *
     * @param material
     *            The material
     * @param name
     *            The name of the block.
     * @param creativeTab
     *            The creative tab to be set.
     * @param produceResource
     *            The resource it produces per tick. Can be null.
     * @param consumeResource
     *            The resource it produces per tick. Can be null.
     * @param canProduce
     *            If it can produce resource. Once set to false, parameter
     *            produceResource will not work.
     */
    public MachineBlockContainer(Material material, String name, SingularityCreativeTab creativeTab,
                                 ResourcePacket produceResource, ResourcePacket consumeResource, boolean canProduce) {
        super(material, name, creativeTab);
        connector = new ResourceNetConnector();
        connector.setProduceResource(produceResource);
        connector.setConsumeResource(consumeResource);
        connector.setCanProduce(canProduce);
    }

    private void dropItems(World world, int x, int y, int z) {
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

                EntityItem entityItem = new EntityItem(world, x + rx, y + ry, z + rz,
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
