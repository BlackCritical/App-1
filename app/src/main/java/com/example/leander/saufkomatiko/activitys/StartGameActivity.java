package com.example.leander.saufkomatiko.activitys;

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

import com.example.leander.saufkomatiko.R;

import java.util.ArrayList;

/**
 * Created by Leander on 15.02.2017.
 */

public class StartGameActivity extends AppCompatActivity{

    private ImageSwitcher imgSw;
    private int[] images = {R.drawable.android_device_frame_land, R.drawable.phoneportraitvlandscape,
                            R.drawable.pic, R.drawable.code};
    private int[] colors = {R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark};
    private ArrayList<String> players;

    private int i = 0;
    private int random;
    private int last;
    private boolean isPrevious = false;

    private Animation inNext;
    private Animation outNext;
    private Animation inPrev;
    private Animation outPrev;

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

        inNext = AnimationUtils.loadAnimation(this, R.anim.in_next);
        outNext = AnimationUtils.loadAnimation(this, R.anim.out_next);
        inPrev = AnimationUtils.loadAnimation(this, R.anim.in_prev);
        outPrev = AnimationUtils.loadAnimation(this, R.anim.out_prev);

        imgSw.setInAnimation(inNext);
        imgSw.setOutAnimation(outNext);

        Intent intent = getIntent();
        players = intent.getStringArrayListExtra("players");
    }

    public void previous(View v){
        imgSw.setInAnimation(inPrev);
        imgSw.setOutAnimation(outPrev);
        random = last;
        if (isPrevious)
            Toast.makeText(this, "You can only go back once!", Toast.LENGTH_SHORT).show();
        else {
            imgSw.setImageResource(images[last]);
            isPrevious = true;

            if (i == 0)
                i = players.size();
            TextView displayTask = (TextView) findViewById(R.id.displayTask);
            displayTask.bringToFront();
            displayTask.setText("\nHello,\n" + players.get(--i) +
                    "\n you have to punch your neighbour, or drink 23 shots!");
        }
    }

    public void next(View v){
        imgSw.setInAnimation(inNext);
        imgSw.setOutAnimation(outNext);
        TextView displayTask = (TextView) findViewById(R.id.displayTask);
        displayTask.bringToFront();
        if(i >= players.size() - 1)
            i = -1;
        displayTask.setText("\nHello,\n" + players.get(++i) +
                "\n you have to punch your neighbour, or drink 23 shots!");

        isPrevious = false;
        last = random;
        while(random == last)
            random = (int) (Math.random() * images.length);
        //imgSw.setBackgroundColor(colors[random]);
        imgSw.setImageResource(images[random]);
    }

    public String getRandomTask(){
        return getString(R.string.task1);
    }

}
