package com.ron.multiple_apps_gen_1;

import android.os.Bundle;
import android.view.View;

import com.ron.common.GameRootActivity;

public class PapaerEtcGameActivity extends GameRootActivity {
    @Override
    public void init_game_manager() {
        gameManager = new PaperEtcGameManager();
    }

    @Override
    public boolean is_need_extra() {
        return false;
    }

    @Override
    public void handle_extra() {
    }

    @Override
    public void on_submit() {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}