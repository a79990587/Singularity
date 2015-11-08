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
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import org.infinitystudio.singularity.SingularityCreativeTab;
import org.infinitystudio.singularity.api.resource.Resource;
import org.infinitystudio.singularity.api.resource.Resource.ResourceType;
import org.infinitystudio.singularity.api.resource.ResourcePacket;
import org.infinitystudio.singularity.tileentity.TileEntityWorkbench;

/**
 * @author Lasm_Gratel
 */
public class TechbenchBlock extends MachineBlockContainer {
    /**
     * Constructor of the special workbench
     */
    public TechbenchBlock() {
        super(Material.iron, "machineWorkbench", SingularityCreativeTab.getCreativeTab(),
                null, new ResourcePacket(new Resource(ResourceType.test1, 100)), false);
        this.setHarvestLevel("", 2);
    }

    /**
     * @see MachineBlockContainer#createNewTileEntity(net.minecraft.world.World, int)
     */
    @Override
    public TileEntity createNewTileEntity(World world, int p_149915_2_) {
        return new TileEntityWorkbench();
    }

    /**
     * @return TileEntityWorkbench.class
     * @see MachineBlockContainer#getTileEntityClass()
     */
    public Class<? extends TileEntity> getTileEntityClass() {
        return TileEntityWorkbench.class;
    }
}
