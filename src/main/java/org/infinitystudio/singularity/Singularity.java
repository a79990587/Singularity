/**
 * Singularity Mod for Minecraft.
 * Copyright (C) 2015 Infinity Studio.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * @license GPLv3
 */
package org.infinitystudio.singularity;

import org.infinitystudio.singularity.common.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Singularity Mod Main.
 *
 * @author Lasm_Gratel
 */
@Mod(modid = Singularity.MODID, name = Singularity.NAME, version = Singularity.VERSION, acceptedMinecraftVersions = "[1.8,)")
public class Singularity {

    public static final String MODID = "singularity";
    public static final String NAME = "Singularity";
    public static final String GROUP = "org.infinitystudio.singularity";
    public static final String VERSION = "@version@";

    @Instance(MODID)
    public Singularity instance;

    @SidedProxy(clientSide = GROUP + ".client.ClientProxy", serverSide = GROUP + ".common.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
