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
package org.infinitystudio.singularity.api.resource;

import java.util.EnumMap;

/**
 * The representation of a packet of resource.
 *
 * @author Lasm_Gratel
 * @author Blealtan
 */
public class Resource {

    private EnumMap<ResourceType, Integer> resources;

    /**
     * @param type     Type of the quantity
     * @param quantity Resource quantity, must be positive
     */
    public Resource(ResourceType[] type, int[] quantity) {
        resources = new EnumMap<ResourceType, Integer>(ResourceType.class);

        if (type == null || quantity == null)
            return;

        int length = (type.length > quantity.length) ? quantity.length : type.length;
        for (int i = 0; i < length; ++i)
            resources.put(type[i], (quantity[i] < 0) ? 0 : quantity[i]);
    }

    /**
     * @return quantity, positive
     */
    public int getQuantity(ResourceType type) {
        Integer res = resources.get(type);
        return (res == null) ? 0 : res;
    }

    /**
     * @param quantity The quantity to be set, must be positive
     * @return The resource object itself
     */
    public Resource setQuantity(ResourceType type, int quantity) {
        if (quantity < 0) quantity = 0;
        resources.put(type, quantity);
        return this;
    }

    public enum ResourceType {
        source, abyss
    }
}
