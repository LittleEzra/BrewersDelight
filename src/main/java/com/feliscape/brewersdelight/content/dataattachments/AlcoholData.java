package com.feliscape.brewersdelight.content.dataattachments;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.common.util.INBTSerializable;
import org.jetbrains.annotations.UnknownNullability;

public class AlcoholData implements INBTSerializable<CompoundTag> {
    private int alcohol;
    private double recovery;
    private double recoveryDuration = 900.0D;

    public void tick(){
        if (alcohol > 0){
            recovery += 1.0D;
            if (recovery > recoveryDuration){
                alcohol--;
            }
        } else{
            recovery = 0;
        }
    }

    public void consumeAlcohol(int severity, LivingEntity entity){
        if (entity instanceof Player player && severity > 0 && alcohol < 4)
            player.displayClientMessage(Component.translatable("tooltip.brewersdelight.alcohol_warning"), true);
        alcohol += severity;
        recovery = 0;
    }

    @Override
    public @UnknownNullability CompoundTag serializeNBT(HolderLookup.Provider provider) {
        CompoundTag tag = new CompoundTag();
        tag.putInt("alcohol", alcohol);
        tag.putDouble("recovery", recovery);
        return null;
    }

    @Override
    public void deserializeNBT(HolderLookup.Provider provider, CompoundTag compoundTag) {
        this.alcohol = compoundTag.getInt("alcohol");
        this.recovery = compoundTag.getDouble("recovery");
    }
}
