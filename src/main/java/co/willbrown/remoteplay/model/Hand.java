package co.willbrown.remoteplay.model;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private int numberOfCards = 7;
    private List<Card> myhand = new ArrayList<>();

    public Hand() {

    }

    public Hand(int numberOfCards, ArrayList<Card> myhand) {
        this.numberOfCards = numberOfCards;
        this.myhand = myhand;
    }

    public int getNumberOfCards() {
        return numberOfCards;
    }

    public void setNumberOfCards(int numberOfCards) {
        this.numberOfCards = numberOfCards;
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