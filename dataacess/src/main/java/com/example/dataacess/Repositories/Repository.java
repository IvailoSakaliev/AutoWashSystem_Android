package com.example.dataacess.Repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dataacess.DataContext;

public class Repository extends DataContext {
    private SQLiteDatabase db ;
    public Repository(Context context) {
        super(context);
        db = this.getWritableDatabase();
    }

    public boolean AddData(ContentValues contentValues, String TABLE_NAME )
    {
        SQLiteDatabase db= this.getWritableDatabase();
        long result = this.db.insert(TABLE_NAME, null, contentValues);
        if (result == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public void DeleteAll(String TABLE_NAME)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        this.db.execSQL("delete from "+ TABLE_NAME);
    }

    public Cursor getAllData(String TABLE_NAME) {
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor res = this.db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public void Update(String TABLE_NAME, ContentValues contentValues , String id)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        this.db.update(TABLE_NAME, contentValues, COLUM_SERVISE_ID +" = ?", new String[] {id});
    }


}
