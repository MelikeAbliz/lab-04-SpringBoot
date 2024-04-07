package com.cydeo.model;

import com.cydeo.enums.RecipeType;
import lombok.Data;

import java.util.List;
import java.util.UUID;
@Data
public class Recipe {
    private UUID recipeId;
    private String name;
    private int duration;
    private String preparation;
    List<Ingredient> ingredients;
    private RecipeType recipeType;
}
