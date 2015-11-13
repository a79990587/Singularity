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
package org.infinitystudio.singularity.client;

import org.infinitystudio.singularity.common.CommonProxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Client proxy on client side.
 *
 * @author ustc_zzzz
 */
public class ClientProxy extends CommonProxy {
    
    /**
     * FML Pre Initialization Event Handler.
     * @param event FMLPreInitializationEvent
     */
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }

    /**
     * FML Initialization Event Handler.
     * @param event FMLInitializationEvent
     */
    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }
    
    /**
     * FML Post Initialization Event Handler.
     * @param event FMLPostInitializationEvent
     */
    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }
}

