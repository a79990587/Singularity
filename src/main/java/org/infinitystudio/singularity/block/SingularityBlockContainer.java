package org.infinitystudio.singularity.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;

/**
 * @author Blealtan
 */
public abstract class SingularityBlockContainer extends BlockContainer {

    private String name;

    /**
     * Instance a block.
     *
     * @param material
     *            The material
     * @param name
     *            The name of the block
     */
    public SingularityBlockContainer(Material material, String name) {
        super(material);
        this.name = name;
        this.setBlockName(name);
    }

    public String getName() {
        return name;
    }
}
