package com.example.ivo.autowashsytem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AddTypeOfCarActivity extends AppCompatActivity {

    private ImageButton sedan;
    private ImageButton van;
    private ImageButton jeep;
    private ImageButton bus;

    public static int type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_type_of_car);

        setAction();

        sedan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type = 1;
                GoToAddForm();
            }
        });

        van.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type = 2;
                GoToAddForm();
            }
        });

        jeep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type = 3;
                GoToAddForm();
            }
        });

        bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type = 3;
                GoToAddForm();
            }
        });
    }

    private void GoToAddForm() {
        Intent intent = new Intent(AddTypeOfCarActivity.this,AddFormActivity.class);
        startActivity(intent);
    }

    private void setAction() {
        sedan = findViewById(R.id.imageButtonSedan);
        van =  findViewById(R.id.imageButtonJeep);
        jeep =  findViewById(R.id.imageButtonVan);
        bus = findViewById(R.id.imageButtonBus);
    }
}
