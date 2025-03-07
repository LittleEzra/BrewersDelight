package com.feliscape.brewersdelight.content.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class EffectBeverageItem extends BeverageItem{
    private final Supplier<MobEffectInstance> effect;

    public EffectBeverageItem(Properties pProperties, Supplier<Item> remainder, Supplier<MobEffectInstance> effect) {
        super(pProperties, remainder);
        this.effect = effect;
    }
    public EffectBeverageItem(Properties pProperties, Supplier<Item> remainder, Supplier<MobEffectInstance> effect, int alcoholSeverity) {
        super(pProperties, remainder, alcoholSeverity);
        this.effect = effect;
    }

    @Override
    public void onDrink(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving) {
        if (!pLevel.isClientSide) {
            MobEffectInstance mobeffectinstance = effect.get();
            pEntityLiving.addEffect(new MobEffectInstance(mobeffectinstance));
        }
    }

    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {

    }
}
