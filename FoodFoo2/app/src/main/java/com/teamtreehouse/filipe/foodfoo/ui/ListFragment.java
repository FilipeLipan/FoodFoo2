package com.teamtreehouse.filipe.foodfoo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teamtreehouse.filipe.foodfoo.R;
import com.teamtreehouse.filipe.foodfoo.fragments.CartFragment;
import com.teamtreehouse.filipe.foodfoo.fragments.DessertFragment;
import com.teamtreehouse.filipe.foodfoo.fragments.DrinksFragment;
import com.teamtreehouse.filipe.foodfoo.fragments.EntryFragment;
import com.teamtreehouse.filipe.foodfoo.fragments.MainFragment;
import com.teamtreehouse.filipe.foodfoo.model.Dish;
import com.teamtreehouse.filipe.foodfoo.model.Menu;

import java.util.ArrayList;

/**
 * Created by lispa on 20/09/2016.
 */

public class ListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        Menu menu = new Menu();

        //creating fragments, this fragments have a specific class, each class load a diferente type of Dish
        //DesserFragment load dessert from the database, EntryFragment loads entries and the others follow the same logic
        final ListViewFragment entryFragment = new EntryFragment();

        final ListViewFragment dessertFragment = new DessertFragment();

        final ListViewFragment mainCourseFragment = new MainFragment();

        final ListViewFragment drinksFragment = new DrinksFragment();

        final CartListViewFragment cartFragment = new CartFragment();

        //getting the viewpager id
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);

        //setting the adapter
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment;
                if(position == 1){
                    fragment = mainCourseFragment;
                }else if(position == 2){
                    fragment = dessertFragment;
                }else if(position == 3){
                    fragment = drinksFragment;
                }else if(position == 4){
                    fragment = cartFragment;
                }else{
                    fragment = entryFragment;
                }
                return fragment;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                CharSequence charSequence;
                if(position == 1){
                    charSequence = getString(R.string.mainCourse);
                }else if(position == 2){
                    charSequence = getString(R.string.dessert);
                }else if(position == 3){
                    charSequence = getString(R.string.drinks);
                }else if(position == 4){
                    charSequence = getString(R.string.shopping_cart);
                }else{
                    charSequence = getString(R.string.entry);
                }
                return charSequence ;
            }

            @Override
            public int getCount() {
                return 5;
            }
        });

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }
}
