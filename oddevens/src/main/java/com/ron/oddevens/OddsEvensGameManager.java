package com.ron.oddevens;



import com.ron.common.Card;
import com.ron.common.GameManager;

import java.util.ArrayList;
import java.util.Arrays;

public class OddsEvensGameManager extends GameManager {
    public static final int CARD1 =1;
    public static final int CARD2 =2;
    public static final int CARD3 =3;
    public static final int CARD4 =4;


    public OddsEvensGameManager() {
        super(new ArrayList<>(Arrays.asList(
                new CardOddEven(CARD1, R.drawable.img_card1),
                new CardOddEven(CARD2,R.drawable.img_card2),
                new CardOddEven(CARD3,R.drawable.img_card3),
                new CardOddEven(CARD4,R.drawable.img_card4)
        )));
    }
    public void set_card_odd_even(boolean is_even){
        ((CardOddEven)cards.get(index)).setIs_even(is_even);
    }
}
