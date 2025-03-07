package com.feliscape.brewersdelight.data.datagen;

import com.feliscape.brewersdelight.BrewersDelight;
import com.feliscape.brewersdelight.data.datagen.advancement.BrewersDelightAdvancements;
import com.feliscape.brewersdelight.data.datagen.language.BrewersDelightEnUsProvider;
import com.feliscape.brewersdelight.data.datagen.loot.BrewersDelightBlockLootTableProvider;
import com.feliscape.brewersdelight.data.datagen.model.BrewersDelightBlockModelProvider;
import com.feliscape.brewersdelight.data.datagen.model.BrewersDelightItemModelProvider;
import com.feliscape.brewersdelight.data.datagen.recipe.BrewersDelightRecipeProvider;
import com.feliscape.brewersdelight.data.datagen.tag.BrewersDelightBlockTagGenerator;
import com.feliscape.brewersdelight.data.datagen.tag.BrewersDelightItemTagGenerator;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = BrewersDelight.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();



        BrewersDelightGeneratedEntries generatedEntries = new BrewersDelightGeneratedEntries(packOutput, lookupProvider);
        lookupProvider = generatedEntries.getRegistryProvider();
        generator.addProvider(true, generatedEntries);

        generator.addProvider(true, new BrewersDelightRecipeProvider(packOutput, lookupProvider));
        generator.addProvider(true, new BrewersDelightAdvancements(packOutput, lookupProvider));

        var blockTags = new BrewersDelightBlockTagGenerator(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(true, blockTags);
        generator.addProvider(true, new BrewersDelightItemTagGenerator(packOutput, lookupProvider, blockTags.contentsGetter()));

        generator.addProvider(true, new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(BrewersDelightBlockLootTableProvider::new, LootContextParamSets.BLOCK)), lookupProvider));

        generator.addProvider(true, new BrewersDelightBlockModelProvider(packOutput, existingFileHelper));
        generator.addProvider(true, new BrewersDelightItemModelProvider(packOutput, existingFileHelper));

        generator.addProvider(true, new BrewersDelightEnUsProvider(packOutput));
    }
}
