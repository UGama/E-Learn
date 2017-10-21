package com.example.e_learn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gama on 28/3/17.
 */

public class DatabasesTest extends AppCompatActivity implements View.OnClickListener {

    Button AddDataDatabases;
    Button QueryDatabases;
    Button DeleteDatabases;
    Button UpdateDatabases;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.AddDataDatabases:
                Add();
                Log.i("DatabasesTest", "Add Successfully");
                break;
            case R.id.queryDatabases:
                Query();
                break;
            case R.id.deleteDatabases:
                Delete();
                break;
            case R.id.updateDatabases:
                Update();
                break;
        }
    }

    public void Delete() {
        DataSupport.deleteAll(School.class);
    }
    public void Add() {
        List<School> list = new ArrayList<>();
        School school1 = new School("图书馆", "Library");
        School school2 = new School("教室", "Classroom");
        School school3 = new School("操场", "Playground");
        School school4 = new School("公园", "Park");
        list.add(school1);
        list.add(school2);
        list.add(school3);
        list.add(school4);
        DataSupport.saveAll(list);
    }
    public void Query() {
        List<School> Scene = DataSupport.findAll(School.class);
        for (School school : Scene) {
            Log.i("MainActivity", String.valueOf(school.getId()));
            Log.i("MainActivity", school.getScene());
            Log.i("MainActivity", school.getEScene());
        }
    }
    public void Update() {
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.databases);
        AddDataDatabases = (Button) findViewById(R.id.AddDataDatabases);
        AddDataDatabases.setOnClickListener(this);

        QueryDatabases = (Button) findViewById(R.id.queryDatabases);
        QueryDatabases.setOnClickListener(this);

        DeleteDatabases = (Button) findViewById(R.id.deleteDatabases);
        DeleteDatabases.setOnClickListener(this);

        UpdateDatabases = (Button) findViewById(R.id.updateDatabases);
        UpdateDatabases.setOnClickListener(this);

    }

}
