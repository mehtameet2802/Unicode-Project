package com.example.gstcalculatorapp;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
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
        if(options == null)
        {
            options =new ArrayList<>();
        }

        add_data();

        adapter = new Adapter(options,this);
        listView.setAdapter(adapter);


    }

    public void add_data()
    {
        options.add(new Options("Almond Milk","18%"));
        options.add(new Options("Caffeinated Beverages","28%"));
        options.add(new Options("Electronic items","5%"));
        options.add(new Options("Educational Fees","18%"));
        options.add(new Options("Educational Fees","28%"));
        options.add(new Options("Hotels with Room Tariff from Rs 1,001 to Rs 7,500","12%"));
        options.add(new Options("Hotels with Room Tariff of Rs.7501 and above","18%"));
        options.add(new Options("Marine fuel","5%"));
        options.add(new Options("Plates and cups made of tree products","0%"));
    }


}