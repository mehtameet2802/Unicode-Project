package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    public TextView nameView;
    public TextView numberView;
    public TextView birthdateView;
    public TextView emailidView;
    public Button msgbtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        nameView=findViewById(R.id.nameView);
        numberView=findViewById(R.id.numberView);
        birthdateView=findViewById(R.id.birthdateView);
        emailidView=findViewById(R.id.emailidView);
        msgbtn=findViewById(R.id.msgbtn);

        Intent intent= getIntent();
        String name=intent.getStringExtra("name");
        String number=intent.getStringExtra("number");
        String birthdate=intent.getStringExtra("birthdate");
        String email=intent.getStringExtra("email");

        nameView.setText(name);
        numberView.setText(number);
        birthdateView.setText(birthdate);
        emailidView.setText(email);


    }

    public void message(View view) {
        Intent intent = getIntent();
        String number = intent.getStringExtra("number");
        Intent intent1 = new Intent(Intent.ACTION_VIEW);
        intent1.setData(Uri.parse("sms:" + number));
        startActivity(intent1);

    }
    }
