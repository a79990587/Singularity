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
package org.infinitystudio.singularity.api;

/**
 * @author Lasm_Gratel
 *
 */
public class Resource {
    private int quantity;
    private SourceType type;

    /**
     * @param type Type of the quantity
     * @param quantity Resource num
     */
    public Resource(SourceType type, int quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    /**
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity 要设置的 quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return type
     */
    public SourceType getType() {
        return type;
    }

    /**
     * @param type 要设置的 type
     */
    public void setType(SourceType type) {
        this.type = type;
    }

    /**
     *
     */
    public enum SourceType {
        test1, test2, test3, test4, test5, test6
    }
}
