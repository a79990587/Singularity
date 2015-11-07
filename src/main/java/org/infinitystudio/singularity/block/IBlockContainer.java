package org.infinitystudio.singularity.block;

import net.minecraft.tileentity.TileEntity;

/**
 * @author Blealtan
 */
public interface IBlockContainer extends IBlock {
    Class<? extends TileEntity> getTileEntityClass();
}
