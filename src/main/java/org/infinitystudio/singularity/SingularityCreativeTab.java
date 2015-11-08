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
package org.infinitystudio.singularity;

import org.infinitystudio.singularity.block.TechbenchBlock;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

/**
 * @author Lasm_Gratel
 *
 */
public class SingularityCreativeTab extends CreativeTabs {

    private static SingularityCreativeTab creativeTab;

    /**
     * Initialize the creative tab.
     */
    public SingularityCreativeTab() {
	super("tabSingularity");
        SingularityCreativeTab.creativeTab = this;
    }

    /**
     * @see net.minecraft.creativetab.CreativeTabs#getTabIconItem()
     */
    @Override
    public Item getTabIconItem() {
	return new ItemBlock(new TechbenchBlock());
    }

    public static SingularityCreativeTab getCreativeTab() {
        return creativeTab;
    }
}
