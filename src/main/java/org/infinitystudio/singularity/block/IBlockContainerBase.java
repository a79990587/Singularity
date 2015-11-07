package org.infinitystudio.singularity.block;

import net.minecraft.tileentity.TileEntity;

/**
 * @author Blealtan
 */
public interface IBlockContainerBase extends IBlockBase {
    Class<? extends TileEntity> getTileEntityClass();
}
