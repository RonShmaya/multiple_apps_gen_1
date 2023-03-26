package com.ron.oddevens;

import static java.lang.Thread.sleep;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ron.common.GameRootActivity;
import com.ron.common.R;

public class OddEventGameActivity extends GameRootActivity {
    public static final String EVEN = "Be Even";
    public static final String ODD = "Be Odd";
    @Override
    public void init_game_manager() {
        gameManager = new OddsEvensGameManager();
    }

    @Override
    public boolean is_need_extra() {
        return true;
    }

    @Override
    public void handle_extra() {
        game_IMG_left.setOnClickListener(on_click);
        game_IMG_right.setOnClickListener(on_click);
        game_LBL_odds.setText(ODD);
    }

    @Override
    public void on_submit() {
        ((OddsEvensGameManager)gameManager).set_card_odd_even(game_LBL_odds.getText() == EVEN ? true : false);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private View.OnClickListener on_click = view -> {
        if(game_LBL_odds.getText().toString().equals(ODD))
            game_LBL_odds.setText(EVEN);
        else
            game_LBL_odds.setText(ODD);
    };

}