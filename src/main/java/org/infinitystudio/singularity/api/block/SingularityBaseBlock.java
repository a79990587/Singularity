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
package org.infinitystudio.singularity.api.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import org.infinitystudio.singularity.SingularityCreativeTabs;

/**
 * Singularity Base Block.
 *
 * @author Lasm_Gratel
 */
public class SingularityBaseBlock extends Block {

    /**
     * @param material Material of this block
     */
    public SingularityBaseBlock(Material material) {
        super(material);
        char[] name2=getClass().getName().toCharArray();
        name2[0]='b';
        setUnlocalizedName(String.copyValueOf(name2));
        setCreativeTab(SingularityCreativeTabs.tabSingularity);
    }
}
