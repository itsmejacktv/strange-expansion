//  This Source Code Form is subject to the terms of the Mozilla Public
//  License, v. 2.0. If a copy of the MPL was not distributed with this
//  file, You can obtain one at https://mozilla.org/MPL/2.0/.
//
//  © 2026 thecasualdev

// This class is for expanding the block set of the following blocks
// - Concrete
// - Glass
// - Wool

// TODO: Rewrite this, because there has to be a better way bro :sob:

package com.thecasualdev.jack.block;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.PushReaction;

import java.util.EnumMap;
import java.util.Map;

public class VanillaBlocks {

    public record family (Block base, Block stairs, Block slab, Block wall) {}
    public record family_wool (Block base, Block stairs, Block slab) {}

    public static final Map<DyeColor, family> CONCRETE_FAMILY = new EnumMap<>(DyeColor.class);
    public static final Map<DyeColor, family> TERRACOTTA_FAMILY = new EnumMap<>(DyeColor.class);
    public static final Map<DyeColor, family> GLAZED_TERRACOTTA_FAMILY = new EnumMap<>(DyeColor.class);

    public static final Map<DyeColor, family_wool> WOOL_FAMILY = new EnumMap<>(DyeColor.class);

    public static void registerConcrete() {

        for (DyeColor color : DyeColor.values()) {

            Block base = Blocks.CONCRETE.pick(color);
            String name = color.getSerializedName() + "_concrete";

            Block stairs = ModBlocks.registerBlock(name + "_stairs",
                    properties -> new StairBlock(base.defaultBlockState(),
                            properties
                                    .mapColor(color.getMapColor())
                                    .instrument(NoteBlockInstrument.BASEDRUM)
                                    .requiresCorrectToolForDrops()
                                    .strength(1.8F)));

            Block slab = ModBlocks.registerBlock(name + "_slab",
                    properties -> new SlabBlock(
                            properties
                                .mapColor(color.getMapColor())
                                .instrument(NoteBlockInstrument.BASEDRUM)
                                .requiresCorrectToolForDrops()
                                .strength(1.8F)));

            Block wall = ModBlocks.registerBlock(name + "_wall",
                    properties -> new WallBlock(
                            properties
                                    .mapColor(color.getMapColor())
                                    .instrument(NoteBlockInstrument.BASEDRUM)
                                    .requiresCorrectToolForDrops()
                                    .strength(1.8f)
                    ));

            CONCRETE_FAMILY.put(color, new family(base, stairs, slab, wall));
        }

    }

    public static void registerTerracotta() {

        for (DyeColor color : DyeColor.values()) {

            Block base = Blocks.DYED_TERRACOTTA.pick(color);
            String name = color.getSerializedName() + "_terracotta";

            Block stairs = ModBlocks.registerBlock(name + "_stairs",
                    properties -> new StairBlock(base.defaultBlockState(),
                            properties
                                    .mapColor(color.getMapColor())
                                    .instrument(NoteBlockInstrument.BASEDRUM)
                                    .requiresCorrectToolForDrops()
                                    .strength(1.25F, 4.2f)));

            Block slab = ModBlocks.registerBlock(name + "_slab",
                    properties -> new SlabBlock(
                            properties
                                    .mapColor(color.getMapColor())
                                    .instrument(NoteBlockInstrument.BASEDRUM)
                                    .requiresCorrectToolForDrops()
                                    .strength(1.25F, 4.2f)));

            Block wall = ModBlocks.registerBlock(name + "_wall",
                    properties -> new WallBlock(
                            properties
                                    .mapColor(color.getMapColor())
                                    .instrument(NoteBlockInstrument.BASEDRUM)
                                    .requiresCorrectToolForDrops()
                                    .strength(1.25F, 4.2f)
                    ));

            TERRACOTTA_FAMILY.put(color, new family(base, stairs, slab, wall));
        }

    }

    public static void registerGlazedTerracotta() {

        for (DyeColor color : DyeColor.values()) {

            Block base = Blocks.GLAZED_TERRACOTTA.pick(color);
            String name = color.getSerializedName() + "_glazed_terracotta";

            Block stairs = ModBlocks.registerBlock(name + "_stairs",
                    properties -> new StairBlock(base.defaultBlockState(),
                            properties
                                    .mapColor(color.getMapColor())
                                    .instrument(NoteBlockInstrument.BASEDRUM)
                                    .requiresCorrectToolForDrops()
                                    .pushReaction(PushReaction.PUSH_ONLY)
                                    .strength(1.4F)));

            Block slab = ModBlocks.registerBlock(name + "_slab",
                    properties -> new SlabBlock(
                            properties
                                    .mapColor(color.getMapColor())
                                    .instrument(NoteBlockInstrument.BASEDRUM)
                                    .requiresCorrectToolForDrops()
                                    .pushReaction(PushReaction.PUSH_ONLY)
                                    .strength(1.4F)));

            Block wall = ModBlocks.registerBlock(name + "_wall",
                    properties -> new WallBlock(
                            properties
                                    .mapColor(color.getMapColor())
                                    .instrument(NoteBlockInstrument.BASEDRUM)
                                    .requiresCorrectToolForDrops()
                                    .pushReaction(PushReaction.PUSH_ONLY)
                                    .strength(1.4F)
                    ));

            GLAZED_TERRACOTTA_FAMILY.put(color, new family(base, stairs, slab, wall));
        }

    }

    public static void registerWool() {

        for (DyeColor color : DyeColor.values()) {

            Block base = Blocks.WOOL.pick(color);
            String name = color.getSerializedName() + "_wool";

            Block stairs = ModBlocks.registerBlock(name + "_stairs",
                    properties -> new StairBlock(base.defaultBlockState(),
                            properties
                                    .mapColor(color.getMapColor())
                                    .instrument(NoteBlockInstrument.GUITAR)
                                    .strength(0.8F)
                                    .sound(SoundType.WOOL)
                                    .ignitedByLava()));

            Block slab = ModBlocks.registerBlock(name + "_slab",
                    properties -> new SlabBlock(
                            properties
                                    .mapColor(color.getMapColor())
                                    .instrument(NoteBlockInstrument.GUITAR)
                                    .strength(0.8F)
                                    .sound(SoundType.WOOL)
                                    .ignitedByLava()));


            WOOL_FAMILY.put(color, new family_wool(base, stairs, slab));
        }

    }


}
