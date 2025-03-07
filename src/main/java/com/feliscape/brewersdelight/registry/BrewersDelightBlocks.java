package com.feliscape.brewersdelight.registry;

import com.feliscape.brewersdelight.BrewersDelight;
import com.feliscape.brewersdelight.content.block.BrewersDelightLogBlock;
import com.feliscape.brewersdelight.content.block.FlammableStairBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class BrewersDelightBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(BrewersDelight.MOD_ID);

    private static BlockBehaviour.Properties leavesProperties(BlockBehaviour.Properties properties, SoundType sound) {
        return properties
                .mapColor(MapColor.PLANT)
                .strength(0.2F)
                .randomTicks()
                .sound(sound)
                .noOcclusion()
                .isValidSpawn(Blocks::ocelotOrParrot)
                .isSuffocating(BrewersDelightBlocks::never)
                .isViewBlocking(BrewersDelightBlocks::never)
                .ignitedByLava()
                .pushReaction(PushReaction.DESTROY)
                .isRedstoneConductor(BrewersDelightBlocks::never);
    }

    private static BlockBehaviour.Properties logProperties(BlockBehaviour.Properties properties, MapColor topColor, MapColor sideColor, SoundType soundType) {
        return properties
                .mapColor(blockState -> blockState.getValue(BrewersDelightLogBlock.AXIS) == Direction.Axis.Y ? topColor : sideColor)
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.0F)
                .sound(soundType)
                .ignitedByLava();
    }

    private static BlockBehaviour.Properties buttonProperties(BlockBehaviour.Properties properties) {
        return properties.noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY);
    }

    private static boolean always(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return true;
    }

    private static boolean never(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return false;
    }
    public static Boolean never(BlockState state, BlockGetter blockGetter, BlockPos pos, EntityType<?> entity) {
        return false;
    }

    private static <T extends Block> DeferredBlock<T> registerBlockWithItem(String name, Function<BlockBehaviour.Properties, ? extends T> block)
    {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> DeferredItem<Item> registerBlockItem(String name, DeferredBlock<T> block)
    {
        return BrewersDelightItems.ITEMS.registerItem(name, p -> new BlockItem(block.get(), p));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

    private static StairBlock stair(BlockBehaviour.Properties properties, Block baseBlock) {
        return new StairBlock(baseBlock.defaultBlockState(), properties);
    }
    private static FlammableStairBlock flammableStair(BlockBehaviour.Properties properties, Block baseBlock) {
        return new FlammableStairBlock(baseBlock.defaultBlockState(), properties);
    }
}
