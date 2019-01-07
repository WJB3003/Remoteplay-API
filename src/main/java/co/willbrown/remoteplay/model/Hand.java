package co.willbrown.remoteplay.model;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private int maxNumberOfCards = 7;
    private List<Card> myhand = new ArrayList<>();

    public Hand() {

    }

    public Hand(int maxNumberOfCards, ArrayList<Card> myhand) {
        this.maxNumberOfCards = maxNumberOfCards;
        this.myhand = myhand;
    }

    public int getMaxNumberOfCards() {
        return maxNumberOfCards;
    }

    public void setMaxNumberOfCards(int maxNumberOfCards) {
        this.maxNumberOfCards = maxNumberOfCards;
    }

    public List<Card> getMyhand() {
        return myhand;
    }

    public void setMyhand(List<Card> myhand) {
        this.myhand = myhand;
    }

    public void addCard(Card card){
        if(myhand.size() < 7) myhand.add(card);
    }
}
