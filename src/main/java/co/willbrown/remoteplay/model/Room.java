package co.willbrown.remoteplay.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Room {

    private List<Player> playerList = new ArrayList<>();
    private String code;
    private Game game;
    private boolean gameStarted = false;

    public Room() {
        this.code = generateCode();
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean getGameStarted(){
        return this.gameStarted;
    }

    public void setGameStarted(boolean gameStarted){
        this.gameStarted = gameStarted;
    }

    public String generateCode(){
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 4) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();
    }

    public void addPlayer(Player player){
        playerList.add(player);
    }

    public void startGame(){
        this.game = new Game(playerList);
        this.playerList = this.game.getPlayers();
        gameStarted = true;
    }

    public Player getPlayer(String name){
        for (Player player : playerList) {
            if(player.getName().equals(name)) return player;
        }
        return new Player("Player Not Found");
    }
}
