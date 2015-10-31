/**
 * Singularity Mod for Minecraft. Copyright (C) 2015 Infinity Studio.
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 * 
 * @license GPLv3
 */
package org.infinitystudio.singularity.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * @author Lasm_Gratel
 *
 */
public abstract class MachineBlock extends SingularityBlock
{
    private int produceEnergy = -1;
    private int consumeEnergy = -1;
    private int storageEnergy = 0;
    private boolean outputOrInput;

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
    public MachineBlock(Material material, String name, int energy, boolean outputOrInput)
    {
	super(material, name);
	if (outputOrInput)
	    produceEnergy = energy;
	else
	    consumeEnergy = energy;
	this.outputOrInput = outputOrInput;
    }

    public int getEnergy()
    {
	if (outputOrInput)
	    return produceEnergy;
	else
	    return consumeEnergy;
    }

    public void setEnergy(int energy, boolean outputOrInput)
    {
	if (outputOrInput)
	    produceEnergy = energy;
	else
	    consumeEnergy = energy;
	this.outputOrInput = outputOrInput;
    }

    /**
     * @return storageEnergy
     */
    public int getStorageEnergy()
    {
	return storageEnergy;
    }

    /**
     * @param storageEnergy
     *            要设置的 storageEnergy
     */
    public void setStorageEnergy(int storageEnergy)
    {
	this.storageEnergy = storageEnergy;
    }

    /**
     * @param storageEnergy
     *            要增加的 storageEnergy
     */
    public void addStorageEnergy(int storageEnergy)
    {
	this.storageEnergy += storageEnergy;
    }

    /**
     * @param storageEnergy
     *            要減少的 storageEnergy
     */
    public void delStorageEnergy(int storageEnergy)
    {
	this.storageEnergy -= storageEnergy;
    }
}
