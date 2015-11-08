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
package org.infinitystudio.singularity.api.recipe;

import net.minecraft.item.ItemStack;

/**
 * Craft recipes.
 *
 * @author Lasm_Gratel
 */
public class CommonRecipe {

	public boolean available;
	// Unique id
	private int id;
	// Input items
	private ItemStack[] in;
	// Output items
	private ItemStack[] out;

	public CommonRecipe(ItemStack[] in, ItemStack[] out) {
		this.in = in;
		this.out = out;
		available = true;
	}

	/**
	 * @return The id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id The id to be set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return The input items
	 */
	public ItemStack[] getIn() {
		return in;
	}

	/**
	 * @param in The input items to be set
	 */
	public void setIn(ItemStack[] in) {
		this.in = in;
	}

	/**
	 * @return The output items
	 */
	public ItemStack[] getOut() {
		return out;
	}

	/**
	 * @param out The output items to be set
	 */
	public void setOut(ItemStack[] out) {
		this.out = out;
	}

	/**
	 * @return The Handler of this recipe
	 */
	public Class<? extends CommonRecipeHandler> getHandler() {
		return CommonRecipeHandler.class;
	}
}
