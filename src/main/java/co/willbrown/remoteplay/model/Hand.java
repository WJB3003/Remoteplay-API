package co.willbrown.remoteplay.model;

public class Hand {

    private int numberOfCards = 7;
    private Card[] myhand = new Card[numberOfCards];

    public Hand() {

    }

    public Hand(int numberOfCards, Card[] myhand) {
        this.numberOfCards = numberOfCards;
        this.myhand = myhand;
    }

    public int getNumberOfCards() {
        return numberOfCards;
    }

    public void setNumberOfCards(int numberOfCards) {
        this.numberOfCards = numberOfCards;
    }

    public Card[] getMyhand() {
        return myhand;
    }

    public void setMyhand(Card[] myhand) {
        this.myhand = myhand;
    }

    public void populateHand(){

    }
}