package org.infinitystudio.singularity.api.resource;

/**
 * @author Blealtan
 */
public class ResourceNetConnector {
	private ResourcePacket produceResource = null;
	private ResourcePacket consumeResource = null;
	private ResourcePacket storageResource = null;
	private boolean canProduce = false;

	public ResourcePacket getProduceResource() {
		return produceResource;
	}

	public void setProduceResource(ResourcePacket produceResource) {
		this.produceResource = produceResource;
	}

	public ResourcePacket getConsumeResource() {
		return consumeResource;
	}

	public void setConsumeResource(ResourcePacket consumeResource) {
		this.consumeResource = consumeResource;
	}

	public ResourcePacket getStorageResource() {
		return storageResource;
	}

	public void setStorageResource(ResourcePacket storageResource) {
		this.storageResource = storageResource;
	}

	public boolean isCanProduce() {
		return canProduce;
	}

	public void setCanProduce(boolean canProduce) {
		this.canProduce = canProduce;
	}
}
