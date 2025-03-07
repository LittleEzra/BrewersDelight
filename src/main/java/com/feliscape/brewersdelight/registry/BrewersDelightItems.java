package com.feliscape.brewersdelight.registry;

import com.feliscape.brewersdelight.BrewersDelight;
import com.feliscape.brewersdelight.content.item.BeverageItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BrewersDelightItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BrewersDelight.MOD_ID);

    public static final DeferredItem<BeverageItem> BEER = ITEMS.registerItem("beer",
            p -> new BeverageItem(p, () -> Items.GLASS_BOTTLE));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
