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
import org.infinitystudio.singularity.block.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Singularity Mod Main.
 * @author Lasm_Gratel
 * @author Blealtan
 * @author DarkHighness
 * @author zzzz
 */
@Mod(modid = Singularity.MODID, name = Singularity.NAME, version = Singularity.VERSION)
public class Singularity {
    public static final String MODID = "singularity";
    public static final String NAME = "Singularity";
    public static final String VERSION = "1.0";

    // Instance of this mod
    @Instance("Singularity")
    public static Singularity instance;

    // Logger of this mod
    public static Logger log;

    // Blocks of this mod
    public static List<IBlockBase> blocks;

    // CreativeTabs of this mod
    public static Map<String, SingularityCreativeTab> creativeTabs;

    /**
     * Pre-Initialization Event of FML.
     * Will happen in Pre-Initialization State.
     * @param event 
     */
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
	
	// Create creative tab,
        creativeTabs = new HashMap<String, SingularityCreativeTab>();
        creativeTabs.put("tabSingularity", new SingularityCreativeTab("tabSingularity"));
        
        // Get log of the Forge.
        log = event.getModLog();

        log.debug("[Singularity] Add Blocks...");
        blocks = new ArrayList<IBlockBase>();

        // Add *ALL* Machine Blocks Here.
        blocks.add(new TechbenchBlock());

        // Registry All block in Singularity.
        for (IBlockBase block : blocks) {
            if (block instanceof IBlockContainerBase) {
                SingularityBlockContainer b = (SingularityBlockContainer) block;
                SingularityRegistry.registerBlock(b, ItemBlock.class, b.getName());
                SingularityRegistry.registerTileEntity(b.getTileEntityClass(), b.getName());
            } else {
                SingularityBlock b = (SingularityBlock) block;
                SingularityRegistry.registerBlock(b, ItemBlock.class, b.getName());
            }
        }

        log.debug("[Singularity] Registring GUI Handler...");
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    }

    /**
     * Initialization Event of FML.
     * Will happen in Initialization State.
     * @param event 
     */
    @EventHandler
    public void init(FMLInitializationEvent event) {
	//TODO Register Machine Custom Recipes
    }
}
