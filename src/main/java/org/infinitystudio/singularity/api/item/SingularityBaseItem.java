package org.infinitystudio.singularity.api.item;

import net.minecraft.item.Item;
import org.infinitystudio.singularity.SingularityCreativeTabs;

/**
 * @author Blealtan
 */
public abstract class SingularityBaseItem extends Item {
    public SingularityBaseItem(String name) {
        super();
        setUnlocalizedName(String.valueOf(name));
        setCreativeTab(SingularityCreativeTabs.tabSingularity);
    }
}
