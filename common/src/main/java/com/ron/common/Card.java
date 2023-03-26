package com.ron.common;

import android.widget.ImageView;

public abstract class Card {
    protected int img_res;

    public Card(int img_res) {
        this.img_res = img_res;
    }

    public abstract int compare(Card card);

    public int get_image() {
        return img_res;
    }
}



