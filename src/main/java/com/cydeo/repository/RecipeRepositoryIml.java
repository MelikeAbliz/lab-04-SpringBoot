package com.cydeo.repository;

import com.cydeo.model.Recipe;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class RecipeRepositoryIml implements RecipeRepository{
    //we need to create one list of recipe to keep all recipes
    //and save method will add recipe to thar list
    List<Recipe> recipeList=new ArrayList<>();
    @Override
    public boolean save(Recipe recipe) {
        return recipeList.add(recipe);
    }
}
