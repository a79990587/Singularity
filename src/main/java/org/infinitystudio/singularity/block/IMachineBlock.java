package org.infinitystudio.singularity.block;

import org.infinitystudio.singularity.api.Resource;
import org.infinitystudio.singularity.api.SingularityEnums;

/**
 * @author Blealtan
 */
public interface IMachineBlock {
    Resource getResource();

    void setResource(Resource resource,
                     SingularityEnums.ResourceInteractType resourceInteractType);

    Resource getStorageResource();

    void setStorageResource(Resource storageResource);

    void addStorageResource(Resource storageResource);

    void delStorageResource(Resource storageResource);

    SingularityEnums.ResourceInteractType getResourceInteractType();

    void setResourceInteractType(SingularityEnums.ResourceInteractType resourceInteractType);

    boolean canProduce();

    void setCanProduce(boolean canProduce);
}
