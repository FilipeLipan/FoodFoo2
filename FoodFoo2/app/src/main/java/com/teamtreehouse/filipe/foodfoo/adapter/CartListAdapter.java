package com.teamtreehouse.filipe.foodfoo.adapter;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.teamtreehouse.filipe.foodfoo.R;
import com.teamtreehouse.filipe.foodfoo.database.FoodFooDataSource;
import com.teamtreehouse.filipe.foodfoo.model.Dish;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by lispa on 22/09/2016.
 */

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ListViewHolder> {

    private ArrayList<Dish> dishes;

     public CartListAdapter(ArrayList<Dish> dishes){
        this.dishes = dishes;
     }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_list_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        ((ListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return dishes.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        private ImageView dishImage;
        private TextView dishName;
        private TextView dishDescription;
        private FloatingActionButton removeButton;
        private TextView dishPrice;

        public ListViewHolder(View itemView) {
            super(itemView);

            dishName = (TextView) itemView.findViewById(R.id.dishName);
            dishDescription = (TextView) itemView.findViewById(R.id.dishDescription);
            dishImage = (ImageView) itemView.findViewById(R.id.dishImageView);
            removeButton = (FloatingActionButton) itemView.findViewById(R.id.removeButton);
            dishPrice = (TextView) itemView.findViewById(R.id.dishPrice);

            removeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FoodFooDataSource dataSource = new FoodFooDataSource(view.getContext());


                    Toast.makeText(view.getContext(), dishes.get(getLayoutPosition()).getName() + " removido" , Toast.LENGTH_SHORT).show();
                    dishes.remove(getLayoutPosition());
                    notifyItemRemoved(getLayoutPosition());
                    dataSource.deleteDish(dishes.get(getLayoutPosition()).get_ID());
                }
            });
        }

        public void bindView(int position){
            dishName.setText(dishes.get(position).getName());
            dishDescription.setText(dishes.get(position).getDescription());
            dishImage.setImageBitmap(dishes.get(position).getImage());
            dishPrice.setText("R$" + Dish.getPriceString(dishes.get(position).getPrice()));
        }

        public void calcSubtotal(){
            double total = 0;

            for (Dish dish: dishes){
                total += dish.getPrice();
            }

        }
    }
}
