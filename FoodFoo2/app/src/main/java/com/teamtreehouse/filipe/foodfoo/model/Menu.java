package com.teamtreehouse.filipe.foodfoo.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcel;
import android.os.Parcelable;

import com.teamtreehouse.filipe.foodfoo.R;

import java.util.ArrayList;

/**
 * Created by lispa on 22/09/2016.
 */

public class Menu{
    private ArrayList<Dish> desserts = new ArrayList<>();
    private ArrayList<Dish> mainCourses = new ArrayList<>();
    private ArrayList<Dish> drinks  = new ArrayList<>();
    private ArrayList<Dish> entries  = new ArrayList<>();


    public ArrayList<Dish> getDesserts() {
//        desserts.add(new Dish("CupCake", 2.50 , "It' Delicious and it is made with flower", , "dessert"));
//        desserts.add(new Dish("Cinnamon Rolls", 5.50 , "It' Delicious and it is made with flower", R.drawable.cinnamon_rolls, "dessert"));
//        desserts.add(new Dish("Donut Holes", 6.50 , "It' Delicious and it is made with flower", R.drawable.donut_holes, "dessert"));
//        desserts.add(new Dish("Muffins", 10.50 , "It' Delicious and it is made with flower", R.drawable.muffins, "dessert"));
//        desserts.add(new Dish("Pancakes", 15.50 , "It' Delicious and it is made with flower", R.drawable.pancakes, "dessert"));
        return desserts;
    }

    public ArrayList<Dish> getMainCourses() {
//        mainCourses.add(new Dish("maincour", 2.50 , "It' Delicious and it is made with flower", R.drawable.biscuits, "main"));
//        mainCourses.add(new Dish("Mainnn", 5.50 , "It' Delicious and it is made with flower", R.drawable.cinnamon_rolls, "main"));
        return mainCourses;
    }

    public ArrayList<Dish> getDrinks() {
//        drinks.add(new Dish("drink", 2.50 , "It' Delicious and it is made with flower", R.drawable.biscuits, "drink"));
//        drinks.add(new Dish("drink", 5.50 , "It' Delicious and it is made with flower", R.drawable.cinnamon_rolls, "drink"));
        return drinks;
    }

    public ArrayList<Dish> getEntries() {
//        entries.add(new Dish("entries", 2.50 , "It' Delicious and it is made with flower", R.drawable.biscuits, "entries"));
//        entries.add(new Dish("entries", 5.50 , "It' Delicious and it is made with flower", R.drawable.cinnamon_rolls, "entries"));
        return entries;
    }


}
