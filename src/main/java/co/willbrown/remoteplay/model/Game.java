package co.willbrown.remoteplay.model;

import java.util.HashMap;
import java.util.List;

public class Game {

    private int numberOfRounds = 3;
    private Player judge;
    private List<Player> players;
    private HashMap<Player, Integer> score;
    private int numberOfPlayers;
    private Deck questions;
    private Deck answers;

    public Game() {

    }

    public Game(int numberOfRounds, Player judge, List<Player> players, HashMap<Player, Integer> score, int numberOfPlayers, Deck questions, Deck answers) {
        this.numberOfRounds = numberOfRounds;
        this.judge = judge;
        this.players = players;
        this.score = score;
        this.numberOfPlayers = numberOfPlayers;
        this.questions = questions;
        this.answers = answers;
    }

    public Game(List<Player> players) {
        //default of 3
        this.judge = players.get(0);
        this.players = players;
        players.addAll(players);
        this.numberOfPlayers = players.size();
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

    public void startGame(){

    }

    public void startRound(){
        for(int i = 0; i < numberOfPlayers; i++){
            startTurn();
        }
    }

    public void startTurn(){

    }
}
