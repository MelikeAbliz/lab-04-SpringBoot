package com.cydeo;

import com.cydeo.config.RecipeCreatorConfig;
import com.cydeo.service.RecipeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Lab04SpringBootApplication {

    public static void main(String[] args) {
        ApplicationContext container = SpringApplication.run(Lab04SpringBootApplication.class, args);
        RecipeService recipeService = container.getBean(RecipeService.class);
        recipeService.prepareRecipe();



        RecipeCreatorConfig recipeCreatorConfig = container.getBean(RecipeCreatorConfig.class);
        System.out.println("recipeCreatorConfig.getFirstName() = " + recipeCreatorConfig.getFirstName());
        System.out.println("recipeCreatorConfig.getLastName() = " + recipeCreatorConfig.getLastName());
    }

}
