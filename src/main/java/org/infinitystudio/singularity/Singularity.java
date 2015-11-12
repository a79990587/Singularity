package org.infinitystudio.singularity;

import org.infinitystudio.singularity.common.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Singularity.MODID, name = Singularity.NAME, version = Singularity.VERSION, acceptedMinecraftVersions = "[1.8,)")
public class Singularity
{
    public static final String MODID = "singularity";
    public static final String NAME = "Singularity";
    public static final String GROUP = "org.infinitystudio.singularity";
    public static final String VERSION = "@version@";

    @Instance(MODID)
    public Singularity instance;

    @SidedProxy(clientSide = GROUP + ".client.ClientProxy", serverSide = GROUP + ".common.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }
}
