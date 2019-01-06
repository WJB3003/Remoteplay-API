package co.willbrown.remoteplay.model;

import java.util.Collections;
import java.util.Stack;

public class Deck {

    private Stack<Card> cardStack = new Stack<>();

    public Deck() {

    }

    public Deck(Stack<Card> cardStack) {
        this.cardStack = cardStack;
    }

    public Stack<Card> getCardStack() {
        return cardStack;
    }

    public void setCardStack(Stack<Card> cardStack) {
        this.cardStack = cardStack;
    }

    public void addCards(Card ... cards){
        for(Card card : cards){
            cardStack.push(card);
        }
    }

    public Card dealCard(){
        return cardStack.pop();
    }

    public void suffle(){
        Collections.shuffle(cardStack);
    }
}
