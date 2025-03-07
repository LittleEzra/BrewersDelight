package com.feliscape.brewersdelight.registry;

import com.feliscape.brewersdelight.BrewersDelight;
import com.feliscape.brewersdelight.content.dataattachments.AlcoholData;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class BrewersDelightDataAttachments {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES =
            DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, BrewersDelight.MOD_ID);

    public static final Supplier<AttachmentType<AlcoholData>> ALCOHOL = ATTACHMENT_TYPES.register(
            "alcohol", () -> AttachmentType.serializable(AlcoholData::new).build());

    public static void register(IEventBus eventBus){
        ATTACHMENT_TYPES.register(eventBus);
    }
}
