package co.willbrown.remoteplay.controller;

import co.willbrown.remoteplay.model.Player;
import co.willbrown.remoteplay.model.Room;
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

    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    public ResponseEntity<?> getAllRooms(){
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @RequestMapping(value = "/create-room", method = RequestMethod.GET)
    public ResponseEntity<?> createRoom(){
        Room room = new Room();
        rooms.put(room.getCode(), room);

        return new ResponseEntity<>(room, HttpStatus.OK);
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

    @RequestMapping(value = "/{roomCode}/start-game", method = RequestMethod.GET)
    public ResponseEntity<?> startGame(@PathVariable String roomCode){
        Room room = rooms.get(roomCode);
        room.startGame();

        if(!room.equals(null)) return new ResponseEntity<>("Game started", HttpStatus.OK);

        return new ResponseEntity<>("Game had error", HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/{roomCode}/has-game-started", method = RequestMethod.GET)
    public ResponseEntity<?> hasGameStarted(@PathVariable String roomCode){
        Room room = rooms.get(roomCode);

        if(room.getGameStarted()) return new ResponseEntity<>("Game Started", HttpStatus.OK);

        return new ResponseEntity<>("Game Not Started", HttpStatus.OK);
    }

//
//    @OnMessage
//    public void onMessage(Session session, String msg) {
//        try {
//            System.out.println("received msg "+msg+" from ");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void handleGame() throws URISyntaxException {
//        Socket socket = IO.socket("http://localhost:35729");
//        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
//
//            @Override
//            public void call(Object... args) {
//                System.out.println("HEREEEE SONNN");
//            }
//
//        }).on("createRoom", new Emitter.Listener() {
//
//            @Override
//            public void call(Object... args) {
//                Room room = new Room();
//                rooms.put(room.getCode(), room);
//                System.out.println("ASDFASDFASDFASDF");
//                socket.emit("roomCreated", room.getCode());
//            }
//
//        }).on("addPlayer", new Emitter.Listener() {
//
//            @Override
//            public void call(Object... args) {
//                JSONObject obj = (JSONObject)args[0];
//                try {
//                    String name = obj.getString("name");
//                    Room room = getRoom(obj);
//                    if(!room.equals(null) && !name.equals(null)) {
//                        room.addPlayer(new Player(name));
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }).on("startGame", new Emitter.Listener() {
//
//            @Override
//            public void call(Object... args) {
//                JSONObject obj = (JSONObject)args[0];
//                try {
//                    Room room = getRoom(obj);
//                    room.startGame();
//                    socket.emit("gameStarted");
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
//
//            @Override
//            public void call(Object... args) {
//
//            }
//
//        });
//        socket.connect();
//    }
//
//    public Room getRoom(JSONObject object) throws JSONException {
//        String roomCode = object.getString("roomCode");
//        if(!roomCode.equals(null)) {
//            return rooms.get(roomCode);
//        }
//        return null;
//    }

}
