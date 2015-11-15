package org.infinitystudio.singularity.api.item;

import net.minecraft.item.Item;
import org.infinitystudio.singularity.SingularityCreativeTabs;

/**
 * @author Blealtan
 */
public abstract class SingularityBaseItem extends Item {
    public SingularityBaseItem() {
        super();
        char[] name2=getClass().getName().toCharArray();
        name2[0]='b';
        setUnlocalizedName(String.copyValueOf(name2));
        setCreativeTab(SingularityCreativeTabs.tabSingularity);
    }
}
