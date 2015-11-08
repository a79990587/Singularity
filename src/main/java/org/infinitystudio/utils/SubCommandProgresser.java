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
package org.infinitystudio.utils;

import org.infinitystudio.singularity.Singularity;

/**
 * @author Lasm_Gratel
 *
 */
public class SubCommandProgresser extends ArgsProgresser {

    /**
     *
     * @param args
     * @param option
     * @return param
     * @throws ArgsNotFoundException
     * @throws ArgsTypeErrorException
     */
    public static String getString(String[] args, String option)
            throws ArgsNotFoundException {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equalsIgnoreCase(option)) {
                return args[i];
            } else {
                Singularity.log.error(new ArgsNotFoundException());
            }
        }
        return null;
    }
}
