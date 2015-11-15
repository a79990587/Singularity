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
package org.infinitystudio.singularity.block.fluid;

import org.infinitystudio.singularity.SingularityHandlers;
import org.infinitystudio.singularity.api.SingularityMaterial;
import org.infinitystudio.singularity.block.SingularityBaseBlockFluid;

import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

/**
 * @author Lasm_Gratel
 *
 */
public class BlockFluidAbyss extends SingularityBaseBlockFluid {

    public BlockFluidAbyss() {
	super(SingularityHandlers.fluidAbyss, SingularityMaterial.abyss);
    }

}
