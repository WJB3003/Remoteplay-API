package co.willbrown.remoteplay;

import co.willbrown.remoteplay.model.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class test {

    @Test
    public void testHand(){

        Player will = new Player("will");
        Player mike = new Player("mike");
        Player eva = new Player("eva");
        Player warren = new Player("warren");

        List<Player> players = new ArrayList<>();

        players.add(will);
        players.add(mike);
        players.add(eva);
        players.add(warren);

        Game game = new Game(players);

        Card firstCard = game.drawAnswer();

        System.out.println(firstCard.getContent());

        will.getHand().addCard(firstCard);

        System.out.println(will.getHand().getMyhand().size());
    }

    @Test
    public void checkPlayerList(){

        Player will = new Player("will");
        Player mike = new Player("mike");
        Player eva = new Player("eva");
        Player warren = new Player("warren");

        List<Player> players = new ArrayList<>();

        players.add(will);
        players.add(mike);
        players.add(eva);
        players.add(warren);

        Game game = new Game(players);


        System.out.println(game.getPlayers().size());
    }

    @Test
    public void testSubmit(){

        Room room = new Room();
        Player player = new Player("will");

        room.addPlayer(player);
        room.startGame();
        room.getGame().dealFirstHand();

        Card card = player.getHand().getMyhand().get(0);

        player.setSubmitCard(card);

        System.out.println(player.getHand().getMyhand().contains(card));
        System.out.println(player.getHand().getMyhand().remove(card));
        System.out.println(player.getHand().getMyhand().add(room.getGame().drawAnswer()));
    }

    @Test
    public void testJudge(){
        Room room = new Room();

        Player will = new Player("will");
        Player mike = new Player("mike");
        Player eva = new Player("eva");
        Player warren = new Player("warren");

        room.addPlayer(will);
        room.addPlayer(mike);
        room.addPlayer(eva);
        room.addPlayer(warren);

        room.startGame();

        System.out.println(room.getGame().getJudge().getName());

        room.getGame().nextJudge();

        System.out.println(room.getGame().getJudge().getName());

    }

}
