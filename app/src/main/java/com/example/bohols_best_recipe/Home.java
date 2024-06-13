package com.example.bohols_best_recipe;

import android.app.Activity;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Home extends Activity {

    ArrayList<RecipeModel> recipeModels = new ArrayList<>();

    int[] recipeImages = {R.drawable.balbacua, R.drawable.broa, R.drawable.calamay,
                          R.drawable.chorizo,R.drawable.crayfish, R.drawable.halang, R.drawable.humba,
                            R.drawable.peanut, R.drawable.tableya, R.drawable.torta, R.drawable.ube};
    @Override
    protected void onCreate(Bundle SaveInstanceState) {

        super.onCreate(SaveInstanceState);
        setContentView(R.layout.home);

        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);

        setUpRecipeModels();

        R_RecyclerViewAdapter adapter = new R_RecyclerViewAdapter(this, recipeModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setUpRecipeModels(){
        String[] recipeNames = getResources().getStringArray(R.array.recipes);
        String[] recipeIngredients = getResources().getStringArray(R.array.ingredients);

        for(int i=0; i<recipeNames.length; i++){
            recipeModels.add(new RecipeModel(recipeNames[i], recipeIngredients[i] , recipeImages[i]));
        }
    }
}
