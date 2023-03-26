package com.ron.common;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public abstract class GameManager {
    protected int index = -1;
    protected int pc_index = 0;
    protected ArrayList<Card> cards;


    public GameManager(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public Integer next(){
        if (cards == null || cards.isEmpty())
            return null;
        index++;
        if (index >= cards.size() || index < 0){
            index = 0;
        }

        return cards.get(index).get_image();
    }
    public Integer pre(){
        if (cards == null || cards.isEmpty())
            return null;
        index--;
        if (index < 0 || index >= cards.size()){
            index = cards.size()-1;
        }
        return cards.get(index).get_image();
    }
    public Integer rand_pc(){
        if (cards == null || cards.isEmpty())
            return null;
        pc_index = new Random().nextInt(cards.size());
        return cards.get(pc_index).get_image();
    }

    public int compare() {
        return cards.get(index).compare(cards.get(pc_index));
    }
}
