package com.teamtreehouse.filipe.foodfoo.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import java.text.DecimalFormat;

/**
 * Created by lispa on 22/09/2016.
 */

public class Dish {
    private int _ID;
    private String name;
    private double price;
    private String description;
    private Bitmap image;
    private String type;

    public Dish(String name, double price, String description, Bitmap image,String type){
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
        this.type = type;
    }

    public Dish(int _ID, String name, double price, String description, Bitmap image,String type){
        this._ID = _ID;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
        this.type = type;
    }

    public int get_ID() {
        return _ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static String getPriceString(double price){
        DecimalFormat format = new DecimalFormat();
        format.setMaximumFractionDigits(2);
        format.setMinimumFractionDigits(2);

        return format.format(price);
    }

}
