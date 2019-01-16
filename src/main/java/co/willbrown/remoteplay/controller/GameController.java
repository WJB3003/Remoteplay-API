package co.willbrown.remoteplay.controller;

import co.willbrown.remoteplay.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class GameController {

    private HashMap<String, Room> rooms = new HashMap<>();

    //ROOM CONTROLLER
    @GetMapping("/create-room")
    public ResponseEntity<?> createRoom(){
        Room room = new Room();
        rooms.put(room.getCode(), room);

        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    //ROOM CONTROLLER
    @GetMapping("/rooms")
    public ResponseEntity<?> getAllRooms(){
        return new ResponseEntity<>(rooms.keySet(), HttpStatus.OK);
    }

    //ROOM CONTROLLER
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

    //ROOM CONTROLLER
    @GetMapping("/{roomCode}/players")
    public ResponseEntity<?> getAllPlayers(@PathVariable String roomCode){
        Room room = rooms.get(roomCode);
        List playerList = room.getPlayerList();
        List players = new ArrayList<String>();

        for(int i = 0; i < playerList.size(); i++){
            Player player = (Player) playerList.get(i);
            players.add(player.getName());
        }

        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    //PLAYER CONTROLLER
    @PostMapping("/deal-one-card/{roomCode}/{player}")
    public ResponseEntity<?> dealOneCard(@PathVariable String roomCode, @PathVariable String player){
        Room room = rooms.get(roomCode);
        Player user = room.getPlayer(player);

        user.getHand().addCard(room.getGame().drawAnswer());

        return new ResponseEntity<>("Card dealt", HttpStatus.OK);
    }

    //GAME CONTROLLER
    @GetMapping("/{roomCode}/start-game")
    public ResponseEntity<?> startGame(@PathVariable String roomCode){
        Room room = rooms.get(roomCode);
        room.startGame();

        room.getGame().dealFirstHand();

        if(!room.getGame().equals(null)) return new ResponseEntity<>("Game started", HttpStatus.OK);

        return new ResponseEntity<>("Game had error", HttpStatus.BAD_REQUEST);
    }

    //GAME CONTROLLER
    @GetMapping("/{roomCode}/has-game-started")
    public ResponseEntity<?> hasGameStarted(@PathVariable String roomCode){
        Room room = rooms.get(roomCode);

        if(room.getGameStarted()) return new ResponseEntity<>(true, HttpStatus.OK);

        return new ResponseEntity<>(false, HttpStatus.OK);
    }

    //DECK CONTROLLER
    @GetMapping("/{roomCode}/get-question")
    public ResponseEntity<?> getQuestion(@PathVariable String roomCode){
        Room room = rooms.get(roomCode);
        Card question = room.getGame().drawQuestion();

        if(room.getGame().equals(null)) return new ResponseEntity<>("Game hasn't started yet", HttpStatus.FORBIDDEN);

        room.getGame().getDisplayedCards().put(question, null);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    //GAME CONTROLLER
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

            room.getGame().getDisplayedCards().put(card, player);
            player.setSubmitCard(card);
            return new ResponseEntity<>("Card Submitted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Judge Cannot Submit a Card", HttpStatus.FORBIDDEN);
    }

    //PLAYER CONTROLLER
    @GetMapping("/{roomCode}/{name}")
    public ResponseEntity<?> getPlayerCards(@PathVariable String roomCode, @PathVariable String name){
        Room room = rooms.get(roomCode);
        Player player = room.findByName(name);
        Hand hand = player.getHand();

        return new ResponseEntity<>(player.getHand().getMyhand(), HttpStatus.OK);
    }

    //GAME CONTROLLER
    @GetMapping("/{roomCode}/judge")
    public ResponseEntity<?> getJudge(@PathVariable String roomCode){
        Room room = rooms.get(roomCode);

        return new ResponseEntity<>(room.getGame().getJudge(), HttpStatus.OK);
    }

    //GAME CONTROLLER
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

    //GAME CONTROLLER
    @GetMapping("/{roomCode}/show-cards")
    public ResponseEntity<?> getSubmitedCards(@PathVariable String roomCode){
        Room room = rooms.get(roomCode);
        if(room.getGame().getDisplayedCards().size() == room.getPlayerList().size()) return new ResponseEntity<>(room.getGame().getDisplayedCards().keySet(), HttpStatus.OK);
        else if(room.getGame().getDisplayedCards().size() < room.getPlayerList().size()) return new ResponseEntity<>("Not all cards are in", HttpStatus.FORBIDDEN);
        return new ResponseEntity<>("Too many cards", HttpStatus.FORBIDDEN);
    }

    //GAME CONTROLLER
    @GetMapping("/{roomCode}/cards")
    public ResponseEntity<?> getCards(@PathVariable String roomCode){
        Room room = rooms.get(roomCode);
        if(room.getGame().getDisplayedCards().size() == room.getPlayerList().size()) return new ResponseEntity<>(true, HttpStatus.OK);
        else return new ResponseEntity<>(false, HttpStatus.OK);
    }

    //GAME CONTROLLER
    @PostMapping("/{roomCode}/judge-pick")
    public ResponseEntity<?> judgesPick(@PathVariable String roomCode, @RequestBody Card card){
        Room room = rooms.get(roomCode);

//        int org = room.getGame().getScore().get(player);
//        room.getGame().getScore().put(player, org + 1);

        return new ResponseEntity<>(card, HttpStatus.OK);
    }
}
