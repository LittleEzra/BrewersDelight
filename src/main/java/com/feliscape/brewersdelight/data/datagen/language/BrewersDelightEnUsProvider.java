package com.feliscape.brewersdelight.data.datagen.language;

import com.feliscape.brewersdelight.registry.BrewersDelightItems;
import net.minecraft.data.PackOutput;

public class BrewersDelightEnUsProvider extends BrewersDelightLanguageProvider {
    public BrewersDelightEnUsProvider(PackOutput output) {
        super(output, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.addItem(BrewersDelightItems.BEER, "Beer");
        this.add("itemGroup.brewersdelight.base", "Brewer's Delight");
    }
}
