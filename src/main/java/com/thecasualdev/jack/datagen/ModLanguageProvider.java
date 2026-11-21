//  This Source Code Form is subject to the terms of the Mozilla Public
//  License, v. 2.0. If a copy of the MPL was not distributed with this
//  file, You can obtain one at https://mozilla.org/MPL/2.0/.
//
//  © 2026 thecasualdev

package com.thecasualdev.jack.datagen;

import com.thecasualdev.jack.block.ModBlocks;
import com.thecasualdev.jack.block.VanillaBlocks;
import com.thecasualdev.jack.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.DyeColor;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ModLanguageProvider extends FabricLanguageProvider {

    public ModLanguageProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(packOutput,"en_us", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.COOLITEM, "Cool Item");
        translationBuilder.add(ModItems.NOTCOOLITEM, "Not Cool Item");
        translationBuilder.add(ModBlocks.TEST_BLOCK, "Test Block");

        for (Map.Entry<DyeColor, VanillaBlocks.family> concrete_entry : VanillaBlocks.CONCRETE_FAMILY.entrySet()) {

            String name = formatNameFromColor(concrete_entry.getKey()) + " Concrete";

            VanillaBlocks.family concrete = concrete_entry.getValue();

            translationBuilder.add(concrete.stairs(), name + " Stairs");
            translationBuilder.add(concrete.slab(), name + " Slab");
            translationBuilder.add(concrete.wall(), name + " Wall");

        }

    }

    private static String formatNameFromColor(DyeColor color) {
        String id = color.getSerializedName();

        StringBuilder result = new StringBuilder();
        for (String name : id.split("_")) {
            if (!result.isEmpty()) result.append(' ');
            result.append(Character.toUpperCase(name.charAt(0))).append(name.substring(1));
        }
        return result.toString();
    }
}
