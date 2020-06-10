package Backend;

import Backend.Builders.DoorBuilder;
import Backend.Builders.RoomBuilder;
import Backend.Enums.Directions;
import Backend.GameTools.GameMap;
import Backend.GameTools.Room;
import Backend.Items.Painting;

public class MapFactory {

    private RoomBuilder roomBuilder = new RoomBuilder();
    private DoorBuilder doorBuilder = new DoorBuilder();
    private GameMap demo1Map= null;

    public MapFactory(){
        demoMapBuild();
    }

    private void demoMapBuild(){

      int numberOfRooms = 5;
      Room [] rooms = new Room[numberOfRooms];

      for(int i=0;i<numberOfRooms;i++){
        rooms[i] = this.roomBuilder.setDark(false).setHasLights(true).build();
      }

      for(int i=0;i<)





    }


}
