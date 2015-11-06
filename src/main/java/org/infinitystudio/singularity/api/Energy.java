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
package org.infinitystudio.singularity.api;

/**
 * @author Lasm_Gratel
 *
 */
public class Energy {
    private int energy;
    private EnergyType energyType;

    /**
     * @param energyType Type of the energy
     * @param energy Energy num
     */
    public Energy(EnergyType energyType, int energy) {
	this.energyType = energyType;
	this.energy = energy;
    }

    public enum EnergyType {
	test1, test2, test3, test4, test5, test6
    }

    /**
     * @return energy
     */
    public int getEnergy() {
        return energy;
    }

    /**
     * @param energy 要设置的 energy
     */
    public void setEnergy(int energy) {
        this.energy = energy;
    }

    /**
     * @return energyType
     */
    public EnergyType getEnergyType() {
        return energyType;
    }

    /**
     * @param energyType 要设置的 energyType
     */
    public void setEnergyType(EnergyType energyType) {
        this.energyType = energyType;
    }
}
