
import Backend.GameTools.Player;
import Backend.MapFactory;
import Controller.Game;

public class main {
    public static void main(String[] args) {

        Game worldNavigator = new Game(new MapFactory().getDemoMap(),new Player(),600);
        worldNavigator.start();

    }
}
