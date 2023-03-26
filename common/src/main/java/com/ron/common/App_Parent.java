package com.ron.common;

import android.app.Application;

import androidx.appcompat.app.AppCompatActivity;

import com.ron.common.utils.MSP;

import java.util.ArrayList;

public abstract class App_Parent extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        setGameActivity();
        MSP.initHelper(this,this.getString(R.string.game_title));
    }

    public abstract  void setGameActivity();

}
