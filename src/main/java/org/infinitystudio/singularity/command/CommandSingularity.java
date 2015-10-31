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
package org.infinitystudio.singularity.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;

/**
 * @author Lasm_Gratel
 *
 */
public class CommandSingularity extends CommandBase
{

    /**
     * Return command name of this command.
     * 
     * @see net.minecraft.command.ICommand#getCommandName()
     */
    @Override
    public String getCommandName()
    {
	return "singularity";
    }

    /**
     * Return the required permission level for this command.
     */
    public int getRequiredPermissionLevel()
    {
	return 0;
    }

    @Override
    public String getCommandUsage(ICommandSender commandsender)
    {
	return "commands.singularity.usage";
    }

    @Override
    public void processCommand(ICommandSender commandsender, String[] args)
    {
	if (args.length > 2)
	{
	    throw new WrongUsageException("commands.singularity.usage", new Object[0]);
	}

    }

}
