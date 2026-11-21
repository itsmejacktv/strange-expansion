//  This Source Code Form is subject to the terms of the Mozilla Public
//  License, v. 2.0. If a copy of the MPL was not distributed with this
//  file, You can obtain one at https://mozilla.org/MPL/2.0/.
//
//  © 2026 thecasualdev

package com.thecasualdev.jack.datagen;

import com.thecasualdev.jack.block.ModBlocks;
import com.thecasualdev.jack.block.VanillaBlocks;
import com.thecasualdev.jack.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }


    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(ModBlocks.TEST_BLOCK);

//      Gonna have to manually do this because Microsoft/Mojang hates me and wants me dead.
//      #familyIsTheBestWishICouldUseItOnVanilliaObjects
        for (VanillaBlocks.family concrete : VanillaBlocks.CONCRETE_FAMILY.values()) {

            TextureMapping texture = TextureMapping.cube(concrete.base());

            Identifier full = ModelLocationUtils.getModelLocation(concrete.base());


            Identifier inner = ModelTemplates.STAIRS_INNER.create(concrete.stairs(), texture, blockModelGenerators.modelOutput);
            Identifier straight = ModelTemplates.STAIRS_STRAIGHT.create(concrete.stairs(), texture, blockModelGenerators.modelOutput);
            Identifier outer = ModelTemplates.STAIRS_OUTER.create(concrete.stairs(), texture, blockModelGenerators.modelOutput);

            blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createStairs(
                    concrete.stairs(),
                    BlockModelGenerators.plainVariant(inner),
                    BlockModelGenerators.plainVariant(straight),
                    BlockModelGenerators.plainVariant(outer)
            ));


            Identifier bottom = ModelTemplates.SLAB_BOTTOM.create(concrete.slab(), texture, blockModelGenerators.modelOutput);
            Identifier top = ModelTemplates.SLAB_TOP.create(concrete.slab(), texture, blockModelGenerators.modelOutput);

            blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSlab(
                    concrete.slab(),
                    BlockModelGenerators.plainVariant(bottom),
                    BlockModelGenerators.plainVariant(top),
                    BlockModelGenerators.plainVariant(full)
            ));


            Identifier post = ModelTemplates.WALL_POST.create(concrete.wall(), texture, blockModelGenerators.modelOutput);
            Identifier low = ModelTemplates.WALL_LOW_SIDE.create(concrete.wall(), texture, blockModelGenerators.modelOutput);
            Identifier tall = ModelTemplates.WALL_TALL_SIDE.create(concrete.wall(), texture, blockModelGenerators.modelOutput);

            blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createWall(
                    concrete.wall(),
                    BlockModelGenerators.plainVariant(post),
                    BlockModelGenerators.plainVariant(low),
                    BlockModelGenerators.plainVariant(tall)
            ));

            blockModelGenerators.registerSimpleItemModel(
                    concrete.wall(), ModelTemplates.WALL_INVENTORY.create(
                            concrete.wall(), texture, blockModelGenerators.modelOutput
                    )
            );

        }

        for (VanillaBlocks.family terracotta : VanillaBlocks.TERRACOTTA_FAMILY.values()) {

            TextureMapping texture = TextureMapping.cube(terracotta.base());

            Identifier full = ModelLocationUtils.getModelLocation(terracotta.base());


            Identifier inner = ModelTemplates.STAIRS_INNER.create(terracotta.stairs(), texture, blockModelGenerators.modelOutput);
            Identifier straight = ModelTemplates.STAIRS_STRAIGHT.create(terracotta.stairs(), texture, blockModelGenerators.modelOutput);
            Identifier outer = ModelTemplates.STAIRS_OUTER.create(terracotta.stairs(), texture, blockModelGenerators.modelOutput);

            blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createStairs(
                    terracotta.stairs(),
                    BlockModelGenerators.plainVariant(inner),
                    BlockModelGenerators.plainVariant(straight),
                    BlockModelGenerators.plainVariant(outer)
            ));


            Identifier bottom = ModelTemplates.SLAB_BOTTOM.create(terracotta.slab(), texture, blockModelGenerators.modelOutput);
            Identifier top = ModelTemplates.SLAB_TOP.create(terracotta.slab(), texture, blockModelGenerators.modelOutput);

            blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSlab(
                    terracotta.slab(),
                    BlockModelGenerators.plainVariant(bottom),
                    BlockModelGenerators.plainVariant(top),
                    BlockModelGenerators.plainVariant(full)
            ));


            Identifier post = ModelTemplates.WALL_POST.create(terracotta.wall(), texture, blockModelGenerators.modelOutput);
            Identifier low = ModelTemplates.WALL_LOW_SIDE.create(terracotta.wall(), texture, blockModelGenerators.modelOutput);
            Identifier tall = ModelTemplates.WALL_TALL_SIDE.create(terracotta.wall(), texture, blockModelGenerators.modelOutput);

            blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createWall(
                    terracotta.wall(),
                    BlockModelGenerators.plainVariant(post),
                    BlockModelGenerators.plainVariant(low),
                    BlockModelGenerators.plainVariant(tall)
            ));

            blockModelGenerators.registerSimpleItemModel(
                    terracotta.wall(), ModelTemplates.WALL_INVENTORY.create(
                            terracotta.wall(), texture, blockModelGenerators.modelOutput
                    )
            );

        }

        for (VanillaBlocks.family glazed_terracotta : VanillaBlocks.GLAZED_TERRACOTTA_FAMILY.values()) {

            TextureMapping texture = TextureMapping.cube(glazed_terracotta.base());

            Identifier full = ModelLocationUtils.getModelLocation(glazed_terracotta.base());


            Identifier inner = ModelTemplates.STAIRS_INNER.create(glazed_terracotta.stairs(), texture, blockModelGenerators.modelOutput);
            Identifier straight = ModelTemplates.STAIRS_STRAIGHT.create(glazed_terracotta.stairs(), texture, blockModelGenerators.modelOutput);
            Identifier outer = ModelTemplates.STAIRS_OUTER.create(glazed_terracotta.stairs(), texture, blockModelGenerators.modelOutput);

            blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createStairs(
                    glazed_terracotta.stairs(),
                    BlockModelGenerators.plainVariant(inner),
                    BlockModelGenerators.plainVariant(straight),
                    BlockModelGenerators.plainVariant(outer)
            ));


            Identifier bottom = ModelTemplates.SLAB_BOTTOM.create(glazed_terracotta.slab(), texture, blockModelGenerators.modelOutput);
            Identifier top = ModelTemplates.SLAB_TOP.create(glazed_terracotta.slab(), texture, blockModelGenerators.modelOutput);

            blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSlab(
                    glazed_terracotta.slab(),
                    BlockModelGenerators.plainVariant(bottom),
                    BlockModelGenerators.plainVariant(top),
                    BlockModelGenerators.plainVariant(full)
            ));


            Identifier post = ModelTemplates.WALL_POST.create(glazed_terracotta.wall(), texture, blockModelGenerators.modelOutput);
            Identifier low = ModelTemplates.WALL_LOW_SIDE.create(glazed_terracotta.wall(), texture, blockModelGenerators.modelOutput);
            Identifier tall = ModelTemplates.WALL_TALL_SIDE.create(glazed_terracotta.wall(), texture, blockModelGenerators.modelOutput);

            blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createWall(
                    glazed_terracotta.wall(),
                    BlockModelGenerators.plainVariant(post),
                    BlockModelGenerators.plainVariant(low),
                    BlockModelGenerators.plainVariant(tall)
            ));

            blockModelGenerators.registerSimpleItemModel(
                    glazed_terracotta.wall(), ModelTemplates.WALL_INVENTORY.create(
                            glazed_terracotta.wall(), texture, blockModelGenerators.modelOutput
                    )
            );

        }

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.COOLITEM, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.NOTCOOLITEM, ModelTemplates.FLAT_ITEM);
    }
}

