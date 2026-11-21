package com.thecasualdev.jack.block;

import com.thecasualdev.jack.StrangeExpansion;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class ModBlocks {

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(
                Registries.BLOCK, StrangeExpansion.id(name))));

        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, StrangeExpansion.id(name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, StrangeExpansion.id(name),
                new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix()
                        .setId(ResourceKey.create(
                                Registries.ITEM, StrangeExpansion.id(name)))));
    }

    public static void registerModBlocks() {
        StrangeExpansion.LOGGER.info("Registering Mod blocks for " + StrangeExpansion.MOD_ID);
    }

}
