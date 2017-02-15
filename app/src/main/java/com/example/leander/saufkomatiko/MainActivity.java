package com.example.leander.saufkomatiko;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public ArrayList<String> list = new ArrayList<>();
    public ArrayAdapter<String> adap;
    public String[] arrayS = {"hi", "ho", "hey", "lo0", "tooooo"};
    public int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }

    public void startGame(View v){
        Intent intent = new Intent(this, StartGameActivity.class);
        intent.putExtra("players", list);
        startActivity(intent);
    }

    public void addPlayer(View v){
        EditText textBox = (EditText) findViewById(R.id.textBox);
        ListView listView = (ListView) findViewById(R.id.textView);

        list.add(textBox.getText().toString());

        adap = new ArrayAdapter<>(this, R.layout.listlayout, list);
        listView.setAdapter(adap);

        Toast.makeText(this, "Name Added " + textBox.getText().toString(), Toast.LENGTH_SHORT).show();
        textBox.setText("");
    }

    public void coolerClicker(View v){
        EditText editBox = (EditText) findViewById(R.id.textBox);
        ListView listView = (ListView) findViewById(R.id.textView);

        list.add(count, editBox.getText().toString());
        count++;

        MeinAdapterino ada = new MeinAdapterino(this, R.layout.stackoverflow, list);
        listView.setAdapter(ada);

        Toast.makeText(this, "Name Added " + editBox.getText().toString(), Toast.LENGTH_SHORT).show();
        editBox.setText("");
    }

    private class MeinAdapterino extends ArrayAdapter<String> {

        public MeinAdapterino(Context context, int resource, List<String> objects) {
            super(context, resource, objects);
        }


        @NonNull
        @SuppressLint("ViewHolder")
        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.stackoverflow, null);
            String m = getItem(position);
            TextView textView = (TextView) convertView.findViewById(R.id.id);
            if (m != null) {
                textView.setText(m);
            }
            return convertView;
        }
    }

}
