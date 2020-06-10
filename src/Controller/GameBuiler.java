package Controller;

import Backend.GameTools.GameMap;
import Backend.GameTools.Player;
import Backend.GameTools.Room;
import Backend.Items.NullObjects.EmptyRoom;

public class GameBuiler {
    private GameMap map=null;
    private Player player= new Player();

    public GameBuiler setMap(GameMap map) {
        this.map = map;
        return this;
    }

    public GameBuiler setPlayer(Player player) {
        this.player = player;
        return this;
    }

    public Game build(){
        return new Game(this.map,this.player);
    }
}
