//  This Source Code Form is subject to the terms of the Mozilla Public
//  License, v. 2.0. If a copy of the MPL was not distributed with this
//  file, You can obtain one at https://mozilla.org/MPL/2.0/.
//
//  © 2026 thecasualdev

package com.thecasualdev.jack.datagen;

import com.thecasualdev.jack.block.ModBlocks;
import com.thecasualdev.jack.block.VanillaBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {

    public ModBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.getRk(ModBlocks.TEST_BLOCK));

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.getRk(ModBlocks.TEST_BLOCK));

        tag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
                .add(ModBlocks.getRk(ModBlocks.TEST_BLOCK));


        for (VanillaBlocks.family concrete : VanillaBlocks.CONCRETE_FAMILY.values()) {
            tag(BlockTags.MINEABLE_WITH_PICKAXE)
                    .add(ModBlocks.getRk(concrete.stairs()))
                    .add(ModBlocks.getRk(concrete.slab()))
                    .add(ModBlocks.getRk(concrete.wall()));

            tag(BlockTags.STAIRS).add(ModBlocks.getRk(concrete.stairs()));
            tag(BlockTags.SLABS).add(ModBlocks.getRk(concrete.slab()));
            tag(BlockTags.WALLS).add(ModBlocks.getRk(concrete.wall()));
        }

        for (VanillaBlocks.family terracotta : VanillaBlocks.TERRACOTTA_FAMILY.values()) {
            tag(BlockTags.MINEABLE_WITH_PICKAXE)
                    .add(ModBlocks.getRk(terracotta.stairs()))
                    .add(ModBlocks.getRk(terracotta.slab()))
                    .add(ModBlocks.getRk(terracotta.wall()));

            tag(BlockTags.STAIRS).add(ModBlocks.getRk(terracotta.stairs()));
            tag(BlockTags.SLABS).add(ModBlocks.getRk(terracotta.slab()));
            tag(BlockTags.WALLS).add(ModBlocks.getRk(terracotta.wall()));
        }

        for (VanillaBlocks.family glazed_terracotta : VanillaBlocks.GLAZED_TERRACOTTA_FAMILY.values()) {
            tag(BlockTags.MINEABLE_WITH_PICKAXE)
                    .add(ModBlocks.getRk(glazed_terracotta.stairs()))
                    .add(ModBlocks.getRk(glazed_terracotta.slab()))
                    .add(ModBlocks.getRk(glazed_terracotta.wall()));

            tag(BlockTags.STAIRS).add(ModBlocks.getRk(glazed_terracotta.stairs()));
            tag(BlockTags.SLABS).add(ModBlocks.getRk(glazed_terracotta.slab()));
            tag(BlockTags.WALLS).add(ModBlocks.getRk(glazed_terracotta.wall()));
        }

    }
}
