package org.infinitystudio.singularity.api.recipe.tech;

import net.minecraft.item.ItemStack;
import org.infinitystudio.singularity.api.recipe.CommonRecipe;
import org.infinitystudio.singularity.api.resource.ResourcePacket;

/**
 * Techbench craft recipes.
 *
 * @author Blealtan
 */
public class TechbenchRecipe extends CommonRecipe {

    ResourcePacket cost;

    /**
     * Initialisation of a techbench recipe.
     *
     * @param in   Input ItemStack
     * @param out  Output ItemStack
     * @param cost Cost resource
     */
    TechbenchRecipe(ItemStack[] in, ItemStack[] out, ResourcePacket cost) {
        super(in, out);
        this.cost = cost;
    }

    /**
     * Get the cost.
     *
     * @return The cost.
     */
    public ResourcePacket getCost() {
        return cost;
    }

    /**
     * Set the cost.
     *
     * @param cost The cost.
     */
    public void setCost(ResourcePacket cost) {
        this.cost = cost;
    }
}
