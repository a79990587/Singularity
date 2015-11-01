/**
 * Singularity Mod for Minecraft. Copyright (C) 2015 Infinity Studio.
 *
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 * 
 * @license GPLv3
 */
package org.infinitystudio.singularity;



import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * @author Lasm_Gratel Singularity Mod Main.
 */
@Mod(modid = Singularity.MODID, name = Singularity.MODID, version = Singularity.VERSION)
public class Singularity
{
    public static final String MODID = "singularity";
    public static final String NAME = "Singularity";
    public static final String VERSION = "1.0";
    public static Logger log;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
	log=event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }
}
