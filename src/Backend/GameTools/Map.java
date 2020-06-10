package Backend.GameTools;

public class Map {
    private Room startRoom;
    private Room endRoom;

    public  Map(Room startRoom,Room endRoom){
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
