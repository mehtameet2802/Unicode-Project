package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    public ArrayList<Contact> contacts;
    public Context context;
    public Button details;
    public Button call;


    public Adapter(ArrayList<Contact> contacts, Context context) {
        this.contacts = contacts;
        this.context = context;
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.contactsdesign,null);
        TextView nameview;
        TextView numberview;
        numberview=row.findViewById(R.id.numberview);
        nameview=row.findViewById(R.id.nameview);
        nameview.setText(contacts.get(position).getName());
        numberview.setText(contacts.get(position).getNumber());

        call=row.findViewById(R.id.call);
        details=row.findViewById(R.id.details);

        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name =contacts.get(position).getName();
                String number= contacts.get(position).getNumber();
                String birthdate= contacts.get(position).getBirthdate();
                String email= contacts.get(position).getEmail();
                Intent intent = new Intent(context,DetailsActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("number",number);
                intent.putExtra("birthdate",birthdate);
                intent.putExtra("email",email);
                context.startActivity(intent);

            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=contacts.get(position).getNumber();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+number));
                context.startActivity(intent);
            }
        });

        return row;
    }



}
