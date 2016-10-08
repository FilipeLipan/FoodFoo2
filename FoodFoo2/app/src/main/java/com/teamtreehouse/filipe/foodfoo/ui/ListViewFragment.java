package com.teamtreehouse.filipe.foodfoo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teamtreehouse.filipe.foodfoo.R;
import com.teamtreehouse.filipe.foodfoo.adapter.ListAdapter;
import com.teamtreehouse.filipe.foodfoo.model.Dish;

import java.util.ArrayList;

/**
 * Created by lispa on 20/09/2016.
 */

public abstract class ListViewFragment extends Fragment {

    private static final int VERTICAL_ITEM_SPACE = 48;
    public static final String KEY = "key";
    private ArrayList<Dish> mDishes;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        // this getContent will return an Array of objects from a specify type of Dish
        //if it comes from DessertFragment will receive an Array of desserts, for example
        mDishes = getContents();


        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        ListAdapter listAdapter = new ListAdapter(mDishes);
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

//        RecyclerView cardView = (RecyclerView) view.findViewById(R.id.recyclerView);
//        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
//        llm.setOrientation(LinearLayoutManager.VERTICAL);
//        cardView.setLayoutManager(llm);

        return view;
    }

    // this method makes possible to use the same ListViewFragment for all the Child Fragments
    //DessertFragment, DrinksFragment, EntryFragment, MainFragment, every fragment will load a different
    //array of dishes
    public abstract ArrayList<Dish> getContents();
}
