package com.ron.common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.textview.MaterialTextView;
import com.google.gson.reflect.TypeToken;
import com.ron.common.utils.MSP;
import com.ron.common.utils.ServicesHelper;
import com.ron.common.utils.UserScore;

import java.util.ArrayList;
import java.util.Comparator;

public abstract class GameRootActivity extends AppCompatActivity {
    protected AppCompatImageView game_IMG_card1;
    protected ImageView game_IMG_pre;
    protected ImageView game_IMG_next;
    protected AppCompatImageView game_IMG_card2;
    protected Button game_BTN_submit;
    protected GameManager gameManager;
    protected AppCompatImageView game_IMG_heart1;
    protected AppCompatImageView game_IMG_heart2;
    protected AppCompatImageView game_IMG_heart3;
    protected MaterialTextView game_LBL_score;
    protected int life=3;
    protected int score=0;

    protected RelativeLayout game_LAY_special;
    protected ImageView game_IMG_left;
    protected ImageView game_IMG_right;
    protected MaterialTextView game_LBL_odds;


    public abstract void init_game_manager();
    public abstract boolean is_need_extra();
    public abstract void handle_extra();
    public abstract void on_submit();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_root);
        init_game_manager();
        findViews();
        init_actions();
    }

    private void init_actions() {
        Integer first = gameManager.next();
        if (first != null){
            game_IMG_card1.setBackgroundResource(first);
        }
        game_IMG_pre.setOnClickListener(view -> {
            Integer res = gameManager.pre();
            if (res != null){
                game_IMG_card1.setBackgroundResource(res);
            }
        });
        game_IMG_next.setOnClickListener(view -> {
            Integer res = gameManager.next();
            if (res != null){
                game_IMG_card1.setBackgroundResource(res);
            }
        });
        game_BTN_submit.setOnClickListener(view -> {
            on_submit();
            Integer res = gameManager.rand_pc();
            if (res != null){
                game_IMG_card2.setBackgroundResource(res);
            }
            int result = gameManager.compare();

            if(result >= 1){
                win();
            }
            else if(result < 0){
                lose();
            }
            else{
                eq();
            }
            new Thread(() -> {
                try {
                    Thread.sleep(1300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(() -> game_IMG_card2.setBackgroundResource(R.drawable.img_back_card));
            }).start();
        });
    }

    public void game_over() {
        Toast.makeText(this, "Game Over!!!", Toast.LENGTH_SHORT).show();
        game_IMG_heart1.setVisibility(View.INVISIBLE);
        UserScore user = ServicesHelper.get_instance().getUser().setScore(score);
        ArrayList<UserScore> users = MSP.getInstance().getArray(MSP.SCORES, new TypeToken<ArrayList<UserScore>>() {
        });
        if (users == null){
            users=new ArrayList<>();
        }
        users.add(user);
        MSP.getInstance().putArray(MSP.SCORES, users);
        go_next(TopActivity.class);
        //users.sort((userScore, t1) -> t1.getScore() - userScore.getScore());

    }

    public void win()  {
        Toast.makeText(this, "Win!!!", Toast.LENGTH_SHORT).show();
        game_LBL_score.setText("Score: "+(++score));

    }

    public void lose() {

        if(life == 3){
            Toast.makeText(this, "Lose!!!", Toast.LENGTH_SHORT).show();
            life--;
            game_IMG_heart3.setVisibility(View.INVISIBLE);

        }
        else if(life == 2){
            Toast.makeText(this, "Lose!!!", Toast.LENGTH_SHORT).show();
            life--;
            game_IMG_heart2.setVisibility(View.INVISIBLE);

        }
        else if(life <= 1){
            game_over();
        }
    }

    public void eq() {
        Toast.makeText(this, "Even!!!", Toast.LENGTH_SHORT).show();
    }


    protected void findViews() {
        game_IMG_card1 = findViewById(R.id.game_IMG_card1);
        game_IMG_pre = findViewById(R.id.game_IMG_pre);
        game_IMG_next = findViewById(R.id.game_IMG_next);
        game_IMG_card2 = findViewById(R.id.game_IMG_card2);
        game_BTN_submit = findViewById(R.id.game_BTN_submit);
        game_IMG_heart1 = findViewById(R.id.game_IMG_heart1);
        game_IMG_heart2 = findViewById(R.id.game_IMG_heart2);
        game_IMG_heart3 = findViewById(R.id.game_IMG_heart3);
        game_LBL_score = findViewById(R.id.game_LBL_score);

        game_IMG_left = findViewById(R.id.game_IMG_left);
        game_IMG_right = findViewById(R.id.game_IMG_right);
        game_LAY_special = findViewById(R.id.game_LAY_special);
        game_LBL_odds = findViewById(R.id.game_LBL_odds);
        game_IMG_card2.setBackgroundResource(R.drawable.img_back_card);
        if (is_need_extra()){
            game_LAY_special.setVisibility(View.VISIBLE);
            handle_extra();
        }
    }

    private <T extends AppCompatActivity> void go_next(Class<T> nextActivity) {
        Intent intent = new Intent(this, nextActivity);
        startActivity(intent);
        finish();
    }
}