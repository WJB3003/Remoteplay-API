package co.willbrown.remoteplay.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Game {

    private int numberOfRounds = 3;
    private Player judge;
    private List<Player> players;
    private HashMap<Player, Integer> score;
    private int numberOfPlayers;
    private Deck questions = new Deck();
    private Deck answers = new Deck();

    public Game() {
        createQuestionDeck();
    }

    public Game(List<Player> players) {
        //default of 3
        this.judge = players.get(0);
        this.players = players;
        players.addAll(players);
        this.numberOfPlayers = players.size();
        createQuestionDeck();
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public Player getJudge() {
        return judge;
    }

    public void setJudge(Player judge) {
        this.judge = judge;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public HashMap<Player, Integer> getScore() {
        return score;
    }

    public void setScore(HashMap<Player, Integer> score) {
        this.score = score;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public Deck getQuestions() {
        return questions;
    }

    public void setQuestions(Deck questions) {
        this.questions = questions;
    }

    public Deck getAnswers() {
        return answers;
    }

    public void setAnswers(Deck answers) {
        this.answers = answers;
    }

    public void createQuestionDeck(){
        questions.addCards(
                new Card("Question 1", CardType.QUESTION),
                new Card("Question 2", CardType.QUESTION),
                new Card("Question 3", CardType.QUESTION),
                new Card("Question 4", CardType.QUESTION),
                new Card("Question 5", CardType.QUESTION),
                new Card("Question 6", CardType.QUESTION),
                new Card("Question 7", CardType.QUESTION)
        );
    }

    public void dealFirstHand(){
        for(Player player: players){
            for(int i = 0; i <= 7; i++){
                Card topCard = new Card("ANSWER", CardType.ANSWER);
                player.getHand().addCard(topCard);
            }
        }
    }

    public Card drawQuestion(){
        return questions.getCardStack().pop();
    }
}
