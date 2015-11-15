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
package org.infinitystudio.singularity.api;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

/**
 * @author Lasm_Gratel
 */
public class SingularityMaterial extends Material {

    public static final Material elder = new Material(MapColor.obsidianColor);
    public static final Material construct = new Material(MapColor.goldColor);
    public static final Material machine = new Material(MapColor.blueColor);
    public static final Material abyss = new Material(MapColor.blackColor);
    public static final Material source = new Material(MapColor.iceColor);
    
    public SingularityMaterial(MapColor color) {
        super(color);
    }

}
