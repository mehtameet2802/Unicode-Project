package com.example.gstcalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public ArrayList<Options> options;
    public int percent;
    public Button gst_plus;
    public Button gst_minus;
    public Button percent5;
    public Button percent12;
    public Button percent18;
    public Button percent28;
    public Button clear;
    public Button selectitem;
    public EditText baseamount;
    public TextView cgstamount;
    public TextView sgstamount;
    public TextView netamount;
    public TextView totalamount;
    public TextView gstpercent;
    public Adapter adapter;
    String intake;
    double input;
    double gstamount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        gst_plus = findViewById(R.id.addgstbtn);
        gst_minus = findViewById(R.id.subgstbtn);
        percent5 = findViewById(R.id.per5centbtn);
        percent12 = findViewById(R.id.per12centbtn);
        percent18 = findViewById(R.id.percent18btn);
        percent28 = findViewById(R.id.percent28btn);
        baseamount = findViewById(R.id.baseamount);
        cgstamount = findViewById(R.id.cgstamountview);
        sgstamount = findViewById(R.id.sgstamountview);
        netamount = findViewById(R.id.netamountview);
        totalamount = findViewById(R.id.finalamountview);
        gstpercent = findViewById(R.id.gstappliedview);
        clear=findViewById(R.id.clearbtn);
        selectitem=findViewById(R.id.selectitem);


        options =new ArrayList<Options>();


        clear();

        select();

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });

        selectitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(options == null)
                {
                    options =new ArrayList<>();
                }
                Intent intent = new Intent(MainActivity.this,SelectionPage.class);
                startActivity(intent);
            }
        });


        percent5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                percent = 5;
                gstpercent.setText("5%");

            }
        });

        percent12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                percent = 12;
                gstpercent.setText("12%");
            }
        });

        percent18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                percent = 18;
                gstpercent.setText("18%");
            }
        });

        percent28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                percent = 28;
                gstpercent.setText("28%");
            }
        });

        gst_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(baseamount.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Enter the base amount", Toast.LENGTH_SHORT).show();
                }
                else {
                    gstplus();
                    double amount = Math.round((gstamount + gstamount)*100)/100.0;
                    netamount.setText(String.valueOf(amount));
                    double finalamount = Math.round((input + gstamount + gstamount)*100)/100.0;
                    totalamount.setText(String.valueOf(finalamount));
                }
            }
        });

        gst_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(baseamount.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Enter the base amount", Toast.LENGTH_SHORT).show();
                }
                else {
                    gstminus();
                }
                }
        });
    }

    public void gstplus ()
    {
            intake = baseamount.getText().toString();
            input = Double.parseDouble(intake);
            gstamount = Math.round((percent/2.0 * input) / 100*100)/100.0;
            cgstamount.setText(String.valueOf(gstamount));
            sgstamount.setText(String.valueOf(gstamount));
    }
    public void gstminus()
        {
            intake = baseamount.getText().toString();
            input = Double.parseDouble(intake);
            double basevalue=Math.round(input/(1+percent/100.0)*100)/100.0;
            gstamount=Math.round(((percent/2.0)*basevalue)/100*100)/100.0;
            cgstamount.setText(String.valueOf(gstamount));
            sgstamount.setText(String.valueOf(gstamount));
            netamount.setText(String.valueOf(basevalue));
            totalamount.setText(String.valueOf(intake));

        }

    public void clear()
    {
        cgstamount.setText("");
        sgstamount.setText("");
        netamount.setText("");
        totalamount.setText("");
        gstpercent.setText("");
        baseamount.setText("");
    }

    public void select()
    {

        Intent intent =getIntent();
        String gstpercentage=intent.getStringExtra("gstpercent");
        gstpercent.setText(gstpercentage);
    }
}
