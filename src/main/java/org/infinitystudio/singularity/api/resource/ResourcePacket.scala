package org.infinitystudio.singularity.api.resource

import scala.collection.mutable

/**
 * @author Blealtan
 */
class ResourcePacket(resources: Array[Resource]) {
  private val packet : mutable.Map[Resource.SourceType, Resource] = mutable.Map()

  // Add the resources to packet
  if (resources != null) resources.foreach(r => packet getOrElseUpdate (r.getType, r))

  /**
   * Add a resource packet to this one.
   * @param resourcePacket The packet to be added here.
   * @return A reference to this packet.
   */
  def +=(resourcePacket: ResourcePacket) : ResourcePacket = {
    resourcePacket.packet.foreach(r => {
      val tmp = packet(r._1)
      tmp.setQuantity(packet(r._1).getQuantity + r._2.getQuantity)
      packet update (r._1, tmp)
    })
    this
  }

  /**
   * Add this packet with another one.
   * @param resourcePacket Another packet to be added.
   * @return The summation of the two packets.
   */
  def +(resourcePacket: ResourcePacket) : ResourcePacket = {
    val ret = new ResourcePacket(packet.values.toArray)
    ret += resourcePacket
  }

  /**
   * Minus this packet with another one.
   * @param resourcePacket The packet to take calculation.
   * @return A reference to this packet.
   */
  def -=(resourcePacket: ResourcePacket) : ResourcePacket = {
    resourcePacket.packet.foreach(r => {
      val tmp = packet(r._1)
      tmp.setQuantity(packet(r._1).getQuantity - r._2.getQuantity)
      packet update (r._1, tmp)
    })
    this
  }

  /**
   * Minus this packet with another one.
   * @param resourcePacket Another packet to minus with.
   * @return The substitution of the two packets.
   */
  def -(resourcePacket: ResourcePacket) : ResourcePacket = {
    val ret = new ResourcePacket(packet.values.toArray)
    ret -= resourcePacket
  }

  /**
   * Get the resource of some type.
   * @param sourceType The type of the wanted resource.
   * @return The wanted resource.
   */
  def get(sourceType: Resource.SourceType) = packet get sourceType

  /**
   * Set the resource of some type.
   * @param sourceType The type of the wanted resource.
   * @param res The wanted resource.
   */
  def set(sourceType: Resource.SourceType, res: Resource) = packet update(sourceType, res)
}
