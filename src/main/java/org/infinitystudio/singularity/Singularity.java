/**
 * Singularity Mod for Minecraft. Copyright (C) 2015 Infinity Studio.
 * <p/>
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * <p/>
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * <p/>
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 *
 * @license GPLv3
 */
package org.infinitystudio.singularity;


import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.item.ItemBlock;

import org.apache.logging.log4j.Logger;
import org.infinitystudio.singularity.api.SingularityRegistry;
import org.infinitystudio.singularity.block.IMachineBlock;
import org.infinitystudio.singularity.block.MachineBlock;
import org.infinitystudio.singularity.block.MachineBlockContainer;
import org.infinitystudio.singularity.tileentity.TileEntityWorkbench;

import java.util.List;

/**
 * @author Lasm_Gratel Singularity Mod Main.
 */
@Mod(modid = Singularity.MODID, name = Singularity.MODID, version = Singularity.VERSION)
public class Singularity {
    public static final String MODID = "singularity";
    public static final String NAME = "Singularity";
    public static final String VERSION = "1.0";
    
    @Instance("Singularity")
    public static Singularity instance;
    
    public static Logger log;
    
    public static List<IMachineBlock> machineBlocks;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        log = event.getModLog();

        for (IMachineBlock m : machineBlocks)
        {
            if (m instanceof MachineBlockContainer) {
                MachineBlockContainer mbc = (MachineBlockContainer) m;
                SingularityRegistry.registerBlock(mbc, ItemBlock.class, mbc.getName());
                SingularityRegistry.registerTileEntity(mbc.getTileEntityClass(), mbc.getName());
            }
            else if (m instanceof MachineBlock) {
                MachineBlock mb = (MachineBlock) m;
                SingularityRegistry.registerBlock(mb, ItemBlock.class, mb.getName());
            }
        }

        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
	
    }
}
