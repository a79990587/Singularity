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

/**
 * The representation of a packet of resource.
 *
 * @author Lasm_Gratel
 * @author Blealtan
 */
public class Resource {

    private int quantity;
    private ResourceType type;

    /**
     * @param type Type of the quantity
     * @param quantity Resource quantity, must be positive
     */
    public Resource(ResourceType type, int quantity) {
        this.type = type;
        if (quantity < 0) {
            quantity = 0;
        }
        this.quantity = quantity;
    }

    /**
     * @return quantity, positive
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity The quantity to be set, must be positive
     * @return The resource object itself
     */
    public Resource setQuantity(int quantity) {
        if (quantity < 0) {
            quantity = 0;
        }
        this.quantity = quantity;
        return this;
    }

    /**
     * @return type
     */
    public ResourceType getType() {
        return type;
    }

    /**
     * @param type The type to be set
     * @return The resource object itself
     */
    public Resource setType(ResourceType type) {
        this.type = type;
        return this;
    }

    public enum ResourceType {
        source,abyss
    }
}
