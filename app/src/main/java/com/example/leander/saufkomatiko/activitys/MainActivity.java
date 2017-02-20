package com.example.leander.saufkomatiko.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.leander.saufkomatiko.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ArrayList<String> list = new ArrayList<>();
    public ArrayAdapter<String> adap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }

    public void startGame(View v){
        if(list.isEmpty())
            Toast.makeText(this, "You need at least one Player", Toast.LENGTH_SHORT).show();
        else {
            Intent intent = new Intent(this, StartGameActivity.class);
            intent.putExtra("players", list);
            startActivity(intent);
        }
    }

    public void addPlayer(View v){
        EditText textBox = (EditText) findViewById(R.id.nameField);
        ListView listView = (ListView) findViewById(R.id.playerList);
        String name = textBox.getText().toString();

        if (name.length() > 1) {
            list.add(name);
            adap = new ArrayAdapter<>(this, R.layout.listlayout, list);
            listView.setAdapter(adap);

            Toast.makeText(this, "The Player " + name + " was added!", Toast.LENGTH_SHORT).show();
            textBox.setText("");
        }else{
            Toast.makeText(this, "The name has to be at least 2 characters long!", Toast.LENGTH_SHORT).show();
        }
    }

}
