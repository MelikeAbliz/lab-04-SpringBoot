package com.cydeo.service.impl;

import com.cydeo.enums.QuantityType;
import com.cydeo.enums.RecipeType;
import com.cydeo.model.Ingredient;
import com.cydeo.model.Recipe;
import com.cydeo.repository.RecipeRepository;
import com.cydeo.service.RecipeService;
import com.cydeo.service.ShareService;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
@Component
public class RecipeServiceImpl implements RecipeService {
    private final Faker faker;
    private final RecipeRepository recipeRepository;
    private final ShareService shareService;

    public RecipeServiceImpl(Faker faker, RecipeRepository recipeRepository, ShareService shareService) {
        this.faker = faker;
        this.recipeRepository = recipeRepository;
        this.shareService = shareService;
    }


    @Override
    public boolean prepareRecipe() {
        //create a recipe object
        Recipe recipe = new Recipe();
        //set fields
        recipe.setRecipeId(UUID.randomUUID());
        recipe.setName(faker.food().dish());
        recipe.setDuration(generateRandomValue());
        recipe.setPreparation(faker.lorem().paragraph(5));
        recipe.setRecipeType(RecipeType.BREAKFAST);
        recipe.setIngredients(prepareIngredient());
        //save the recipe
        recipeRepository.save(recipe);
        //share recipe
        shareService.shareService(recipe);
        //return true
        return true;
    }

    private List<Ingredient> prepareIngredient() {
        //create a list
        List<Ingredient> ingredientList = new ArrayList<>();
        //fill list with random ingredients
        for (int i = 0; i < generateRandomValue(); i++) {
            Ingredient ingredient = new Ingredient();
            ingredient.setName(faker.food().ingredient());
            ingredient.setQuantity(generateRandomValue());
            ingredient.setQuantityType(QuantityType.TBSP);
        }
        //return list
        return ingredientList;
    }

    private int generateRandomValue() {
        return new Random().nextInt(20) + 1;
    }
}
