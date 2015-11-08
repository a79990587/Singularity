/**
 *  Singularity Mod for Minecraft.
 *  Copyright (C) 2015 Infinity Studio.
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *  @license GPLv3
*/
package org.infinitystudio.utils;

import org.infinitystudio.singularity.Singularity;

/**
 * @author Lasm_Gratel
 *
 */
public class ArgsProgresser {
    
    /**
     * Return a number of option.
     * (like "--int 1" return 1)
     * @param args
     * @param option
     * @return param
     * @throws ArgsNotFoundException
     * @throws ArgsTypeErrorException
     */
    public static int getInt(String[] args, String option) 
	    throws ArgsNotFoundException, ArgsTypeErrorException {
	try {
	    return Integer.parseInt(getString(args, option));
	} catch(NumberFormatException ex) {
	    Singularity.log.error(new ArgsTypeErrorException("Args Type Error:"+ex.getLocalizedMessage()));
	    return Integer.MIN_VALUE;
	}
    }
    /**
     * 
     * @param args
     * @param option
     * @return param
     * @throws ArgsNotFoundException
     * @throws ArgsTypeErrorException
     */
    public static short getShort(String[] args, String option) 
	    throws ArgsNotFoundException, ArgsTypeErrorException {
	try {
	    return Short.parseShort(getString(args, option));
	} catch(NumberFormatException ex) {
	    Singularity.log.error(new ArgsTypeErrorException("Args Type Error:"+ex.getLocalizedMessage()));
	    return Short.MIN_VALUE;
	}
    }
    
    /**
     * 
     * @param args
     * @param option
     * @return param
     * @throws ArgsNotFoundException
     * @throws ArgsTypeErrorException
     */
    public static float getFloat(String[] args, String option) 
	    throws ArgsNotFoundException, ArgsTypeErrorException {
	try {
	    return Float.parseFloat(getString(args, option));
	} catch(NumberFormatException ex) {
	    Singularity.log.error(new ArgsTypeErrorException("Args Type Error:"+ex.getLocalizedMessage()));
	    return Float.MIN_VALUE;
	}
    }
    
    /**
     * 
     * @param args
     * @param option
     * @return param
     * @throws ArgsNotFoundException
     * @throws ArgsTypeErrorException
     */
    public static double getDouble(String[] args, String option) 
	    throws ArgsNotFoundException, ArgsTypeErrorException {
	try {
	    return Double.parseDouble(getString(args, option));
	} catch(NumberFormatException ex) {
	    Singularity.log.error(new ArgsTypeErrorException("Args Type Error:"+ex.getLocalizedMessage()));
	    return Double.MIN_VALUE;
	}
    }
    
    /**
     * 
     * @param args
     * @param option
     * @return param
     * @throws ArgsNotFoundException
     * @throws ArgsTypeErrorException
     */
    public static boolean getBoolean(String[] args, String option) 
	    throws ArgsNotFoundException, ArgsTypeErrorException {
	try {
	    return Boolean.parseBoolean(getString(args, option));
	} catch(NumberFormatException ex) {
	    Singularity.log.error(new ArgsTypeErrorException("Args Type Error:"+ex.getLocalizedMessage()));
	    return false;
	}
    }
    
    /**
     * 
     * @param args
     * @param option
     * @return param
     * @throws ArgsNotFoundException
     * @throws ArgsTypeErrorException
     */
    public static Class getClass(String[] args, String option) 
	    throws ArgsNotFoundException, ArgsTypeErrorException {
	try {
	    return Class.forName(getString(args, option));
	} catch (ClassNotFoundException ex) {
	    Singularity.log.error(new ArgsTypeErrorException("Args Type Error:"+ex.getLocalizedMessage()));
	    return null;
	}
    }
    
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
	for(int i=0;i<args.length;i++) {
	    if(args[i].equalsIgnoreCase("--" + option)) {
		return args[i+1];
	    } else {
		Singularity.log.error(new ArgsNotFoundException());
	    }
	}
	return null;
    }
}
