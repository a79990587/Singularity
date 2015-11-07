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

import org.infinitystudio.singularity.api.Resource;
import org.infinitystudio.singularity.api.SingularityEnums;

import net.minecraft.block.material.Material;

/**
 * @author Lasm_Gratel
 *
 */
public abstract class MachineBlock extends SingularityBlock {
    private Resource produceResource;
    private Resource consumeResource;
    private Resource storageResource;
    private SingularityEnums.ResourceInteractType resourceInteractType;
    private boolean canProduce;

    /**
     * Instance a block.
     *
     * @param material
     *            The material
     * @param name
     *            The name of the block
     * @param resource
     *            Uses/Produce resource
     * @param resourceInteractType
     *            Whether this machine produce resource or consume resource?
     */
    public MachineBlock(Material material, String name, Resource resource,
                        SingularityEnums.ResourceInteractType resourceInteractType) {
        super(material, name);
        if (resourceInteractType == SingularityEnums.ResourceInteractType.Output)
            produceResource = resource;
        else
            consumeResource = resource;
        this.resourceInteractType = resourceInteractType;
    }

    public Resource getResource() {
        if (resourceInteractType == SingularityEnums.ResourceInteractType.Output)
            return produceResource;
        else
            return consumeResource;
    }

    public void setResource(Resource resource,
                            SingularityEnums.ResourceInteractType resourceInteractType) {
        if (resourceInteractType == SingularityEnums.ResourceInteractType.Output)
            produceResource = resource;
        else
            consumeResource = resource;
        this.resourceInteractType = resourceInteractType;
    }

    /**
     * @return storageResource
     */
    public Resource getStorageResource() {
        return storageResource;
    }

    /**
     * @param storageResource 要设置的 storageResource
     */
    public void setStorageResource(Resource storageResource) {
        this.storageResource = storageResource;
    }

    /**
     * @param storageResource 要增加的 storageResource
     */
    public void addStorageResource(Resource storageResource) {
        this.storageResource.setQuantity(storageResource.getQuantity() + this.storageResource.getQuantity());
    }

    /**
     * @param storageResource 要減少的 storageResource
     */
    public void delStorageResource(Resource storageResource) {
	    this.storageResource.setQuantity(this.storageResource.getQuantity() - storageResource.getQuantity());
    }

    /**
     * @return resourceInteractType
     */
    public SingularityEnums.ResourceInteractType getResourceInteractType() {
        return resourceInteractType;
    }

    /**
     * @param resourceInteractType 要设置的 resourceInteractType
     */
    public void setResourceInteractType(SingularityEnums.ResourceInteractType resourceInteractType) {
        this.resourceInteractType = resourceInteractType;
    }

    /**
     * @return canProduce
     */
    public boolean isCanProduce() {
        return canProduce;
    }

    /**
     * @param canProduce 要设置的 canProduce
     */
    public void setCanProduce(boolean canProduce) {
        this.canProduce = canProduce;
    }
}
