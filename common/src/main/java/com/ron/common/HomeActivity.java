package com.ron.common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.reflect.TypeToken;
import com.ron.common.utils.MSP;
import com.ron.common.utils.ServicesHelper;
import com.ron.common.utils.UserScore;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private TextInputEditText home_TIETL_user;
    private Button home_BTN_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        findViews();
    }

    private void findViews() {
        home_TIETL_user = findViewById(R.id.home_TIETL_user);
        home_BTN_submit = findViewById(R.id.home_BTN_submit);
        home_BTN_submit.setOnClickListener(view -> {
            if (home_TIETL_user.getText().toString() == null || home_TIETL_user.getText().toString().isEmpty()){
                Toast.makeText(HomeActivity.this, "User Name cant be empty", Toast.LENGTH_SHORT).show();
                return;
            }

            UserScore current_user = new UserScore().setName(home_TIETL_user.getText().toString());
            ServicesHelper.get_instance().setUser(current_user);
            go_next(ServicesHelper.get_instance().getGame_activity());
        });




    }
    private <T extends AppCompatActivity> void go_next(Class<T> nextActivity) {
        Intent intent = new Intent(this, nextActivity);
        startActivity(intent);
        finish();
    }
}