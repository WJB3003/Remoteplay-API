package co.willbrown.remoteplay.model;


public class Card {

    private String content;
    private CardType cardType;

    public Card(String content, CardType cardType) {
        this.content = content;
        this.cardType = cardType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

}
