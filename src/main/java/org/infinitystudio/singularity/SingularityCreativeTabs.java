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
package org.infinitystudio.singularity;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.infinitystudio.singularity.api.SingularityHandlers;
import org.infinitystudio.singularity.block.machine.BlockTechnologyBench;

/**
 * Singularity Creative Tab.
 *
 * @author Lasm_Gratel
 */
public abstract class SingularityCreativeTabs extends CreativeTabs {

    /**
     * Singularity Tab.
     */
    public static final CreativeTabs tabSingularity = new CreativeTabs("tabSingularity") {
        /**
         * Returns One Item in this mod.
         *
         * @return One Item in this mod
         */
        @SideOnly(Side.CLIENT)
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(SingularityHandlers.blockComputer);
        }

        /**
         * Returns the icon-item's damage.
         *
         * @return the icon-item's damage
         */
        @SideOnly(Side.CLIENT)
        @Override
        public int getIconItemDamage() {
            return 0;
        }
    };

    public SingularityCreativeTabs(String label) {
        super(label);
    }
}
