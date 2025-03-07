package com.feliscape.brewersdelight.data.datagen.language;

import com.feliscape.brewersdelight.BrewersDelight;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.LanguageProvider;

import java.util.function.Supplier;

public abstract class BrewersDelightLanguageProvider extends LanguageProvider {
    public BrewersDelightLanguageProvider(PackOutput output, String locale) {
        super(output, BrewersDelight.MOD_ID, locale);
    }

    protected void addBlockAndItem(Supplier<? extends Block> key, String name) {
        this.addBlock(key, name);
        this.addItem(key.get()::asItem, name);
    }

    protected void addItemTooltip(Supplier<? extends Item> key, String name) {
        add(key.get().getDescriptionId() + ".tooltip", name);
    }
    protected void addMobEffect(Supplier<? extends MobEffect> key, String name) {
        add(key.get().getDescriptionId(), name);
    }
    protected void addMobEffect(Holder<? extends MobEffect> key, String name) {
        add(key.value().getDescriptionId(), name);
    }
    protected void addSubtitle(Supplier<SoundEvent> key, String name) {
        add("subtitle.{}.{}".formatted(BrewersDelight.MOD_ID, key.get().getLocation().getPath()), name);
    }
    protected void addAdvancement(String id, String title, String description) {
        add("advancements.%s.%s.title".formatted(BrewersDelight.MOD_ID, id), title);
        add("advancements.%s.%s.description".formatted(BrewersDelight.MOD_ID, id), description);
    }
}
