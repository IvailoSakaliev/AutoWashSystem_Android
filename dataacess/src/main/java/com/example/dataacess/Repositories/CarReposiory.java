package com.example.dataacess.Repositories;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;

import com.example.dataacess.Modles.CarModel;

import java.util.ArrayList;
import java.util.List;

public class CarReposiory extends Repository {

    private ArrayList<String> modelcars= new ArrayList<String>();

    public CarReposiory(Context context) {
        super(context);
        AddModelcarInList();
    }

    private void AddModelcarInList() {
        modelcars.add("BMW");
        modelcars.add("Mercedes");
        modelcars.add("Audi");
        modelcars.add("Porshe");
        modelcars.add("Ford");
        modelcars.add("Bentley");
        modelcars.add("Citroen");
        modelcars.add("Honda");
        modelcars.add("Hunday");
        modelcars.add("Infinity");
        modelcars.add("Iveco");
        modelcars.add("Jaduar");
        modelcars.add("Alfa");
        modelcars.add("Kia");
        modelcars.add("Nisan");
        modelcars.add("Mazda");
        modelcars.add("Mini");
        modelcars.add("Opel");
        modelcars.add("Pejo");
        modelcars.add("Range Rolver");
        modelcars.add("Renault");
        modelcars.add("Seat");
        modelcars.add("Shkoda");
        modelcars.add("Subaru");
        modelcars.add("Suzuki");
        modelcars.add("Toyota");
        modelcars.add("Volvo");
    }

}
