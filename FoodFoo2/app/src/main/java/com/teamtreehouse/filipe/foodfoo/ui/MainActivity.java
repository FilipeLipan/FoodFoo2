package com.teamtreehouse.filipe.foodfoo.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.teamtreehouse.filipe.foodfoo.R;
import com.teamtreehouse.filipe.foodfoo.database.FoodFooDataSource;
import com.teamtreehouse.filipe.foodfoo.model.Dish;
import com.teamtreehouse.filipe.foodfoo.model.Menu;
import com.teamtreehouse.filipe.foodfoo.util.DbBitmapUtility;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    public static final String LIST_FRAGMENT = "list_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListFragment savedFragment = (ListFragment) getSupportFragmentManager()
                .findFragmentByTag(LIST_FRAGMENT);
        if (savedFragment == null) {
            ListFragment fragment = new ListFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.placeHolder, fragment, LIST_FRAGMENT);
            fragmentTransaction.commit();
        }
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
//        FoodFooDataSource foodFooDataSource = new FoodFooDataSource(this);
//
//        Bitmap biscuits = BitmapFactory.decodeResource(getBaseContext().getResources(), R.drawable.biscuits);
//        Bitmap cinnamon_rolls = BitmapFactory.decodeResource(getBaseContext().getResources(), R.drawable.cinnamon_rolls);
//        Bitmap cupcakes = BitmapFactory.decodeResource(getBaseContext().getResources(), R.drawable.cupcakes);
//        Bitmap donut_holes = BitmapFactory.decodeResource(getBaseContext().getResources(), R.drawable.donut_holes);
//        Bitmap muffins = BitmapFactory.decodeResource(getBaseContext().getResources(), R.drawable.muffins);
//        Bitmap pancakes = BitmapFactory.decodeResource(getBaseContext().getResources(), R.drawable.pancakes);
//
//        ArrayList<Dish> desserts = new ArrayList<Dish>();
//
//        desserts.add(new Dish("CupCake", 2.50 , "It' Delicious and it is made with flower",biscuits , "dessert"));
//        desserts.add(new Dish("Cinnamon Rolls", 5.50 , "It' Delicious and it is made with flower", cinnamon_rolls, "dessert"));
//        desserts.add(new Dish("Donut Holes", 6.50 , "It' Delicious and it is made with flower", donut_holes, "dessert"));
//        desserts.add(new Dish("Muffins", 10.50 , "It' Delicious and it is made with flower", muffins, "dessert"));
//        desserts.add(new Dish("Pancakes", 15.50 , "It' Delicious and it is made with flower", pancakes, "dessert"));
//
//        desserts.add(new Dish("maincour", 2.50 , "It' Delicious and it is made with flower", biscuits, "main"));
//        desserts.add(new Dish("Mainnn", 5.50 , "It' Delicious and it is made with flower", cinnamon_rolls, "main"));
//
//        desserts.add(new Dish("drink", 2.50 , "It' Delicious and it is made with flower", biscuits, "drink"));
//        desserts.add(new Dish("drink", 5.50 , "It' Delicious and it is made with flower", cinnamon_rolls, "drink"));
//
//        desserts.add(new Dish("entries", 2.50 , "It' Delicious and it is made with flower", biscuits, "entry"));
//        desserts.add(new Dish("entries", 5 , "It' Delicious and it is made with flower", cinnamon_rolls, "entry"));
//        desserts.add(new Dish("entries", 5 , "It' Delicious and it is made with flower", cupcakes, "entry"));
//
//        for(Dish dish : desserts){
//            foodFooDataSource.createDish(dish);
//        }
    }
}
