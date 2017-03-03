package com.example.leander.saufkomatiko.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.leander.saufkomatiko.R;


/**
 * Created by Leander on 02.03.2017.
 */

public class ChooseGameModeActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //set content view AFTER ABOVE sequence (to avoid crash)
        this.setContentView(R.layout.chooser);
    }

    public void playWeed(View v){
        Intent intent = new Intent(this, SelectPlayerActivity.class);
        intent.putExtra("gamemode", false);
        startActivity(intent);
    }

    public void playAlk(View v){
        Intent intent = new Intent(this, SelectPlayerActivity.class);
        intent.putExtra("gamemode", true);
        startActivity(intent);
    }

}
