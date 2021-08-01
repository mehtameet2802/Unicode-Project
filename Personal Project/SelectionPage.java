package com.example.gstcalculatorapp;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import android.widget.ListView;
import android.widget.RadioButton;



import java.util.ArrayList;

public class SelectionPage extends AppCompatActivity {

    public ListView listView;
    public ArrayList<Options> options;
    public Adapter adapter;
    public RadioButton select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_page);


        listView=findViewById(R.id.listview);


        adapter = new Adapter(options,this);


        listView.setAdapter(adapter);



    }

}