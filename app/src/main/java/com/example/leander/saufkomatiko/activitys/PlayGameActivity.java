package com.example.leander.saufkomatiko.activitys;

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

public class PlayGameActivity extends AppCompatActivity{

    private ImageSwitcher imgSw;
    private int[] images = {R.drawable.android_device_frame_land, R.drawable.phoneportraitvlandscape,
                            R.drawable.pic, R.drawable.code};
    //private int[] images2 = {R.drawable.black, R.drawable.blackk, R.drawable.orange};
    private int[] colors = {R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark};
    private String[] tasks;

    private ArrayList<String> players;

    private int i = 0;
    private int randomBonusPlayer;
    private int lastBonusPlayer;
    private int randomTask;
    private int randomImage;
    private int randomNumber;
    private int lastTask;
    private int lastImage;
    private int lastNumber;
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


        players = getIntent().getStringArrayListExtra("players");

        if (getIntent().getBooleanExtra("gamemode", true))
            tasks = new String[]{getString(R.string.task1), getString(R.string.task2),
                    getString(R.string.task3), getString(R.string.task4S),
                    getString(R.string.task5S), getString(R.string.task6S)};
        else
            tasks = new String[]{getString(R.string.task1W), getString(R.string.task2W)};

    }

    public void previous(View v){
        imgSw.setInAnimation(inPrev);
        imgSw.setOutAnimation(outPrev);

        randomTask = lastTask;
        randomNumber = lastNumber;
        randomImage = lastImage;
        randomBonusPlayer = lastBonusPlayer;

        if (isPrevious)
            Toast.makeText(this, "You can only go back once!", Toast.LENGTH_SHORT).show();
        else {
            imgSw.setImageResource(images[lastImage]);
            isPrevious = true;

            if (i == 0)
                i = players.size();
            TextView displayTask = (TextView) findViewById(R.id.displayTask);
            displayTask.bringToFront();

            if (lastTask < 3)
                displayTask.setText(String.format(tasks[lastTask], players.get(--i), lastNumber));
            else
                displayTask.setText(String.format(tasks[lastTask], players.get(--i),
                        players.get(lastBonusPlayer), lastNumber));
        }
    }

    public void next(View v){
        imgSw.setInAnimation(inNext);
        imgSw.setOutAnimation(outNext);

        TextView displayTask = (TextView) findViewById(R.id.displayTask);
        displayTask.bringToFront();
        if(i >= players.size() - 1)
            i = -1;

        isPrevious = false;
        lastTask = randomTask;
        lastImage = randomImage;
        lastNumber = randomNumber;
        while(randomTask == lastTask || randomImage == lastImage) {
            randomImage = (int) (Math.random() * images.length);
            randomTask = (int) (Math.random() * tasks.length);
            randomNumber = (int) (Math.random() * 4 + 2);
        }

        if (randomTask < 3)
            displayTask.setText(
                    String.format(tasks[randomTask],
                            players.get(++i),
                            randomNumber));
        else {
            lastBonusPlayer = randomBonusPlayer;
            randomBonusPlayer = ++i;
            while(randomBonusPlayer == i)
                randomBonusPlayer = (int) (Math.random() * players.size());

            displayTask.setText(
                    String.format(tasks[randomTask],
                            players.get(i), players.get(randomBonusPlayer),
                            randomNumber));
        }

        //imgSw.setBackgroundColor(colors[randomTask]);
        imgSw.setImageResource(images[randomImage]);
    }

}
