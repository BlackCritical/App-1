package com.example.leander.saufkomatiko;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.ArrayList;

/**
 * Created by Leander on 15.02.2017.
 */

public class StartGameActivity extends AppCompatActivity{

    private ImageSwitcher imgSw;
    private int[] images = {R.drawable.android_device_frame_land, R.drawable.phoneportraitvlandscape,
            R.drawable.pic, R.drawable.code};
    private int[] colors = {R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark};
    private int random;
    private int last;
    private boolean isPrevious = false;
    private Animation in;
    private Animation out;
    private ArrayList<String> players;
    private int i = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tasks);
        imgSw = (ImageSwitcher) findViewById(R.id.imageSw);
        imgSw.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                return imageView;
            }
        });

        in = AnimationUtils.loadAnimation(this, R.anim.in);
        out = AnimationUtils.loadAnimation(this, R.anim.out);
        imgSw.setInAnimation(in);
        imgSw.setOutAnimation(out);

        Intent intent = getIntent();
        players = intent.getStringArrayListExtra("players");
    }

    public void previous(View v){
//        imgSw.setInAnimation(out);
//        imgSw.setOutAnimation(in);
        random = last;
        if (isPrevious)
            Toast.makeText(this, "You can only go back once!", Toast.LENGTH_SHORT).show();
        else {
            imgSw.setImageResource(images[last]);
            isPrevious = true;
        }
    }

    public void next(View v){
//        imgSw.setInAnimation(in);
//        imgSw.setOutAnimation(out);
        TextView displayTask = (TextView) findViewById(R.id.displayTask);
        displayTask.bringToFront();
        if(i > players.size() - 1)
            i = 0;
        displayTask.setText("\nHello,\n" + players.get(i++) +
                "\n you have to fuck your neighbour, or drink 23 shots!");

        isPrevious = false;
        last = random;
        while(random == last)
            random = (int) (Math.random() * colors.length);
        //imgSw.setBackgroundColor(colors[random]);
        imgSw.setImageResource(images[last]);
    }

}
