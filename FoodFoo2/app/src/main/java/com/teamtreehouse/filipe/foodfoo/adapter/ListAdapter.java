package com.teamtreehouse.filipe.foodfoo.adapter;

import android.graphics.Bitmap;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.teamtreehouse.filipe.foodfoo.R;
import com.teamtreehouse.filipe.foodfoo.database.FoodFooDataSource;
import com.teamtreehouse.filipe.foodfoo.model.Dish;
import com.teamtreehouse.filipe.foodfoo.model.Menu;

import java.text.DecimalFormat;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lispa on 22/09/2016.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private ArrayList<Dish> dishes;

     public ListAdapter(ArrayList<Dish> dishes){
        this.dishes = dishes;
     }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
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
        private FloatingActionButton addButton;
        private TextView dishPrice;

        public ListViewHolder(View itemView) {
            super(itemView);

            dishName = (TextView) itemView.findViewById(R.id.dishName);
            dishDescription = (TextView) itemView.findViewById(R.id.dishDescription);
            dishImage = (ImageView) itemView.findViewById(R.id.dishImageView);
            addButton = (FloatingActionButton) itemView.findViewById(R.id.addButton);
            dishPrice = (TextView) itemView.findViewById(R.id.dishPrice);

            addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FoodFooDataSource dataSource = new FoodFooDataSource(view.getContext());
                    Dish dish = dishes.get(getAdapterPosition());
                    dish.setType("cart");
                    dataSource.createDish(dish);
                }
            });
        }

        public void bindView(int position){
            dishName.setText(dishes.get(position).getName());
            dishDescription.setText(dishes.get(position).getDescription());
            dishImage.setImageBitmap(dishes.get(position).getImage());
            DecimalFormat format = new DecimalFormat();
            format.setMaximumFractionDigits(2);
            format.setMinimumFractionDigits(2);
            dishPrice.setText("R$" + format.format(dishes.get(position).getPrice()));
        }


    }
}
