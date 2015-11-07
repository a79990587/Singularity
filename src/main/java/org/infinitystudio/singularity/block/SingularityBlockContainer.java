package org.infinitystudio.singularity.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import org.infinitystudio.singularity.SingularityCreativeTab;

/**
 * @author Blealtan
 */
public abstract class SingularityBlockContainer extends BlockContainer implements IBlockContainer {

    private String name;

    /**
     * Instance a block.
     *
     * @param material
     *            The material
     * @param name
     *            The name of the block
     */
    public SingularityBlockContainer(Material material, String name, SingularityCreativeTab creativeTabs) {
        super(material);
        this.name = name;
        this.setBlockName(name);
        this.setBlockTextureName(name);
        this.setCreativeTab(creativeTabs);
    }

    public String getName() {
        return name;
    }

    public TileEntity createNewTileEntity(World world, int p_149915_2_) {
        try {
            return getTileEntityClass().newInstance();
        } catch (Throwable t) {
            return null;
        }
    }
}
