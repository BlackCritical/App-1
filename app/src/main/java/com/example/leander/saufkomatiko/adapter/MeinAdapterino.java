package com.example.leander.saufkomatiko.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.leander.saufkomatiko.R;

import java.util.List;

/**
 * Created by Leander on 14.02.2017.
 */
//public class MeinAdapterino extends ArrayAdapter<String> {
//
//    public MeinAdapterino(Context context, int resource, List<String> objects) {
//        super(context, resource, objects);
//    }
//
//
//    @NonNull
//    @SuppressLint("ViewHolder")
//    @Override
//    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
//        convertView = getLayoutInflater().inflate(R.layout.stackoverflow, null);
//        Mensch m = getItem(position);
//        TextView textView = (TextView) convertView.findViewById(R.id.id);
//        TextView textView2 = (TextView) convertView.findViewById(R.id.categoryId);
//        TextView textView3 = (TextView) convertView.findViewById(R.id.description);
//        if (m != null) {
//            textView.setText(m.name);
//            textView2.setText(m.vorname);
//            textView3.setText(m.alter);
//        }
//        return convertView;
//    }
//}
