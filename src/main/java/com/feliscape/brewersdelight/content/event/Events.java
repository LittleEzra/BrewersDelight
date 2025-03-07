package com.feliscape.brewersdelight.content.event;

import com.feliscape.brewersdelight.BrewersDelight;
import com.feliscape.brewersdelight.registry.BrewersDelightDataAttachments;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

public class Events {
    @EventBusSubscriber(modid = BrewersDelight.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
    static class GameEvents{
        @SubscribeEvent
        public static void afterEntityTick(EntityTickEvent.Post event){
            if (event.getEntity() instanceof LivingEntity){
                event.getEntity().getData(BrewersDelightDataAttachments.ALCOHOL).tick();
            }
        }
    }
}
