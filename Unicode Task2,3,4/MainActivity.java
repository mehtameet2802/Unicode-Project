package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    public ArrayList<Contact> contacts;

    public EditText name;
    public EditText number;
    public EditText birthdate;
    public EditText email;
    public Button savebutton;
    public Button clearbutton;
    public Button allcontacts;
    public Adapter adapter;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_CONTACTS,Manifest.permission.READ_CONTACTS},PackageManager.PERMISSION_GRANTED);

        name=findViewById(R.id.name);
        number=findViewById(R.id.number);
        birthdate=findViewById(R.id.birthdate);
        savebutton=findViewById(R.id.savebutton);
        clearbutton=findViewById(R.id.clearbutton);
        allcontacts=findViewById(R.id.allcontacts);
        email=findViewById(R.id.email);
        sp=getSharedPreferences("Data", Context.MODE_PRIVATE);

        contacts = new ArrayList<Contact>();

        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sp=getSharedPreferences("Data", Context.MODE_PRIVATE);
                Gson gson = new Gson();
                String json = sp.getString("data",null);
                Type type = new TypeToken<ArrayList<Contact>>() {}.getType();
                contacts=gson.fromJson(json,type);

                if(contacts == null)
                {
                contacts =new ArrayList<>();
                }


                String name1 = name.getText().toString().trim();
                String number1 = number.getText().toString().trim();
                String birthdate1= birthdate.getText().toString().trim();
                String email1=email.getText().toString().trim();
                if(name1.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Enter Name", Toast.LENGTH_SHORT).show();
                }
                else if(number1.length()>13 || number1.length()<10)
                {
                    number.setText("");
                    Toast.makeText(MainActivity.this, "Re-enter Phone number", Toast.LENGTH_SHORT).show();
                }
                else if(number1.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Re-enter number", Toast.LENGTH_SHORT).show();
                }
                else
                    {
                    contacts.add(new Contact(name1, number1, birthdate1, email1));
                    adapter.notifyDataSetChanged();
                    SharedPreferences.Editor editor = sp.edit();
                    Gson gson1 = new Gson();
                    String json1 = gson1.toJson(contacts);
                    editor.putString("data", json1);
                    editor.apply();

                    Intent intent5 = new Intent(MainActivity.this, ContactActivity.class);
                    startActivity(intent5);

                    clear();


                    Toast.makeText(MainActivity.this, "Contact saved", Toast.LENGTH_SHORT).show();
                }
            }
        });
        adapter =  new Adapter(contacts,this);

        clearbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });

        allcontacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
                Intent intent5 = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(intent5);
            }
        });

    }

    public void clear()
    {
        name.setText("");
        number.setText("");
        birthdate.setText("");
        email.setText("");
    }


}
