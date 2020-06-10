package Backend.GameTools;

public class GameMap {
    private Room startRoom;
    private Room endRoom;

    public GameMap(Room startRoom, Room endRoom){
        this.startRoom = startRoom;
        this.endRoom = endRoom;
    }

    public Room getStartRoom() {
        return startRoom;
    }
    public Room getEndRoom() {
        return endRoom;
    }


}
