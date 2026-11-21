//  This Source Code Form is subject to the terms of the Mozilla Public
//  License, v. 2.0. If a copy of the MPL was not distributed with this
//  file, You can obtain one at https://mozilla.org/MPL/2.0/.
//
//  © 2026 thecasualdev

package com.thecasualdev.jack.block;

import com.thecasualdev.jack.StrangeExpansion;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class ModBlocks {

    public static ResourceKey<Block> getRk(Block block) {
        return BuiltInRegistries.BLOCK.getResourceKey(block).get();
    }

    public static final Block TEST_BLOCK = registerBlock("test_block",
            properties -> new Block(properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));


    static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
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

        VanillaBlocks.registerConcrete();

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register(output -> {
            output.accept(TEST_BLOCK);

            VanillaBlocks.CONCRETE_FAMILY.values().forEach(family -> {
                output.accept(family.stairs());
                output.accept(family.slab());
                output.accept(family.wall());
            });
        });
    }

}
