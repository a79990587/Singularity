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

import org.infinitystudio.singularity.SingularityCreativeTabs;
import org.infinitystudio.singularity.api.Energy;
import org.infinitystudio.singularity.api.Energy.EnergyType;
import org.infinitystudio.singularity.tileentity.TileEntityWorkbench;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * @author Lasm_Gratel
 *
 */
public class Workbench extends MachineBlockContainer {
    private static Energy produceEnergy = new Energy(EnergyType.test1, 100);
    private Energy consumeEnergy = null;
    private Energy storageEnergy = new Energy(EnergyType.test1, 0);
    private static boolean outputOrInput = false;
    private boolean canProduce = false;

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
    public Workbench() {
        super(Material.iron, "workbench", produceEnergy, outputOrInput);
        this.setCreativeTab(new SingularityCreativeTabs());
        this.setBlockName("machineWorkbench");
        this.setBlockTextureName("machineWorkbench");
        this.setHarvestLevel("", 2);
    }

    /*
     * @see org.infinitystudio.singularity.block.MachineBlockContainer#createNewTileEntity(net.minecraft.world.World, int)
     */
    @Override
    public TileEntity createNewTileEntity(World world, int p_149915_2_) {
	return new TileEntityWorkbench();
    }

}
