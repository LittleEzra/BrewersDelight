package com.feliscape.brewersdelight.data.datagen;

import com.feliscape.brewersdelight.BrewersDelight;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class BrewersDelightGeneratedEntries extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            //.add(Registries.CONFIGURED_FEATURE, PrismaTreeFeatures::bootstrap)
            //.add(Registries.PLACED_FEATURE, DeepwoodPlacedFeatures::bootstrap)
            //.add(ForgeRegistries.Keys.BIOME_MODIFIERS, DeepwoodBiomeModifiers::bootstrap)
            //.add(Registries.DAMAGE_TYPE, DeepwoodDamageTypes::bootstrap)
            //.add(Registries.NOISE, DeepwoodNoise::bootstrap)
            ;
    public BrewersDelightGeneratedEntries(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(BrewersDelight.MOD_ID));
    }
}
