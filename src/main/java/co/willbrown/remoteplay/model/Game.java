package co.willbrown.remoteplay.model;

import java.util.HashMap;
import java.util.List;

public class Game {

    private int numberOfRounds = 3;
    private boolean round = false;
    private Player judge;
    private Player winner = null;
    private List<Player> players;
    private HashMap<Player, Integer> score = new HashMap<>();
    private int numberOfPlayers;
    private HashMap<Card, Player> displayedCards = new HashMap<>();
    private Card question;
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
            new Card("40", CardType.ANSWER),
            new Card("41", CardType.ANSWER),
            new Card("42", CardType.ANSWER),
            new Card("43", CardType.ANSWER),
            new Card("44", CardType.ANSWER),
            new Card("45", CardType.ANSWER),
            new Card("46", CardType.ANSWER),
            new Card("47", CardType.ANSWER),
            new Card("48", CardType.ANSWER),
            new Card("49", CardType.ANSWER),
            new Card("50", CardType.ANSWER),
            new Card("51", CardType.ANSWER),
            new Card("52", CardType.ANSWER),
            new Card("53", CardType.ANSWER),
            new Card("54", CardType.ANSWER),
            new Card("55", CardType.ANSWER),
            new Card("56", CardType.ANSWER),
            new Card("57", CardType.ANSWER),
            new Card("58", CardType.ANSWER),
            new Card("59", CardType.ANSWER),
            new Card("60", CardType.ANSWER),
            new Card("61", CardType.ANSWER),
            new Card("62", CardType.ANSWER),
            new Card("63", CardType.ANSWER),
            new Card("64", CardType.ANSWER),
            new Card("65", CardType.ANSWER),
            new Card("66", CardType.ANSWER),
            new Card("67", CardType.ANSWER),
            new Card("68", CardType.ANSWER),
            new Card("69", CardType.ANSWER),
            new Card("70", CardType.ANSWER),
            new Card("71", CardType.ANSWER),
            new Card("72", CardType.ANSWER),
            new Card("73", CardType.ANSWER),
            new Card("74", CardType.ANSWER),
            new Card("75", CardType.ANSWER),
            new Card("76", CardType.ANSWER),
            new Card("77", CardType.ANSWER),
            new Card("78", CardType.ANSWER),
            new Card("79", CardType.ANSWER),
            new Card("80", CardType.ANSWER)
    );

    public Game() {
        createQuestionDeck();
        questions.suffle();
        answers.suffle();
    }

    public Game(List<Player> players) {
        //default of 3
        this.players = players;
        addPlayersToScore(players);
        this.judge = players.get(0);
        this.numberOfPlayers = players.size();
        createQuestionDeck();
        questions.suffle();
        answers.suffle();
    }

    public boolean getRound() {
        return round;
    }

    public void setRound(boolean round) {
        this.round = round;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    private void addPlayersToScore(List<Player> players) {
        for(Player player : players){
            this.getScore().put(player, 0);
        }
    }

    public Card getQuestion() {
        return question;
    }

    public void setQuestion(Card question) {
        this.question = question;
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

    public HashMap<Card, Player> getDisplayedCards() {
        return displayedCards;
    }

    public void setDisplayedCards(HashMap<Card, Player> displayedCards) {
        this.displayedCards = displayedCards;
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
        Card topQuestion = questions.getCardStack().pop();
        this.question = topQuestion;

        return topQuestion;
    }

    public Card drawAnswer() {
        return answers.getCardStack().pop();
    }

    public boolean isJudge(Player player){
        return this.judge.equals(player);
    }

    public void nextJudge() {
        if(getPlayerNumber(this.judge) != ((players.size() - 1))){
            int currentJudge = getPlayerNumber(this.judge);
            this.judge = players.get(currentJudge + 1);
        }else {
            this.judge = players.get(0);
        }
    }

    public int getPlayerNumber(Player player){
        for(int i = 0; i < players.size(); i++){
            if(player.equals(players.get(i))) return i;
        }
        return -1;
    }
}
