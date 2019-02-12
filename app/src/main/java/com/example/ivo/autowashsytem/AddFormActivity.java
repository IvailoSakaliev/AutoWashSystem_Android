package com.example.ivo.autowashsytem;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dataacess.Repositories.CarReposiory;
import com.example.dataacess.Repositories.ServisisRepository;
import com.example.ivo.autowashsytem.ViewModels.AddFormVM;

import java.util.ArrayList;

public class AddFormActivity extends AppCompatActivity {

    TextView mOrder;
    String[] listItems;
    boolean[] checkedItems;
    ArrayList<Integer> mUserItems = new ArrayList<>();
    ArrayList<AddFormVM> modelServise = new ArrayList<>();
    int typeOfCar;
    ArrayList<String> items = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_form);
        typeOfCar = AddTypeOfCarActivity.type;
//
        mOrder = (TextView) findViewById(R.id.textViewServise);
//
//
        SelectAllServise();
        MoveElementInarray();
        checkedItems = new boolean[modelServise.size()];
        listItems = new String[modelServise.size()];
//
        mOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(AddFormActivity.this);
                mBuilder.setTitle("Servises");
                mBuilder.setMultiChoiceItems(listItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        if(isChecked){
                            mUserItems.add(position);
                        }else{
                            mUserItems.remove((Integer.valueOf(position)));
                        }
                    }
                });

                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String item = "";
                        for (int i = 0; i < mUserItems.size(); i++) {
                            item = item + listItems[mUserItems.get(i)];
                            if (i != mUserItems.size() - 1) {
                                item = item + ", ";
                            }
                        }
                        mOrder.setText(item);
                    }
                });

                mBuilder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                mBuilder.setNeutralButton("Clear", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        for (int i = 0; i < checkedItems.length; i++) {
                            checkedItems[i] = false;
                            mUserItems.clear();
                        }
                        mOrder.setText("");
                    }
                });

                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });
//


//        Spinner dropdown = findViewById(R.id.spinner1);

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//        dropdown.setAdapter(adapter);



    }

    private void MoveElementInarray() {
        for (int i = 0 ; i < modelServise.size(); i++)
        {
            listItems[i] = modelServise.get(i).name;
        }
    }


    private void SelectAllServise()    {
        ServisisRepository repoServise = new ServisisRepository(this);
        Cursor cursor = repoServise.getAllData();

        while (cursor.moveToNext())
        {
            CheckType(cursor);
        }
    }
    private void CheckType(Cursor cursor) {

        AddFormVM model = new AddFormVM();
        model.name = cursor.getString(1);
        switch (typeOfCar)
        {
            case 1 :
                model.price = Integer.parseInt(cursor.getString(2));
                break;
            case 2 :
                model.price = Integer.parseInt(cursor.getString(3));
                break;
            case 3 :
                model.price = Integer.parseInt(cursor.getString(4));
                break;
            case 4 :
                model.price = Integer.parseInt(cursor.getString(5));
                break;
        }
        modelServise.add(model);
    }
}
