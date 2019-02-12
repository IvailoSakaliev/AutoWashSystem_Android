package com.example.ivo.autowashsytem;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dataacess.DataContext;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }

    public void GoTOTypeActivity(View v)
    {
        Intent intent = new Intent(HomeActivity.this,AddTypeOfCarActivity.class);
        startActivity(intent);
    }

    public void GoToSearchActivity(View v)
    {
        Intent intent = new Intent(HomeActivity.this,SearchActivity.class);
        startActivity(intent);
    }
    public void GoToReportActivity(View v)
    {
        Intent intent = new Intent(HomeActivity.this,ReportCarsActivity.class);
        startActivity(intent);
    }
    public void GotoContactActivity(View v)
    {
        Intent intent = new Intent(HomeActivity.this,ContactActivity.class);
        startActivity(intent);
    }
    public void GotoSettingsActivity(View v)
    {
        Intent intent = new Intent(HomeActivity.this,SettingsActivity.class);
        startActivity(intent);
    }
}
