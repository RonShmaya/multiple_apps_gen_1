package com.ron.oddevens;

import com.ron.common.Card;

public class CardOddEven extends Card {
    private int key;
    private boolean is_even;

    public CardOddEven(int key,int res) {
        super(res);
        this.key = key;
    }

    @Override
    public int compare(Card card) {
        if (!(card instanceof CardOddEven))
            return -1;
        CardOddEven other = (CardOddEven) card;
        if (is_even){
           int val =  this.key + other.key;
           return val % 2 == 0 ? 1 : -1;
        }
        else {
            int val =  this.key + other.key;
            return val % 2 == 1 ? 1 : -1;
        }
    }

    public boolean isIs_even() {
        return is_even;
    }

    public CardOddEven setIs_even(boolean is_even) {
        this.is_even = is_even;
        return this;
    }
}
