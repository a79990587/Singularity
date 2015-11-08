/**
 * Singularity Mod for Minecraft. Copyright (C) 2015 Infinity Studio.
 * <p/>
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * <p/>
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * <p/>
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 *
 * @license GPLv3
 */
package org.infinitystudio.singularity.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import org.infinitystudio.singularity.SingularityCreativeTab;

/**
 * @author Blealtan
 */
public abstract class SingularityBlockContainer extends BlockContainer implements IBlockContainerBase {

    private String name;

    /**
     * Instance a block.
     *
     * @param material The material
     * @param name     The name of the block
     */
    public SingularityBlockContainer(Material material, String name, SingularityCreativeTab creativeTabs) {
        super(material);
        this.name = name;
        this.setBlockName(name);
        this.setBlockTextureName(name);
        this.setCreativeTab(creativeTabs);
    }

    public String getName() {
        return name;
    }

    public TileEntity createNewTileEntity(World world, int p_149915_2_) {
        try {
            return getTileEntityClass().newInstance();
        } catch (Throwable t) {
            return null;
        }
    }
}
