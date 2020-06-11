package Backend.GameTools;
import Backend.Interfaces.Containable;

import java.io.Serializable;
import java.util.ArrayList;

public class GameMap implements Serializable {

    private Room startRoom;
    private Room endRoom;
    private ArrayList<Containable> itemsList;

    private GameMap(Room startRoom, Room endRoom,ArrayList<Containable> itemsList){
        this.startRoom = startRoom;
        this.endRoom = endRoom;
        this.itemsList = itemsList;
    }

    public static GameMap create(Room startRoom, Room endRoom,ArrayList<Containable> itemsList){
        return new GameMap(startRoom,endRoom,itemsList);
    }

    public Room getStartRoom() {
        return startRoom;
    }
    public Room getEndRoom() {
        return endRoom;
    }
    public ArrayList<Containable> getItemsList() {
        return itemsList;
    }

}
