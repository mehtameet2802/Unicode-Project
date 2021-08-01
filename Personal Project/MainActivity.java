package com.example.gstcalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int percent;
    Button gst_plus;
    Button gst_minus;
    Button percent5;
    Button percent12;
    Button percent18;
    Button percent28;
    Button clear;
    EditText baseamount;
    TextView cgstamount;
    TextView sgstamount;
    TextView netamount;
    TextView totalamount;
    TextView gstpercent;
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
        clear();


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
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
                gst();
                double amount =gstamount+gstamount;
                netamount.setText(String.valueOf(amount));
                double finalamount=input+gstamount+gstamount;
                totalamount.setText(String.valueOf(finalamount));

            }
        });

        gst_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gst();
                double amount =input-gstamount-gstamount;
                netamount.setText(String.valueOf(amount));
                double finalamount=input;
                totalamount.setText(String.valueOf(finalamount));
            }
        });
    }

    public void gst ()
    {
        intake = baseamount.getText().toString();
        input = Double.parseDouble(intake);
        gstamount = (percent * input) / 100;
        cgstamount.setText(String.valueOf(gstamount));
        sgstamount.setText(String.valueOf(gstamount));
    }

    public void clear()
    {
        cgstamount.setText(" ");
        sgstamount.setText(" ");
        netamount.setText(" ");
        totalamount.setText(" ");
        gstpercent.setText(" ");
        baseamount.setText(" ");
    }
}
