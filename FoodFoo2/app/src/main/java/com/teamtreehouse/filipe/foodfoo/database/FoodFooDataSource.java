package com.teamtreehouse.filipe.foodfoo.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.provider.BaseColumns;

import com.teamtreehouse.filipe.foodfoo.model.Dish;
import com.teamtreehouse.filipe.foodfoo.util.DbBitmapUtility;

import java.util.ArrayList;

/**
 * Created by lispa on 01/10/2016.
 */

public class FoodFooDataSource {

    private Context mContext;
    private FoodFooSQLiteHelper mFoodFooSQLiteHelper;

    public FoodFooDataSource(Context context){
        mContext = context;

        //this code create the database when the constructor is call
        mFoodFooSQLiteHelper = new FoodFooSQLiteHelper(context);
        SQLiteDatabase database = mFoodFooSQLiteHelper.getReadableDatabase();
        database.close();
    }

    // open the database
    private SQLiteDatabase open(){
        return  mFoodFooSQLiteHelper.getWritableDatabase();
    }

    //close the database
    public void close(SQLiteDatabase database) {
        database.close();
    }



    //receive a dish type and return all the dishes with that type
    public ArrayList<Dish> readDishes(String type){
        //open the database
        SQLiteDatabase database = open();

        ArrayList<Dish> dishes = new ArrayList<Dish>();

        //creating the query
        Cursor cursor = database.rawQuery(
                "SELECT * FROM "  +  FoodFooSQLiteHelper.TABLE_DISH  +
                        " WHERE TYPE = '"  +  type  +  "'", null);

        //putting every dish from the database into the array
        if(cursor.moveToFirst()){
            do{
                Dish dish = new Dish(
                getIntFromColumnName(cursor, BaseColumns._ID),
                getStringFromColumnName(cursor, FoodFooSQLiteHelper.COLUMN_DISH_NAME),
                getFloatFromColumnName(cursor, FoodFooSQLiteHelper.COLUMN_DISH_PRICE),
                getStringFromColumnName(cursor, FoodFooSQLiteHelper.COLUMN_DISH_DESCRIPTION),
                getBlobFromColumnName(cursor, FoodFooSQLiteHelper.COLUMN_DISH_IMAGE),
                getStringFromColumnName(cursor, FoodFooSQLiteHelper.COLUMN_DISH_TYPE));
                dishes.add(dish);
                }while (cursor.moveToNext());
            }

        cursor.close();
        close(database);
        return dishes;
    }

    //receive int from the database
    private int getIntFromColumnName(Cursor cursor, String columnName) {
        int columnIndex = cursor.getColumnIndex(columnName);
        return cursor.getInt(columnIndex);
    }

    //receive blob from the database and transforms it into a bitmap
    private Bitmap getBlobFromColumnName(Cursor cursor, String columnName) {
        byte[] imgByte = cursor.getBlob(cursor.getColumnIndex(columnName));
        return DbBitmapUtility.getImage(imgByte);
    }

    //receive String from the database
    private String getStringFromColumnName(Cursor cursor, String columnName) {
        int columnIndex = cursor.getColumnIndex(columnName);
        return cursor.getString(columnIndex);
    }

    //receive float from the database
    private double getFloatFromColumnName(Cursor cursor, String columnName) {
        int columnIndex = cursor.getColumnIndex(columnName);
        return cursor.getDouble(columnIndex);
    }


    public void createDish(Dish dish) {
        SQLiteDatabase database = open();
        database.beginTransaction();

        ContentValues dishValues = new ContentValues();
        dishValues.put(FoodFooSQLiteHelper.COLUMN_DISH_NAME, dish.getName());
        dishValues.put(FoodFooSQLiteHelper.COLUMN_DISH_PRICE, dish.getPrice());
        dishValues.put(FoodFooSQLiteHelper.COLUMN_DISH_DESCRIPTION, dish.getDescription());
        dishValues.put(FoodFooSQLiteHelper.COLUMN_DISH_IMAGE, DbBitmapUtility.getBytes(dish.getImage()));
        dishValues.put(FoodFooSQLiteHelper.COLUMN_DISH_TYPE, dish.getType());

        database.insert(mFoodFooSQLiteHelper.TABLE_DISH, null, dishValues);

        database.setTransactionSuccessful();
        database.endTransaction();
        close(database);
    }

    public void deleteDish(int dishId) {
        SQLiteDatabase database = open();
        database.beginTransaction();

        database.delete(FoodFooSQLiteHelper.TABLE_DISH, String.format("%s=%s" , BaseColumns._ID , String.valueOf(dishId)), null);

        database.setTransactionSuccessful();
        database.endTransaction();
        database.close();
    }
}
