package co.willbrown.remoteplay.controller;

import co.willbrown.remoteplay.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class GameController {

    private HashMap<String, Room> rooms = new HashMap<>();

    @GetMapping("/create-room")
    public ResponseEntity<?> createRoom(){
        Room room = new Room();
        rooms.put(room.getCode(), room);

        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @GetMapping("/rooms")
    public ResponseEntity<?> getAllRooms(){
        return new ResponseEntity<>(rooms.keySet(), HttpStatus.OK);
    }

    @PostMapping("/{roomCode}/players/{playerName}")
    public ResponseEntity<?> addPlayer(@PathVariable String playerName, @PathVariable String roomCode){
        Room room = rooms.get(roomCode);

        if(room.getPlayerList().contains(room.findByName(playerName))) return new ResponseEntity<>("PlayerName Taken", HttpStatus.BAD_REQUEST);

        Player user = new Player(playerName);

        if(!user.equals(null) && !room.equals(null)) {
            room.addPlayer(user);
            return new ResponseEntity<>("Player added", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Room is not here", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{roomCode}/players")
    public ResponseEntity<?> getAllPlayers(@PathVariable String roomCode){
        Room room = rooms.get(roomCode);

        return new ResponseEntity<>(room.getPlayerList(), HttpStatus.OK);
    }

    @PostMapping("/deal-one-card/{roomCode}/{player}")
    public ResponseEntity<?> dealOneCard(@PathVariable String roomCode, @PathVariable String player){
        Room room = rooms.get(roomCode);
        Player user = room.getPlayer(player);

        user.getHand().addCard(room.getGame().drawAnswer());

        return new ResponseEntity<>("Card dealt", HttpStatus.OK);
    }

    @GetMapping("/{roomCode}/start-game")
    public ResponseEntity<?> startGame(@PathVariable String roomCode){
        Room room = rooms.get(roomCode);
        room.startGame();

        room.getGame().dealFirstHand();

        if(!room.getGame().equals(null)) return new ResponseEntity<>("Game started", HttpStatus.OK);

        return new ResponseEntity<>("Game had error", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{roomCode}/has-game-started")
    public ResponseEntity<?> hasGameStarted(@PathVariable String roomCode){
        Room room = rooms.get(roomCode);

        if(room.getGameStarted()) return new ResponseEntity<>("Game Already Started", HttpStatus.OK);

        return new ResponseEntity<>("Game Not Started", HttpStatus.OK);
    }

    @GetMapping("/{roomCode}/get-question")
    public ResponseEntity<?> getQuestion(@PathVariable String roomCode){
        Room room = rooms.get(roomCode);
        Card question = room.getGame().drawQuestion();

        if(room.getGame().equals(null)) return new ResponseEntity<>("Game hasn't started yet", HttpStatus.FORBIDDEN);

        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    @PostMapping("/{roomCode}/{name}/submit-card")
    public ResponseEntity<?> submitCard(@PathVariable String roomCode, @RequestBody Card card, @PathVariable String name){
        Room room = rooms.get(roomCode);
        Player player = room.findByName(name);

        if(!room.isJudge(player)) {
            for (int i = 0; i < player.getHand().getMyhand().size(); i++) {
                if (card.getContent().equals(player.getHand().getMyhand().get(i).getContent())) {
                    card = player.getHand().getMyhand().get(i);
                }
            }

            room.getGame().getDisplayedCards().addCards(card);
            player.setSubmitCard(card);
            return new ResponseEntity<>("Card Submitted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Judge Cannot Submit a Card", HttpStatus.FORBIDDEN);
    }

    @GetMapping("/{roomCode}/{name}")
    public ResponseEntity<?> getPlayerCards(@PathVariable String roomCode, @PathVariable String name){

        Room room = rooms.get(roomCode);
        Player player = room.findByName(name);

        return new ResponseEntity<>(player.getHand().getMyhand(), HttpStatus.OK);
    }

    @GetMapping("/{roomCode}/judge")
    public ResponseEntity<?> getJudge(@PathVariable String roomCode){
        Room room = rooms.get(roomCode);

        return new ResponseEntity<>(room.getGame().getJudge(), HttpStatus.OK);
    }

    @PutMapping("/{roomCode}/judge")
    public ResponseEntity<?> nextJudge(@PathVariable String roomCode){
        Room room = rooms.get(roomCode);

        for(Player player : room.getPlayerList()){
            player.setSubmitCard(null);
        }

        room.getGame().setDisplayedCards(null);

        room.getGame().nextJudge();

        return new ResponseEntity<>(room.getGame().getJudge(), HttpStatus.OK);
    }

    @GetMapping("/{roomCode}/cards")
    public ResponseEntity<?> getSubmitedCards(@PathVariable String roomCode){
        Room room = rooms.get(roomCode);
        if(room.getGame().getDisplayedCards().getCardStack().size() == room.getPlayerList().size()) return new ResponseEntity<>(room.getGame().getDisplayedCards(), HttpStatus.OK);
        else if(room.getGame().getDisplayedCards().getCardStack().size() < room.getPlayerList().size()) return new ResponseEntity<>("Not all cards are in", HttpStatus.FORBIDDEN);
        return new ResponseEntity<>("Too many cards", HttpStatus.FORBIDDEN);
    }
}
