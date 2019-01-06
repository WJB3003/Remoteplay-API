package co.willbrown.remoteplay;

import co.willbrown.remoteplay.model.*;
import org.junit.Test;

public class test {

    @Test
    public void testHand(){

//        Deck questions = new Deck();
//
//        questions.addCards(
//                new Card("Question 1", CardType.QUESTION),
//                new Card("Question 2", CardType.QUESTION),
//                new Card("Question 3", CardType.QUESTION),
//                new Card("Question 4", CardType.QUESTION),
//                new Card("Question 5", CardType.QUESTION),
//                new Card("Question 6", CardType.QUESTION)
//        );
//
//        questions.suffle();
//
//        for(int i = 0; i < 6; i++) {
//            System.out.println(questions.getCardStack().pop().getContent());
//        }

        Game game = new Game();

        for(int i = 0; i < 6; i++) {
            System.out.println(game.getQuestions().getCardStack().pop().getContent());
        }
    }

}
