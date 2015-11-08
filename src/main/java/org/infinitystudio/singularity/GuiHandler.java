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

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import org.infinitystudio.singularity.container.ContainerTechbench;
import org.infinitystudio.singularity.tileentity.TileEntityTechbench;

/**
 * Gui Handler of Singularity.
 *
 * @author Lasm_Gratel
 */
public class GuiHandler implements IGuiHandler {

	/**
	 * Get the element of server's gui.
	 *
	 * @param ID
	 * @param player
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @return element a gui element.
	 * @see cpw.mods.fml.common.network.IGuiHandler#getServerGuiElement(int, net.minecraft.entity.player.EntityPlayer, net.minecraft.world.World, int, int, int)
	 */
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if (tileEntity instanceof TileEntityTechbench) {
			// Return a workbench's container
			return new ContainerTechbench(player.inventory, (TileEntityTechbench) tileEntity);
		}
		return null;
	}

	/**
	 * Get the element of client's gui.
	 *
	 * @param ID
	 * @param player
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @return element a gui element.
	 * @see cpw.mods.fml.common.network.IGuiHandler#getClientGuiElement(int, net.minecraft.entity.player.EntityPlayer, net.minecraft.world.World, int, int, int)
	 */
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if (tileEntity instanceof TileEntityTechbench) {
			// Return a workbench's container
			return new ContainerTechbench(player.inventory, (TileEntityTechbench) tileEntity);
		}
		return null;
	}

	/**
	 * Get the element of client/server's gui.
	 *
	 * @param ID
	 * @param player
	 * @param world
	 * @param x
	 * @param y
	 * @param z
	 * @return element a gui element.
	 */
	@Deprecated
	public Object getCommonGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		//TODO More code so it can be useful
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if (tileEntity instanceof TileEntityTechbench) {
			// Return a workbench's container
			return new ContainerTechbench(player.inventory, (TileEntityTechbench) tileEntity);
		}
		return null;
	}

}
