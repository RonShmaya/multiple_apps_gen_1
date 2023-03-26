package com.ron.multiple_apps_gen_1;

import com.ron.common.Card;

public class CardPaperEtc extends Card {
    private int key;

    public CardPaperEtc(int key, int res) {
        super(res);
        this.key = key;
    }

    @Override
    public int compare(Card card) {
        if (!(card instanceof CardPaperEtc))
            return -1;
        CardPaperEtc other = (CardPaperEtc) card;
        if (key == other.key){
            return 0;
        }
        if(key == PaperEtcGameManager.PAPER) {
            if (other.key == PaperEtcGameManager.ROCK)
                return 1;
            else
                return -1;
        }
        if(key == PaperEtcGameManager.ROCK){
            if(other.key == PaperEtcGameManager.SCISSOR)
                return 1;
            else
                return -1;
        }
        if(key == PaperEtcGameManager.SCISSOR){
            if(other.key == PaperEtcGameManager.PAPER)
                return 1;
            else
                return -1;
        }
        return 0;
    }


}
