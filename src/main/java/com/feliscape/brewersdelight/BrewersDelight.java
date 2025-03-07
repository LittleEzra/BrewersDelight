package com.feliscape.brewersdelight;

import com.feliscape.brewersdelight.registry.BrewersDelightBlocks;
import com.feliscape.brewersdelight.registry.BrewersDelightCreativeModeTabs;
import com.feliscape.brewersdelight.registry.BrewersDelightDataAttachments;
import com.feliscape.brewersdelight.registry.BrewersDelightItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(BrewersDelight.MOD_ID)
public class BrewersDelight
{
    public static final String MOD_ID = "brewersdelight";
    private static final Logger LOGGER = LogUtils.getLogger();

    public BrewersDelight(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(this::commonSetup);

        BrewersDelightBlocks.register(modEventBus);
        BrewersDelightItems.register(modEventBus);
        BrewersDelightDataAttachments.register(modEventBus);
        BrewersDelightCreativeModeTabs.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        //modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
