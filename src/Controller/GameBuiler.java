package Controller;

import Backend.GameTools.GameMap;
import Backend.GameTools.Player;

public class GameBuiler {

    private GameMap map=null;
    private Player player= new Player();
    private int timeForGame=600;

    public GameBuiler setTimeForGame(int timeForGame) {
        this.timeForGame = timeForGame;
        return this;
    }

    public GameBuiler setMap(GameMap map) {
        this.map = map;
        return this;
    }

    public GameBuiler setPlayer(Player player) {
        this.player = player;
        return this;
    }

    public Game build(){
        return new Game(this.map,this.player, this.timeForGame);
    }

}
