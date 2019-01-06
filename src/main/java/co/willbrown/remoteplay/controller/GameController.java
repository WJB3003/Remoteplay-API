package co.willbrown.remoteplay.controller;

import co.willbrown.remoteplay.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class GameController {

    private HashMap<String, Room> rooms = new HashMap<>();

    @RequestMapping(value = "/create-room", method = RequestMethod.GET)
    public ResponseEntity<?> createRoom(){
        Room room = new Room();
        Game game = new Game();
        rooms.put(room.getCode(), room);

        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    public ResponseEntity<?> getAllRooms(){
        return new ResponseEntity<>(rooms.keySet(), HttpStatus.OK);
    }

    @RequestMapping(value = "/add-player/{roomCode}/{playerName}", method = RequestMethod.POST)
    public ResponseEntity<?> addPlayer(@PathVariable String playerName, @PathVariable String roomCode){
        Player user = new Player(playerName);
        Room room = rooms.get(roomCode);
        if(!user.equals(null) && !room.equals(null)) {
            room.addPlayer(user);
            return new ResponseEntity<>("Player added", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Player or Room is not here", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{roomCode}/players", method = RequestMethod.GET)
    public ResponseEntity<?> getAllPlayers(@PathVariable String roomCode){
        Room room = rooms.get(roomCode);

        return new ResponseEntity<>(room.getPlayerList(), HttpStatus.OK);
    }

    @RequestMapping(value = "/deal-one-card/{roomCode}/{player}")
    public ResponseEntity<?> dealOneCard(@PathVariable String roomCode, @PathVariable String player){
        Room room = rooms.get(roomCode);
        Player user = room.getPlayer(player);

        user.getHand().addCard(new Card("This is an answer", CardType.ANSWER));

        return new ResponseEntity<>("Card dealt", HttpStatus.OK);
    }

    @RequestMapping(value = "/{roomCode}/start-game", method = RequestMethod.GET)
    public ResponseEntity<?> startGame(@PathVariable String roomCode){
        Room room = rooms.get(roomCode);
        room.startGame();

        room.getGame().dealFirstHand();

        if(!room.equals(null)) return new ResponseEntity<>("Game started", HttpStatus.OK);

        return new ResponseEntity<>("Game had error", HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/{roomCode}/has-game-started", method = RequestMethod.GET)
    public ResponseEntity<?> hasGameStarted(@PathVariable String roomCode){
        Room room = rooms.get(roomCode);

        if(room.getGameStarted()) return new ResponseEntity<>("Game Already Started", HttpStatus.OK);

        return new ResponseEntity<>("Game Not Started", HttpStatus.OK);
    }

    @RequestMapping(value = "/{roomCode}/get-question", method = RequestMethod.GET)
    public ResponseEntity<?> getQuestion(@PathVariable String roomCode){
        Room room = rooms.get(roomCode);
        Card question = room.getGame().drawQuestion();

        if(room.getGame().equals(null)) return new ResponseEntity<>("Game hasn't started yet", HttpStatus.FORBIDDEN);

        return new ResponseEntity<>(question, HttpStatus.OK);
    }

//    @RequestMapping(value = "/{roomCode}/start-round", method = RequestMethod.GET)
//    public ResponseEntity<?> startRound(@PathVariable String roomCode){
//        return null;
//    }
//
//    @RequestMapping(value = "/{roomCode}/start-turn", method = RequestMethod.GET)
//    public ResponseEntity<?> startTurn(@PathVariable String roomCode){
//        return null;
//    }
//
//    @RequestMapping(value = "/{roomCode}/winner/{winnerName}", method = RequestMethod.GET)
//    public ResponseEntity<?> chooseWinner(@PathVariable String roomCode, @PathVariable String user){
//        Room room = rooms.get(roomCode);
//
//        return new ResponseEntity<>(room, HttpStatus.OK);
//    }
}
