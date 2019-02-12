package com.example.ivo.autowashsytem;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Message;
import android.os.Messenger;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dataacess.Modles.ServiseModel;
import com.example.dataacess.Repositories.ServisisRepository;

import java.util.ArrayList;
import java.util.Arrays;

public class SettingsActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String>  arrayList;
    private Button btnDeleteAll;
    private ServisisRepository repo;

    public  static ServiseModel models;
    private ArrayList<Object> modelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        repo = new ServisisRepository(this);
        FillListView();
        btnDeleteAll= (Button)findViewById(R.id.btnDeleteAll);

        btnDeleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                repo.DeleteAll();
                finish();
                startActivity(getIntent());
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GotoEditActivity(position);

            }
        });
    }

    private void GotoEditActivity(Integer position) {
        models = repo.getElement(position+1);
        Intent intent = new Intent(SettingsActivity.this,EditServiseActivity.class);
        startActivity(intent);
    }

    public void GotoServiseActivity(View v )
    {
        Intent intent = new Intent(SettingsActivity.this,ServiseActivity.class);
        startActivity(intent);
    }

    public void FillListView()
    {
        listView = (ListView)findViewById(R.id._list);
        Cursor res = repo.getAllData();
       arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(adapter);

        while (res.moveToNext()) {
            arrayList.add(res.getString(1));
            adapter.notifyDataSetChanged();
        }
    }

}
