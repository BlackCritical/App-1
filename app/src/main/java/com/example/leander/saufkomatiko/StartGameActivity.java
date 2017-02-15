package com.example.leander.saufkomatiko;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by Leander on 15.02.2017.
 */

public class StartGameActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task);
        ImageView imageView = (ImageView) findViewById(R.id.taskImages);
        imageView.setImageResource(R.drawable.ic_test);
        setContentView(R.layout.task);
    }

}
