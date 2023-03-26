package com.ron.multiple_apps_gen_1;


import com.ron.common.GameManager;

import java.util.ArrayList;
import java.util.Arrays;

public class PaperEtcGameManager extends GameManager {
    public static final int ROCK =1;
    public static final int PAPER =2;
    public static final int SCISSOR =3;

    public PaperEtcGameManager() {
        super(new ArrayList<>(Arrays.asList(
                new CardPaperEtc(ROCK, R.drawable.img_rock),
                new CardPaperEtc(PAPER,R.drawable.img_paper),
                new CardPaperEtc(SCISSOR,R.drawable.img_sic)
        )));
    }
}
