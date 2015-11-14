/**
 * Singularity Mod for Minecraft.
 * Copyright (C) 2015 Infinity Studio.
 * <p/>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * @license GPLv3
 */
package org.infinitystudio.singularity.common;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.infinitystudio.singularity.Singularity;
import org.infinitystudio.singularity.SingularityHandlers;

/**
 * Common proxy on server side.
 *
 * @author ustc_zzzz
 */
public class CommonProxy {

    /**
     * FML Pre Initialization Event Handler.
     *
     * @param event FMLPreInitializationEvent
     */
    public void preInit(FMLPreInitializationEvent event) {
        Singularity.logger = event.getModLog();
        // TODO Pre Init Event.
    }

    /**
     * FML Initialization Event Handler.
     *
     * @param event FMLInitializationEvent
     */
    public void init(FMLInitializationEvent event) {
        SingularityHandlers.registerBlocks();
        SingularityHandlers.registerItems();
        SingularityHandlers.registerRecipes();
    }

    /**
     * FML Post Initialization Event Handler.
     *
     * @param event FMLPostInitializationEvent
     */
    public void postInit(FMLPostInitializationEvent event) {
        // TODO PostInit Event.
    }
}
