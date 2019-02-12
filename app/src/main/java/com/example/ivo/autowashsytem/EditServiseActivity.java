package com.example.ivo.autowashsytem;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dataacess.Modles.ServiseModel;
import com.example.dataacess.Repositories.ServisisRepository;

public class EditServiseActivity extends AppCompatActivity {

    private Button btnEdit;
    private EditText textName;
    private EditText textSedan;
    private EditText textVan;
    private EditText textJeep;
    private EditText textBus;
    private ServisisRepository repo;
    private ServiseModel model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_servise);

        setActionsEdit();
        AddinfoInViewModel();
        repo = new ServisisRepository(this);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServiseModel sModel =  new ServiseModel();
                sModel.name = textName.getText().toString();
                sModel.sedan = Integer.parseInt(textSedan.getText().toString());
                sModel.van = Integer.parseInt(textVan.getText().toString());
                sModel.jeep = Integer.parseInt(textJeep.getText().toString());
                sModel.bus = Integer.parseInt(textBus.getText().toString());
                sModel.id = Integer.parseInt(SettingsActivity.models.id.toString());
                repo.Update(sModel);
                GotoSettingsActivity();
            }
        });
    }

    private void GotoSettingsActivity() {
        Intent intent = new Intent(EditServiseActivity.this,SettingsActivity.class);
        startActivity(intent);
    }


    private void AddinfoInViewModel() {
        textName.append(SettingsActivity.models.name);
        textSedan.append(SettingsActivity.models.sedan.toString());
        textVan.append(SettingsActivity.models.van.toString());
        textJeep.append(SettingsActivity.models.jeep.toString());
        textBus.append(SettingsActivity.models.bus.toString());
    }

    private void setActionsEdit() {
        textName = (EditText)findViewById(R.id.nameServise);
        textSedan = (EditText)findViewById(R.id.sedan);
        textVan = (EditText)findViewById(R.id.van);
        textJeep = (EditText)findViewById(R.id.jeep);
        textBus = (EditText)findViewById(R.id.bus);
        btnEdit = (Button)findViewById(R.id.buttonEditServise);
    }
}
