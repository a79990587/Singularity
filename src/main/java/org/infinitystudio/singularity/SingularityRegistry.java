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

import org.apache.logging.log4j.Level;

import com.google.common.base.Strings;
import com.google.common.base.Throwables;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.registry.GameData;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Registry of Singularity.
 * @author Lasm_Gratel
 */
public class SingularityRegistry extends GameRegistry {
    
    /**
     * Register a block with the specified mod specific name
     * @param block The block to register
     * @param name The mod-unique name to register it as, will get prefixed by your modid.
     */
    public static Block registerBlock(Block block, String name)
    {
	OreDictionary.registerOre(name, block);
        return registerBlock(block, ItemBlock.class, name);
    }
    
    /**
     * Register an item with the item registry with a custom name : this allows for easier server->client resolution
     *
     * @param item The item to register
     * @param name The mod-unique name of the item
     */
    public static void registerItem(Item item, String name)
    {
	OreDictionary.registerOre(name, item);
        registerItem(item, name, null);
    }
    
    /**
     * Makes an {@link ItemStack} based on the itemName reference, with supplied meta, stackSize and nbt, if possible
     *
     * Will return null if the item doesn't exist (because it's not from a loaded mod for example)
     * Will throw a {@link RuntimeException} if the nbtString is invalid for use in an {@link ItemStack}
     *
     * @param itemName a registry name reference
     * @param meta the meta
     * @param stackSize the stack size
     * @param nbtString an nbt stack as a string, will be processed by {@link JsonToNBT}
     * @return a new itemstack
     */
    public static ItemStack makeItemStack(String itemName, int meta, int stackSize, String nbtString)
    {
        if (itemName == null) throw new IllegalArgumentException("The itemName cannot be null");
        Item item = OreDictionary.getOres(itemName).get(0).getItem();
        if (item == null) {
            FMLLog.getLogger().log(Level.TRACE, "Unable to find item with name {}", itemName);
            return null;
        }
        ItemStack is = new ItemStack(item, 1, meta);
        if (!Strings.isNullOrEmpty(nbtString)) {
            NBTBase nbttag = null;
            try
            {
                nbttag = JsonToNBT.func_180713_a(nbtString);
            } catch (NBTException e)
            {
                FMLLog.getLogger().log(Level.WARN, "Encountered an exception parsing ItemStack NBT string {}", nbtString, e);
                throw Throwables.propagate(e);
            }
            if (!(nbttag instanceof NBTTagCompound)) {
                FMLLog.getLogger().log(Level.WARN, "Unexpected NBT string - multiple values {}", nbtString);
                throw new RuntimeException("Invalid NBT JSON");
            } else {
                is.setTagCompound((NBTTagCompound) nbttag);
            }
        }
        return is;
    }
    
}
