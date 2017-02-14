package com.example.leander.saufkomatiko;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addPlayer(View v){
        EditText textBox = (EditText) v.findViewById(R.id.textBox);
        //ListView listView = (ListView) v.findViewById(R.id.textView);


    }

}
