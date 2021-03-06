package co.willbrown.remoteplay.model;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private int maxNumberOfCards = 7;
    private boolean isJudge;
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

    public boolean isJudge() {
        return isJudge;
    }

    public void setJudge(boolean judge) {
        isJudge = judge;
    }

    public void addCard(Card card){
        if(myhand.size() < 7) myhand.add(card);
    }

    public void removeCard(Card card){
        for(Card i : myhand){
            if(i.equals(card))myhand.remove(i);
        }
    }
}
