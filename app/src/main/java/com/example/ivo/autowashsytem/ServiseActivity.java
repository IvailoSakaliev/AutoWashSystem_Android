package com.example.ivo.autowashsytem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dataacess.Modles.ServiseModel;
import com.example.dataacess.Repositories.ServisisRepository;

public class ServiseActivity extends AppCompatActivity {

    private String car;
    private String sedan;
    private String van;
    private String jeep;
    private String bus;

    private  EditText editTextCar;
    private EditText editTextSedanPrice;
    private EditText editTextVanPrice;
    private EditText editTextJeepPrice;
    private EditText editTextBusPrice;
    private Button addServise;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servise);

        SetComponents();

        addServise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    AddInformation();
            }
        });
    }

    private boolean CheckInformation() {

        return false;
    }

    private void AddInformation() {
        ServisisRepository repo = new ServisisRepository(this);
        ServiseModel model  = new ServiseModel();
        model.name = editTextCar.getText().toString();
        model.sedan = editTextSedanPrice.getText().toString() == "" ? 0 : Integer.parseInt(editTextSedanPrice.getText().toString());
        model.van = Integer.parseInt(editTextVanPrice.getText().toString());
        model.jeep = Integer.parseInt(editTextJeepPrice.getText().toString());
        model.bus = Integer.parseInt(editTextBusPrice.getText().toString());

        if (repo.AddDataServise(model)){
//            //GoToSettingsActvity();
            GoToSettingsActvity();
        }
        else
        {
            //CelanFields();
            Toast.makeText(ServiseActivity.this, "Error",Toast.LENGTH_LONG).show();
        }
    }

    private void CelanFields() {
         editTextCar.setText("");
         editTextSedanPrice.setText("");
         editTextVanPrice.setText("");
         editTextJeepPrice.setText("");
         editTextBusPrice.setText("");
    }

    private void GoToSettingsActvity() {
        Intent intent = new Intent(ServiseActivity.this,SettingsActivity.class);
            startActivity(intent);
    }

    private void SetComponents() {
        editTextCar = (EditText)findViewById(R.id.editTextCar);
        editTextSedanPrice = (EditText)findViewById(R.id.editTextSedanPrice);
        editTextVanPrice = (EditText)findViewById(R.id.editTextVanPrice);
        editTextJeepPrice = (EditText)findViewById(R.id.editTextJeepPrice);
        editTextBusPrice = (EditText)findViewById(R.id.editTextBusPrice);
        addServise = (Button)findViewById(R.id.buttonAddServise);
    }

}
