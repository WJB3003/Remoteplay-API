package co.willbrown.remoteplay.model;

public class Player {

    private String name;
    private Hand hand;
    private Card submitCard;

    public Player(String name, Hand hand, Card submitCard) {
        this.name = name;
        this.hand = hand;
        this.submitCard = submitCard;
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public Card getSubmitCard() {
        return submitCard;
    }

    public void setSubmitCard(Card submitCard) {
        this.submitCard = submitCard;
    }
}
