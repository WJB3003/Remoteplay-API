package co.willbrown.remoteplay.controller;


import co.willbrown.remoteplay.model.Game;
import co.willbrown.remoteplay.model.Player;
import co.willbrown.remoteplay.model.Room;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.HashMap;

public class GameController {

    private HashMap<String, Room> rooms = new HashMap<>();

    public void handleGame() throws URISyntaxException {
        Socket socket = IO.socket("http://localhost:35729");
        socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                System.out.println("HEREEEE SONNN");
            }

        }).on("createRoom", new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                Room room = new Room();
                rooms.put(room.getCode(), room);

                socket.emit("roomCreated", room.getCode());
            }

        }).on("addPlayer", new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                JSONObject obj = (JSONObject)args[0];
                try {
                    String name = obj.getString("name");
                    Room room = getRoom(obj);
                    if(!room.equals(null) && !name.equals(null)) {
                        room.addPlayer(new Player(name));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }).on("startGame", new Emitter.Listener() {

            @Override
            public void call(Object... args) {
                JSONObject obj = (JSONObject)args[0];
                try {
                    Room room = getRoom(obj);
                    room.startGame();
                    socket.emit("gameStarted");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {

            @Override
            public void call(Object... args) {

            }

        });
        socket.connect();
    }

    public Room getRoom(JSONObject object) throws JSONException {
        String roomCode = object.getString("roomCode");
        if(!roomCode.equals(null)) {
            return rooms.get(roomCode);
        }
        return null;
    }

}
