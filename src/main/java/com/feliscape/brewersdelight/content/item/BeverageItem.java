package com.feliscape.brewersdelight.content.item;

import com.feliscape.brewersdelight.registry.BrewersDelightDataAttachments;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.function.Supplier;

public class BeverageItem extends Item {
    private static final int DRINK_DURATION = 32;

    private final Supplier<Item> remainder;
    private final int alcoholSeverity;

    public BeverageItem(Item.Properties pProperties, Supplier<Item> remainder) {
        super(pProperties);
        this.remainder = remainder;
        this.alcoholSeverity = 1;
    }
    public BeverageItem(Item.Properties pProperties, Supplier<Item> remainder, int alcoholSeverity) {
        super(pProperties);
        this.remainder = remainder;
        this.alcoholSeverity = alcoholSeverity;
    }

    /**
     * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
     * the Item before the action is complete.
     */
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        Player player = pEntityLiving instanceof Player ? (Player)pEntityLiving : null;
        if (player instanceof ServerPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger((ServerPlayer)player, pStack);
        }

        pEntityLiving.getData(BrewersDelightDataAttachments.ALCOHOL).consumeAlcohol(alcoholSeverity, pEntityLiving);

        onDrink(pStack, pLevel, pEntityLiving);

        if (player != null) {
            player.awardStat(Stats.ITEM_USED.get(this));
            if (!player.getAbilities().instabuild) {
                pStack.shrink(1);
            }
        }

        if (player == null || !player.getAbilities().instabuild) {
            if (pStack.isEmpty()) {
                return new ItemStack(remainder.get());
            }

            if (player != null) {
                player.getInventory().add(new ItemStack(remainder.get()));
            }
        }

        pEntityLiving.gameEvent(GameEvent.DRINK);
        return pStack;
    }

    public void onDrink(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving){

    }

    public int getUseDuration(ItemStack pStack) {
        return DRINK_DURATION;
    }

    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }

    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        return ItemUtils.startUsingInstantly(pLevel, pPlayer, pHand);
    }
}
