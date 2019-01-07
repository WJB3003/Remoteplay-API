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

    private Deck answers = new Deck(
            new Card("1", CardType.ANSWER),
            new Card("2", CardType.ANSWER),
            new Card("3", CardType.ANSWER),
            new Card("4", CardType.ANSWER),
            new Card("5", CardType.ANSWER),
            new Card("6", CardType.ANSWER),
            new Card("7", CardType.ANSWER),
            new Card("8", CardType.ANSWER),
            new Card("9", CardType.ANSWER),
            new Card("10", CardType.ANSWER),
            new Card("11", CardType.ANSWER),
            new Card("12", CardType.ANSWER),
            new Card("13", CardType.ANSWER),
            new Card("14", CardType.ANSWER),
            new Card("15", CardType.ANSWER),
            new Card("16", CardType.ANSWER),
            new Card("17", CardType.ANSWER),
            new Card("18", CardType.ANSWER),
            new Card("19", CardType.ANSWER),
            new Card("20", CardType.ANSWER),
            new Card("21", CardType.ANSWER),
            new Card("22", CardType.ANSWER),
            new Card("23", CardType.ANSWER),
            new Card("24", CardType.ANSWER),
            new Card("25", CardType.ANSWER),
            new Card("26", CardType.ANSWER),
            new Card("27", CardType.ANSWER),
            new Card("28", CardType.ANSWER),
            new Card("29", CardType.ANSWER),
            new Card("30", CardType.ANSWER),
            new Card("31", CardType.ANSWER),
            new Card("32", CardType.ANSWER),
            new Card("33", CardType.ANSWER),
            new Card("34", CardType.ANSWER),
            new Card("35", CardType.ANSWER),
            new Card("36", CardType.ANSWER),
            new Card("37", CardType.ANSWER),
            new Card("38", CardType.ANSWER),
            new Card("39", CardType.ANSWER),
            new Card("40", CardType.ANSWER)
    );

    public Game() {
        createQuestionDeck();
        questions.suffle();
        answers.suffle();
    }

    public Game(List<Player> players) {
        //default of 3
        this.judge = players.get(0);
        this.players = players;
        this.numberOfPlayers = players.size();
        createQuestionDeck();
        questions.suffle();
        answers.suffle();
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

    public void createAnswerDeck(){
        answers.addCards(
                new Card("1", CardType.ANSWER),
                new Card("2", CardType.ANSWER),
                new Card("3", CardType.ANSWER),
                new Card("4", CardType.ANSWER),
                new Card("5", CardType.ANSWER),
                new Card("6", CardType.ANSWER),
                new Card("7", CardType.ANSWER),
                new Card("8", CardType.ANSWER),
                new Card("9", CardType.ANSWER),
                new Card("10", CardType.ANSWER),
                new Card("11", CardType.ANSWER),
                new Card("12", CardType.ANSWER),
                new Card("13", CardType.ANSWER),
                new Card("14", CardType.ANSWER),
                new Card("15", CardType.ANSWER),
                new Card("16", CardType.ANSWER),
                new Card("17", CardType.ANSWER),
                new Card("18", CardType.ANSWER),
                new Card("19", CardType.ANSWER),
                new Card("20", CardType.ANSWER),
                new Card("21", CardType.ANSWER),
                new Card("22", CardType.ANSWER),
                new Card("23", CardType.ANSWER),
                new Card("24", CardType.ANSWER),
                new Card("25", CardType.ANSWER),
                new Card("26", CardType.ANSWER),
                new Card("27", CardType.ANSWER),
                new Card("28", CardType.ANSWER),
                new Card("29", CardType.ANSWER),
                new Card("30", CardType.ANSWER),
                new Card("31", CardType.ANSWER),
                new Card("32", CardType.ANSWER),
                new Card("33", CardType.ANSWER),
                new Card("34", CardType.ANSWER),
                new Card("35", CardType.ANSWER),
                new Card("36", CardType.ANSWER),
                new Card("37", CardType.ANSWER),
                new Card("38", CardType.ANSWER),
                new Card("39", CardType.ANSWER),
                new Card("40", CardType.ANSWER)
        );
    }

    public void dealFirstHand(){
        for(Player player: players){
            for(int i = 0; i <= 7; i++){
                player.getHand().addCard(this.drawAnswer());
            }
        }
    }

    public Card drawQuestion(){
        return questions.getCardStack().pop();
    }

    public Card drawAnswer() {
        return answers.getCardStack().pop();
    }
}
