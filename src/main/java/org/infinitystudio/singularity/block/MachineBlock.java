/**
 * Singularity Mod for Minecraft. Copyright (C) 2015 Infinity Studio.
 * <p/>
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * <p/>
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * <p/>
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 *
 * @license GPLv3
 */
package org.infinitystudio.singularity.block;

import net.minecraft.block.material.Material;
import org.infinitystudio.singularity.SingularityCreativeTab;
import org.infinitystudio.singularity.api.resource.ResourceNetConnector;
import org.infinitystudio.singularity.api.resource.ResourcePacket;

/**
 * @author Lasm_Gratel
 */
public abstract class MachineBlock extends SingularityBlock {
	private ResourceNetConnector connector;
	private boolean isWorking;

	/**
	 * Instance of a machine block.
	 *
	 * @param material        The material
	 * @param name            The name of the block.
	 * @param creativeTab     The creative tab to be set.
	 * @param produceResource The resource it produces per tick. Can be null.
	 * @param consumeResource The resource it produces per tick. Can be null.
	 * @param canProduce      If it can produce resource. Once set to false, parameter
	 *                        produceResource will not work.
	 */
	public MachineBlock(Material material, String name, SingularityCreativeTab creativeTab, ResourcePacket produceResource, ResourcePacket consumeResource, boolean canProduce) {
		super(material, name, creativeTab);
		connector = new ResourceNetConnector();
		connector.setProduceResource(produceResource);
		connector.setConsumeResource(consumeResource);
		connector.setCanProduce(canProduce);
	}


	/**
	 * @return connector
	 */
	public ResourceNetConnector getConnector() {
		return connector;
	}


	/**
	 * @param connector 要设置的 connector
	 */
	public void setConnector(ResourceNetConnector connector) {
		this.connector = connector;
	}


	/**
	 * @return isWorking
	 */
	public boolean isWorking() {
		return isWorking;
	}


	/**
	 * @param isWorking 要设置的 isWorking
	 */
	public void setWorking(boolean isWorking) {
		this.isWorking = isWorking;
	}
}
