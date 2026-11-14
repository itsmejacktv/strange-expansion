//  This Source Code Form is subject to the terms of the Mozilla Public
//  License, v. 2.0. If a copy of the MPL was not distributed with this
//  file, You can obtain one at https://mozilla.org/MPL/2.0/.
//
//  © 2026 thecasualdev

package com.thecasualdev.jack.item;

import com.thecasualdev.jack.StrangeExpansion;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ModItems {

    public static final Item COOLITEM = registerItem("cool", Item::new);


    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, StrangeExpansion.id(name),
                function.apply(
                        new Item.Properties().setId(ResourceKey.create(Registries.ITEM, StrangeExpansion.id(name)))
                ));
    }

    public static void registerModItems() {
        StrangeExpansion.LOGGER.info("Registering Mod ModItems for " + StrangeExpansion.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.accept(COOLITEM);
        });
    }
}
