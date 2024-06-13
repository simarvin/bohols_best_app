package com.example.bohols_best_recipe;

public class RecipeModel {
    String RecipeName;
    String RecipeIngredients;
    int image;


    public RecipeModel(String recipeName, String recipeIngredients, int image) {
        this.RecipeName = recipeName;
        this.RecipeIngredients = recipeIngredients;
        this.image = image;

    }

    public String getRecipeName() {
        return RecipeName;
    }

    public String getRecipeIngredients() {
        return RecipeIngredients;
    }

    public int getImage() {
        return image;
    }
}
