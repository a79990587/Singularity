package org.infinitystudio.singularity.api.resource;

import java.util.EnumMap;

/**
 * @author Blealtan
 */
public class ResourcePacket {
	private EnumMap<Resource.ResourceType, Resource> resources;

	/**
	 * Initialise the resource packet.
	 *
	 * @param resources The argument list of resources to be moved into the packet.
	 */
	public ResourcePacket(Resource... resources) {
		this.resources = new EnumMap<Resource.ResourceType, Resource>(Resource.ResourceType.class);
		for (Resource r : resources)
			if (!this.resources.containsKey(r.getType()))
				this.resources.put(r.getType(), r);
	}

	/**
	 * Set the resources in the packet if one type is specified in argument list.
	 * Not mentioned resource type will not be influenced.
	 *
	 * @param resources The argument list of resources to be moved into the packet.
	 */
	public ResourcePacket setResource(Resource... resources) {
		for (Resource r : resources)
			if (!this.resources.containsKey(r.getType()))
				this.resources.put(r.getType(), r);
		return this;
	}

	/**
	 * Get resource information for specified source type.
	 *
	 * @param resourceType The specified type.
	 * @return The wanted resource.
	 */
	public Resource getResource(Resource.ResourceType resourceType) {
		return resources.get(resourceType);
	}

	/**
	 * Append a resource packet to this one.
	 *
	 * @param resourcePacket The packet to be appended here.
	 * @return this
	 */
	public ResourcePacket appendResource(ResourcePacket resourcePacket) {
		for (Resource r : resourcePacket.resources.values()) {
			if (!this.resources.containsKey(r.getType()))
				this.resources.put(r.getType(), r);
			else
				this.resources.put(r.getType(), r.setQuantity(this.resources.get(r.getType()).getQuantity() + r.getQuantity()));
		}
		return this;
	}

	/**
	 * Remove a resource packet from this one.
	 *
	 * @param resourcePacket The packet to be removed from here.
	 * @return At most `this`. If not enough, null.
	 */
	public ResourcePacket removeResource(ResourcePacket resourcePacket) {
		ResourcePacket res = this;
		for (Resource r : resourcePacket.resources.values()) {
			if (!this.resources.containsKey(r.getType()))
				this.resources.put(r.getType(), r);
			else {
				int toset = this.resources.get(r.getType()).getQuantity() - r.getQuantity();
				if (toset < 0) {
					res = null;
					toset = 0;
				}
				this.resources.put(r.getType(), r.setQuantity(toset));
			}
		}
		return res;
	}
}
