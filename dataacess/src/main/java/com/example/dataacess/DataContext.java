package com.example.dataacess;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

public class DataContext extends SQLiteOpenHelper {

    public static final String TAG = "DataContext";
    public static final String DATABASE_NAME = "AutoWash2.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_CARS = "CARS";
    public static final String COLUM_CARS_ID = "ID";
    public static final String COLUM_CARS_CARNAME = "CARNAME";


    public static final String TABLE_SERVISE = "SERVISE";
    public static final String COLUM_SERVISE_ID = "ID";
    public static final String COLUM_SERVISE_NAME = "NAME";
    public static final String COLUM_SERVISE_SEDAN = "SEDAN";
    public static final String COLUM_SERVISE_VAN = "VAN";
    public static final String COLUM_SERVISE_JEEP = "JEEP";
    public static final String COLUM_SERVISE_BUS= "BUS";

    public static final String TABLE_WORK = "WORK";
    public static final String COLUM_WORK_ID = "ID";
    public static final String COLUM_WORK_CARSID = "CARID";
    public static final String COLUM_WORK_SERVISE = "SERVISE";
    public static final String COLUM_WORK_PRICE = "PRICE";
    public static final String COLUM_WORK_DAY = "DAY";
    public static final String COLUM_WORK_MOUNT = "MOUNT";
    public static final String COLUM_WORK_YEAR = "YEAR";



    public DataContext (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_CARS+"(ID INTEGER PRIMARY KEY AUTOINCREMENT, CARNAME TEXT)");
        db.execSQL("CREATE TABLE "+TABLE_SERVISE+"(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, SEDAN INTEGER , VAN INTEGER,JEEP INTEGER, BUS INTEGER   )");
        db.execSQL("CREATE TABLE "+TABLE_WORK+"(ID INTEGER PRIMARY KEY AUTOINCREMENT, CARID INTEGER, SERVISE TEXT , PRICE INTEGER, DAY INTEGER,MOUNT INTEGER, YEAR INTEGER  )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CARS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SERVISE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORK);
        onCreate(db );
    }
}
