package com.feliscape.brewersdelight.data.datagen.advancement;

import com.feliscape.brewersdelight.BrewersDelight;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;

import java.util.function.Consumer;

public class BrewersDelightAdventureAdvancements implements AdvancementSubProvider {
    @Override
    public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> writer) {
        HolderGetter<Item> itemHolderGetter = registries.lookupOrThrow(Registries.ITEM);

        /*AdvancementHolder getAuroraCrystal = Advancement.Builder.advancement()
                .parent(AdvancementSubProvider.createPlaceholder("minecraft:adventure/root"))
                .display(new ItemStack(PrismaItems.AUSTRALITE_CRYSTAL.get()),
                        titleComponent("get_aurora_crystal"),
                        descriptionComponent("get_aurora_crystal"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                        )
                .addCriterion("pickup_aurora_crystal", InventoryChangeTrigger.TriggerInstance
                        .hasItems(ItemPredicate.Builder.item().of(itemHolderGetter, PrismaTags.Items.AURORA_CRYSTALS)))
                .save(writer, Prisma.asResource("get_aurora_crystal"));

        AdvancementHolder eatCrystalMelon = Advancement.Builder.advancement()
                .parent(getAuroraCrystal)
                .display(new ItemStack(PrismaItems.CRYSTAL_MELON_SLICE.get()),
                        titleComponent("eat_crystal_melon"),
                        descriptionComponent("eat_crystal_melon"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                        )
                .addCriterion("consume_crystal_melon_slice",ConsumeItemTrigger.TriggerInstance
                        .usedItem(itemHolderGetter, PrismaItems.CRYSTAL_MELON_SLICE.get()))
                .save(writer, Prisma.asResource("eat_crystal_melon"));*/
    }
    private Component titleComponent(String name){
        return Component.translatable("advancements.%s.%s.title".formatted(BrewersDelight.MOD_ID, name));
    }
    private Component descriptionComponent(String name){
        return Component.translatable("advancements.%s.%s.description".formatted(BrewersDelight.MOD_ID, name));
    }
}
