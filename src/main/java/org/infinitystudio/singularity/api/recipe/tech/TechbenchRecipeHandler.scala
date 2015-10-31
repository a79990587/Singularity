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
package org.infinitystudio.singularity.api.recipe.tech

import net.minecraft.item.ItemStack
import org.infinitystudio.singularity.api.recipe.{SingularityRecipe, SingularityRecipeHandler}

/**
 * Techbench craft recipes handler.
 * @author Blealtan
 */
object TechbenchRecipeHandler {
  val singularityRecipeHandler: SingularityRecipeHandler = new SingularityRecipeHandler

  def addRecipe(techbenchRecipe: TechbenchRecipe) = singularityRecipeHandler.addRecipe(techbenchRecipe.asInstanceOf[SingularityRecipe])

  def getRecipe(itemStack: Array[ItemStack]) = singularityRecipeHandler.getRecipe(itemStack).asInstanceOf[TechbenchRecipe]

  def getRecipeById(id: Int) = singularityRecipeHandler.getRecipeById(id).asInstanceOf[TechbenchRecipe]

  def getAllRecipes = singularityRecipeHandler.getAllRecipes
}
