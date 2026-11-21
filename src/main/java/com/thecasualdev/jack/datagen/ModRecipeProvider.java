package com.thecasualdev.jack.datagen;

import com.thecasualdev.jack.block.ModBlocks;
import com.thecasualdev.jack.block.VanillaBlocks;
import com.thecasualdev.jack.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
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

//              Important probably

                for (VanillaBlocks.family concrete : VanillaBlocks.CONCRETE_FAMILY.values()) {

                    stairBuilder(concrete.stairs(), Ingredient.of(concrete.base()))
                            .unlockedBy(getHasName(concrete.base()), has(concrete.base()))
                            .save(output);

                    slab(RecipeCategory.BUILDING_BLOCKS, concrete.slab(), concrete.base());
                    wall(RecipeCategory.BUILDING_BLOCKS, concrete.wall(), concrete.base());

                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, concrete.stairs(), concrete.base(), 1);
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, concrete.wall(), concrete.base(), 1);
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, concrete.slab(), concrete.base(), 2);
                }

                for (VanillaBlocks.family terracotta : VanillaBlocks.TERRACOTTA_FAMILY.values()) {

                    stairBuilder(terracotta.stairs(), Ingredient.of(terracotta.base()))
                            .unlockedBy(getHasName(terracotta.base()), has(terracotta.base()))
                            .save(output);

                    slab(RecipeCategory.BUILDING_BLOCKS, terracotta.slab(), terracotta.base());
                    wall(RecipeCategory.BUILDING_BLOCKS, terracotta.wall(), terracotta.base());

                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, terracotta.stairs(), terracotta.base(), 1);
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, terracotta.wall(), terracotta.base(), 1);
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, terracotta.slab(), terracotta.base(), 2);
                }

                for (VanillaBlocks.family glazed_terracotta : VanillaBlocks.GLAZED_TERRACOTTA_FAMILY.values()) {

                    stairBuilder(glazed_terracotta.stairs(), Ingredient.of(glazed_terracotta.base()))
                            .unlockedBy(getHasName(glazed_terracotta.base()), has(glazed_terracotta.base()))
                            .save(output);

                    slab(RecipeCategory.BUILDING_BLOCKS, glazed_terracotta.slab(), glazed_terracotta.base());
                    wall(RecipeCategory.BUILDING_BLOCKS, glazed_terracotta.wall(), glazed_terracotta.base());

                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, glazed_terracotta.stairs(), glazed_terracotta.base(), 1);
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, glazed_terracotta.wall(), glazed_terracotta.base(), 1);
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, glazed_terracotta.slab(), glazed_terracotta.base(), 2);
                }

            }
        };
    }

    @Override
    public String getName() {
        return "Strange Expansion Recipes";
    }
}
