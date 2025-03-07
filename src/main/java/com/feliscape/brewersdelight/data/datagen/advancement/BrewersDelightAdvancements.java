package com.feliscape.brewersdelight.data.datagen.advancement;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class BrewersDelightAdvancements extends AdvancementProvider {
    public BrewersDelightAdvancements(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, List.of(new BrewersDelightAdventureAdvancements()));
    }
}
