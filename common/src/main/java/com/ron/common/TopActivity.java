package com.ron.common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.gson.reflect.TypeToken;
import com.ron.common.utils.MSP;
import com.ron.common.utils.ServicesHelper;
import com.ron.common.utils.UserScore;

import java.util.ArrayList;

public class TopActivity extends AppCompatActivity {
    private ArrayList<UserScore> clocksSchedule = new ArrayList<>();
    private TopAdapter topAdapter;
    private RecyclerView top_LST_table;
    private Button top_BTN_again;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);
        findViews();
        ArrayList<UserScore> users = MSP.getInstance().getArray(MSP.SCORES, new TypeToken<ArrayList<UserScore>>() {
        });
        if (users == null){
            users=new ArrayList<>();
        }
        users.sort((userScore, t1) -> t1.getScore() - userScore.getScore());
        topAdapter = new TopAdapter(users);
        top_LST_table.setAdapter(topAdapter);

    }

    private void findViews() {
        top_LST_table = findViewById(R.id.top_LST_table);
        top_BTN_again = findViewById(R.id.top_BTN_again);
        top_BTN_again.setOnClickListener(view -> go_next(ServicesHelper.get_instance().getGame_activity()));
    }
    private <T extends AppCompatActivity> void go_next(Class<T> nextActivity) {
        Intent intent = new Intent(this, nextActivity);
        startActivity(intent);
        finish();
    }
}