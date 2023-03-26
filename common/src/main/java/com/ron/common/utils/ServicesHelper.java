package com.ron.common.utils;

import androidx.appcompat.app.AppCompatActivity;

public class ServicesHelper {
    private static ServicesHelper _instance = new ServicesHelper();
    private UserScore user = new UserScore();
    public Class<? extends AppCompatActivity> game_activity;
    private ServicesHelper(){

    }
    public static ServicesHelper get_instance(){
        return _instance;
    }

    public UserScore getUser() {
        return user;
    }

    public  void setUser(UserScore user) {
        this.user = user;
    }

    public Class<? extends AppCompatActivity> getGame_activity() {
        return game_activity;
    }

    public void setGame_activity(Class<? extends AppCompatActivity> game_activity) {
        this.game_activity = game_activity;
    }
}
