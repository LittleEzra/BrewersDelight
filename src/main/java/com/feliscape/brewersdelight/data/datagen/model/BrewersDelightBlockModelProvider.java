package com.feliscape.brewersdelight.data.datagen.model;

import com.feliscape.brewersdelight.BrewersDelight;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class BrewersDelightBlockModelProvider extends BlockStateProvider {
    public BrewersDelightBlockModelProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, BrewersDelight.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

    }
}
