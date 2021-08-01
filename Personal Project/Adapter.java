package com.example.gstcalculatorapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    public ArrayList<Options> options;
    public Context context;
    public RadioButton selectbtn;

    public Adapter(ArrayList<Options> options, Context context) {
        this.options = options;
        this.context = context;
    }



    @Override
    public int getCount() {
        return options.size();
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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.selectiondesign, null);
        TextView itemview;
        TextView percentview;
        itemview=row.findViewById(R.id.itemview);
        percentview=row.findViewById(R.id.percentview);
        itemview.setText(options.get(position).getName());
        percentview.setText(options.get(position).getPercentage());
        return row;
    }


};

