package com.feliscape.brewersdelight.data.datagen.model;


import com.feliscape.brewersdelight.BrewersDelight;
import com.feliscape.brewersdelight.registry.BrewersDelightItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.Objects;

public class BrewersDelightItemModelProvider extends ItemModelProvider {

    public BrewersDelightItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BrewersDelight.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        mugItem(BrewersDelightItems.BEER.get());
    }

    public ItemModelBuilder mugItem(Item item) {
        return this.mugItem(Objects.requireNonNull(BuiltInRegistries.ITEM.getKey(item)));
    }
    public ItemModelBuilder mugItem(ResourceLocation item) {
        return this.getBuilder(item.toString()).parent(new ModelFile.UncheckedModelFile("brewersdelight:item/mug_item"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(item.getNamespace(), "item/" + item.getPath()));
    }
}
