package com.example.dataroom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomItemAdapter extends BaseAdapter {


    Context ctx;
    int layoutItem;
    ArrayList<Item> arrayList;

    public CustomItemAdapter(Context ctx, int layoutItem, ArrayList<Item> arrayList) {
        this.ctx = ctx;
        this.layoutItem = layoutItem;
        this.arrayList = arrayList;
    }


    @Override
    public int getCount() {
        return arrayList.size();
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
        convertView = LayoutInflater.from(ctx).inflate(layoutItem, parent,false);
        TextView textView = convertView.findViewById(R.id.textViewItem);
//        Button btnSua = convertView.findViewById(R.id.imageButton1Item);
//        Button btnXoa = convertView.findViewById(R.id.imageButton2Item);

        textView.setText(arrayList.get(position).getName());


        return convertView;
    }
}
