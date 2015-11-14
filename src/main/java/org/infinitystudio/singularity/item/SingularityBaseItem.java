package org.infinitystudio.singularity.item;

import net.minecraft.item.Item;
import org.infinitystudio.singularity.SingularityCreativeTabs;

/**
 * @author Blealtan
 */
public abstract class SingularityBaseItem extends Item {
    public SingularityBaseItem() {
        super();
        char[] name = getClass().getName().toCharArray();
        name[0] = 'i';
        setUnlocalizedName(String.valueOf(name));
        setCreativeTab(SingularityCreativeTabs.tabSingularity);
    }
}
