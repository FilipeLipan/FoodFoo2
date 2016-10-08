package com.teamtreehouse.filipe.foodfoo.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by lispa on 01/10/2016.
 */

/*
 * adb shell

 cd data/data/{pacote}
 cd data/data/{pacote} # ls

 cd data/data/{pacote} # cd databases
 cd data/data/{pacote}/databases # ls

 cd data/data/{pacote}/databases # sqlite3 {database.db}

 help
 .tables
 */

public class FoodFooSQLiteHelper extends SQLiteOpenHelper {

    //naming my database and selecting a version
    public static final String DB_NAME = "foodfoo.db";
    public static final int DB_VERSION = 1;

    //DISH
    //putting into variables the table name and his columns
    public static final String TABLE_DISH = "DISH";
    public static final String COLUMN_DISH_NAME = "NAME";
    public static final String COLUMN_DISH_PRICE = "PRICE";
    public static final String COLUMN_DISH_DESCRIPTION = "DESCRIPTION";
    public static final String COLUMN_DISH_IMAGE = "IMAGE";
    public static final String COLUMN_DISH_TYPE = "TYPE";

    //MENU
    //putting into variables the table name and his columns
    public static final String TABLE_MENU = "MENU";
    public static final String COLUMN_MENU_FOREING_KEY_DISH = "FK_ID_DISH";

    //CART
    //putting into variables the table name and his columns
    public static final String TABLE_CART = "CART";
    public static final String COLUMN_CART_FOREING_KEY_DISH = "FK_ID_DISH";

    // sql to create the table DISH
    public static final String CREATE_DISH = "CREATE TABLE " + TABLE_DISH + " (" +
            BaseColumns._ID  +  " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_DISH_NAME  +  " TEXT, "  +
            COLUMN_DISH_PRICE  +  " REAL, "  +
            COLUMN_DISH_DESCRIPTION  +  " TEXT, "  +
            COLUMN_DISH_IMAGE  +  " BLOB, "  +
            COLUMN_DISH_TYPE  +  " TEXT)";

    // sql to create the table MENU
    public static final String CREATE_MENU = "CREATE TABLE " + TABLE_MENU + " (" +
            BaseColumns._ID  +  " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_MENU_FOREING_KEY_DISH  +  " INTEGER, "  +
            "FOREIGN KEY(" + COLUMN_MENU_FOREING_KEY_DISH + ") REFERENCES "  +  TABLE_DISH  +  "(_ID))";

    // sql to create the table CART
    public static final String CREATE_CART = "CREATE TABLE " + TABLE_CART + " (" +
            BaseColumns._ID  +  " INTEGER PRIMARY KEY AUTOINCREMENT," +
            COLUMN_CART_FOREING_KEY_DISH  +  " INTEGER2534533, "  +
            "FOREIGN KEY(" + COLUMN_CART_FOREING_KEY_DISH + ") REFERENCES "  +  TABLE_DISH  +  "(_ID))";;


    public FoodFooSQLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //creating my tables
        db.execSQL(CREATE_DISH);
        db.execSQL(CREATE_MENU);
        db.execSQL(CREATE_CART);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
