package com.example.bohols_best_recipe;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class R_RecyclerViewAdapter extends RecyclerView.Adapter<R_RecyclerViewAdapter.MyViewHolder> {
    ArrayList<RecipeModel> recipeModels = new ArrayList<>();
    Context context;

    public R_RecyclerViewAdapter(Context context, ArrayList<RecipeModel> recipeModels){
        this.context = context;
        this.recipeModels = recipeModels;
    }

    @NonNull
    @Override
    public R_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //This is where you inflating the layout (Giving a look to our rows) -- (ani na implement tong row na ginama sa xml layout file)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);

        return new  R_RecyclerViewAdapter.MyViewHolder(view);
    }
    public static final String Extra_Food = "food";
    @Override
    public void onBindViewHolder(@NonNull R_RecyclerViewAdapter.MyViewHolder holder, int position) {

        //assigning values to the views we created in the recycler_view_layout file --(part na nga mo iterate based sa positions sa kada rows)
        //based on the position of the recycler view
        holder.tVname.setText(recipeModels.get(position).getRecipeName());
        holder.imageView.setImageResource(recipeModels.get(position).getImage());

        final int finalPosition = position;
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent(context, Ingredients.class);
                in.putExtra("Name", recipeModels.get(finalPosition).getRecipeName());
                in.putExtra("Ingredients", recipeModels.get(finalPosition).getRecipeIngredients());

                context.startActivity(in);
            }
        });


    }

    @Override
    public int getItemCount() {
        //the recycler view just wants to know the number of items you want  to displayed (ani nimo e set and value kung pila gyud ka rows or cards imong e display)
        return recipeModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        //grabbing all the views from our recycler_view_row layout file
        //kind a like in the onCreate method above pero ani gyud mismo mag assign sa mga varuable like murag nag instantiate

        ImageView imageView;
        TextView tVname;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            tVname = (TextView) itemView.findViewById(R.id.textView);
            cardView = (CardView) itemView.findViewById(R.id.cardView);

        }
    }
}
