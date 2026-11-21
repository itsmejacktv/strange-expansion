//  This Source Code Form is subject to the terms of the Mozilla Public
//  License, v. 2.0. If a copy of the MPL was not distributed with this
//  file, You can obtain one at https://mozilla.org/MPL/2.0/.
//
//  © 2026 thecasualdev

package com.thecasualdev.jack.datagen;

import com.thecasualdev.jack.block.ModBlocks;
import com.thecasualdev.jack.block.VanillaBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {
    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {

        dropSelf(ModBlocks.TEST_BLOCK);

        for (VanillaBlocks.family concrete : VanillaBlocks.CONCRETE_FAMILY.values()) {
            dropSelf(concrete.stairs());
            dropSelf(concrete.wall());
            add(concrete.slab(), createSlabItemTable(concrete.slab()));
        }

        for (VanillaBlocks.family terracotta : VanillaBlocks.TERRACOTTA_FAMILY.values()) {
            dropSelf(terracotta.stairs());
            dropSelf(terracotta.wall());
            add(terracotta.slab(), createSlabItemTable(terracotta.slab()));
        }

        for (VanillaBlocks.family glazed_terracotta : VanillaBlocks.GLAZED_TERRACOTTA_FAMILY.values()) {
            dropSelf(glazed_terracotta.stairs());
            dropSelf(glazed_terracotta.wall());
            add(glazed_terracotta.slab(), createSlabItemTable(glazed_terracotta.slab()));
        }

        for (VanillaBlocks.family_wool wool : VanillaBlocks.WOOL_FAMILY.values()) {
            dropSelf(wool.stairs());
            add(wool.slab(), createSlabItemTable(wool.slab()));
        }

    }
}
