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
package org.infinitystudio.singularity.fluid;

import org.infinitystudio.singularity.SingularityHandlers;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;

/**
 * Abyss Fluid.
 * Viscosity is 3000 (use 3000 ticks to flow)
 * Density is 10000 (
 * @author Lasm_Gratel
 */
public class FluidAbyss extends SingularityBaseFluid {

    protected static final ResourceLocation still = new ResourceLocation("singularity", "textures/fluid/abyssStill.png");
    protected static final ResourceLocation flowing = new ResourceLocation("singularity", "textures/fluid/abyssFlowing.png");
    protected Block block = SingularityHandlers.blockTechnologyBench;
    
    public FluidAbyss() {
	super("fluidAbyss", still, flowing);
	setViscosity(3000);
	setDensity(10000);
	setBlock(block);
    }

}
