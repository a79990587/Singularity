package org.infinitystudio.singularity.api.resource

/**
 * @author Blealtan
 */
class ResourceNetConnector {
  var produceResource: ResourcePacket = null
  var consumeResource: ResourcePacket = null
  var storageResource: ResourcePacket = new ResourcePacket(null)
  var canProduce: Boolean = false

  def onUpdate = {
    if (canProduce) storageResource += produceResource
    storageResource -= consumeResource
    canProduce
  }
}
