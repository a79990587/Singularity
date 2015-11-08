package org.infinitystudio.singularity.api.recipe.tech;

import net.minecraft.item.ItemStack;
import org.infinitystudio.singularity.api.recipe.CommonRecipeHandler;

/**
 * @author Blealtan
 */
public class TechbenchRecipeHandler extends CommonRecipeHandler {
	/**
	 * Initialise the handler.
	 */
	public TechbenchRecipeHandler() {
		super();
	}

	/**
	 * Add a techbench recipe
	 *
	 * @param techbenchRecipe The recipe to be added
	 * @return Whether the addition is successful
	 */
	public boolean addRecipe(TechbenchRecipe techbenchRecipe) {
		return super.addRecipe(techbenchRecipe);
	}

	/**
	 * Get a techbench recipe
	 *
	 * @param in The input of the recipe
	 * @return The wanted recipe, null if not match any
	 */
	public TechbenchRecipe getRecipe(ItemStack[] in) {
		return (TechbenchRecipe) super.getRecipe(in);
	}

	/**
	 * Get a techbench recipe by id
	 *
	 * @param id The id of the recipe
	 * @return The wanted recipe, null if not match any
	 */
	public TechbenchRecipe getRecipeById(int id) {
		return (TechbenchRecipe) super.getRecipeById(id);
	}

	/**
	 * Get the array of all exist recipes
	 *
	 * @return All exist recipes
	 */
	public TechbenchRecipe[] getAllRecipes() {
		return (TechbenchRecipe[]) super.getAllRecipes();
	}
}
