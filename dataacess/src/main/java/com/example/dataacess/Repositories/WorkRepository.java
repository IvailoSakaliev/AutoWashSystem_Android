package com.example.dataacess.Repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.dataacess.Modles.ServiseModel;
import com.example.dataacess.Modles.WorkModel;

public class WorkRepository extends  Repository {
    public WorkRepository(Context context) {
        super(context);
    }

//    public boolean AddData(WorkModel model)
//    {
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COLUM_WORK_CARSID, model.carID);
//        contentValues.put(COLUM_WORK_SERVISEID, model.serviseID);
//        contentValues.put(COLUM_WORK_DAY, model.day);
//        contentValues.put(COLUM_WORK_MOUNT, model.mount);
//        contentValues.put(COLUM_WORK_YEAR, model.year);
//        return super.AddData(contentValues, "WORK");
//    }

    public void DeleteAll(String TABLE_NAME)
    {
        super.DeleteAll("WORK");
    }

    public Cursor getAllData() {
        return  super.getAllData("WORK");
    }

}
