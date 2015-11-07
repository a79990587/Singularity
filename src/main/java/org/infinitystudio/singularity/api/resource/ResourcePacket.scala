package org.infinitystudio.singularity.api.resource

import scala.collection.mutable

/**
 * @author Blealtan
 */
class ResourcePacket(resources: Array[Resource]) {
  private val packet : mutable.Map[Resource.SourceType, Resource] = mutable.Map()
  if (resources != null) resources.foreach(r => packet getOrElseUpdate (r.getType, r))

  def +=(resourcePacket: ResourcePacket) : ResourcePacket = {
    resourcePacket.packet.foreach(r => {
      val tmp = packet(r._1)
      tmp.setQuantity(packet(r._1).getQuantity + r._2.getQuantity)
      packet update (r._1, tmp)
    })
    this
  }

  def +(resourcePacket: ResourcePacket) : ResourcePacket = {
    val ret = new ResourcePacket(packet.values.toArray)
    ret += resourcePacket
  }

  def -=(resourcePacket: ResourcePacket) : ResourcePacket = {
    resourcePacket.packet.foreach(r => {
      val tmp = packet(r._1)
      tmp.setQuantity(packet(r._1).getQuantity - r._2.getQuantity)
      packet update (r._1, tmp)
    })
    this
  }

  def -(resourcePacket: ResourcePacket) : ResourcePacket = {
    val ret = new ResourcePacket(packet.values.toArray)
    ret -= resourcePacket
  }

  def get(r: Resource.SourceType) = packet get r

  def set(r: Resource.SourceType, res: Resource) = packet update(r, res)
}
