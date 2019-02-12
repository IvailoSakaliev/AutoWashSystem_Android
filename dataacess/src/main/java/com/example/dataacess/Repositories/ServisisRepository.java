package com.example.dataacess.Repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.dataacess.Modles.ServiseModel;

public class ServisisRepository extends Repository {
    public ServisisRepository(Context context) {
        super(context);
    }

    public boolean AddDataServise(ServiseModel model)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUM_SERVISE_NAME, model.name);
        contentValues.put(COLUM_SERVISE_SEDAN, model.sedan);
        contentValues.put(COLUM_SERVISE_VAN, model.van);
        contentValues.put(COLUM_SERVISE_JEEP, model.jeep);
        contentValues.put(COLUM_SERVISE_BUS, model.bus);
        return super.AddData(contentValues, "SERVISE");
    }

    public void DeleteAll()
    {
        super.DeleteAll("SERVISE");
    }

    public Cursor getAllData() {
        return  super.getAllData("SERVISE");
    }

    public ServiseModel getElement(Integer id)
    {
        ServiseModel model = new ServiseModel();
        Cursor res   = getAllData();
        while (res.moveToNext())
        {
            if (id.toString().equals(res.getString(0)))
            {
                model.name = res.getString(1);
                model.sedan = Integer.parseInt(res.getString(2));
                model.van = Integer.parseInt(res.getString(3));
                model.jeep = Integer.parseInt(res.getString(4));
                model.bus = Integer.parseInt(res.getString(5));
                model.id = Integer.parseInt(res.getString(0));
                return model;
            }
        }
        return  model;

    }
    public void Update (ServiseModel model)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUM_SERVISE_NAME, model.name);
        contentValues.put(COLUM_SERVISE_SEDAN, model.sedan);
        contentValues.put(COLUM_SERVISE_VAN, model.van);
        contentValues.put(COLUM_SERVISE_JEEP, model.jeep);
        contentValues.put(COLUM_SERVISE_BUS, model.bus);

        super.Update("SERVISE", contentValues,model.id.toString());
    }



}
