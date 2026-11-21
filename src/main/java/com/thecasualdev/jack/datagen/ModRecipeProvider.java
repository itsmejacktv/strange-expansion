package com.thecasualdev.jack.datagen;

import com.thecasualdev.jack.block.ModBlocks;
import com.thecasualdev.jack.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {

//                Test recipes

                List<ItemLike> GUBBY_BURNS = List.of(ModItems.COOLITEM);

                oreSmelting(GUBBY_BURNS, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.NOTCOOLITEM,
                        0.50f, 200, "gubby");
                oreBlasting(GUBBY_BURNS, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.NOTCOOLITEM,
                        0.50f, 50, "gubby");

                nineBlockStorageRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.NOTCOOLITEM,
                         RecipeCategory.BUILDING_BLOCKS, ModBlocks.TEST_BLOCK);

                shaped(RecipeCategory.MISC, ModItems.COOLITEM, 4)
                        .pattern("DDD")
                        .pattern("DND")
                        .pattern("DDD")
                        .define('D', Blocks.DIAMOND_BLOCK)
                        .define('N', Items.NETHERITE_HOE)
                        .unlockedBy(getHasName(Items.NETHERITE_HOE), has(Items.NETHERITE_HOE))
                        .group("gubby")
                        .save(output, "make_something_cool");

            }
        };
    }

    @Override
    public String getName() {
        return "Strange Expansion Recipes";
    }
}
