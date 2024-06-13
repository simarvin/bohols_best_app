package com.example.bohols_best_recipe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Ingredients extends Activity {

    TextView textVIngredients;
    TextView textVName;

    @Override
    protected void onCreate(Bundle SaveIntanceState) {

        super.onCreate(SaveIntanceState);
        setContentView(R.layout.ingredients);

        textVName = (TextView) findViewById(R.id.textView3);
        textVIngredients = (TextView) findViewById(R.id.textView4);

        Intent in = getIntent();

        String Name = in.getExtras().getString("Name");
        String Ingredients = in.getExtras().getString("Ingredients");

        textVName.setText(Name);
        textVIngredients.setText(Ingredients);
    }
}
