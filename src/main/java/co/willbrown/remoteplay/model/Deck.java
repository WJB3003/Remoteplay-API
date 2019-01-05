package co.willbrown.remoteplay.model;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private List<Card> cardList = new ArrayList<>();

    public Deck() {

    }

    public Deck(List<Card> cardList) {
        this.cardList = cardList;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    public void dealCard(){

    }

    public void suffle(){

    }
}
