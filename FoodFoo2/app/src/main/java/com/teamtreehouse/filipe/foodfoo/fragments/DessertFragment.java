package com.teamtreehouse.filipe.foodfoo.fragments;

import com.teamtreehouse.filipe.foodfoo.database.FoodFooDataSource;
import com.teamtreehouse.filipe.foodfoo.model.Dish;
import com.teamtreehouse.filipe.foodfoo.model.Menu;
import com.teamtreehouse.filipe.foodfoo.ui.ListFragment;
import com.teamtreehouse.filipe.foodfoo.ui.ListViewFragment;

import java.util.ArrayList;

/**
 * Created by lispa on 02/10/2016.
 */

public class DessertFragment extends ListViewFragment {

    @Override
    public ArrayList<Dish> getContents() {
        FoodFooDataSource dataSource = new FoodFooDataSource(getContext());

        ArrayList<Dish> dishes = dataSource.readDishes("dessert");

        return dishes;
    }
}
