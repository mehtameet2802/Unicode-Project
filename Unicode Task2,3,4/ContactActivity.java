package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity {


    public ListView listview1;
    public ArrayList<Contact> contacts;
    public Adapter adapter;
    public Button details;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        loadData();
        listview1 = findViewById(R.id.listview1);

        adapter = new Adapter(contacts, this);
        listview1.setAdapter(adapter);


    }



    private void loadData()
    {

        SharedPreferences sp=getSharedPreferences("Data", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sp.getString("data",null);
        Type type = new TypeToken<ArrayList<Contact>>() {}.getType();
        contacts=gson.fromJson(json,type);

        if(contacts == null)
        {
            contacts =new ArrayList<>();
        }
    }








}

