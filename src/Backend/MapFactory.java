package Backend;

import Backend.Builders.DoorBuilder;
import Backend.Builders.RoomBuilder;
import Backend.Enums.Directions;
import Backend.GameTools.GameMap;
import Backend.GameTools.Room;
import Backend.Interfaces.Containable;
import Backend.Items.*;
import Backend.Items.NullObjects.NullDoor;

import java.util.ArrayList;

public class MapFactory {

    private RoomBuilder roomBuilder = new RoomBuilder();
    private DoorBuilder doorBuilder = new DoorBuilder();
    private GameMap demo1Map= null;
    private  ArrayList<Containable> itemsInMap = new ArrayList<>();

    public MapFactory(){
        demoMapBuild();
    }

    private void demoMapBuild(){
      this.itemsInMap.add(new FlashLight(50));
      int numberOfRooms = 5;
      Room [] rooms = new Room[numberOfRooms];


      rooms[0] = roomBuilder.setDark(false).setHasLights(true).build();
      rooms[1] = roomBuilder.setDark(true).setHasLights(true).build();
      rooms[2] =roomBuilder.setDark(true).setHasLights(false).build();
      rooms[3] =roomBuilder.setDark(true).setHasLights(true).build();
      rooms[4] =roomBuilder.setDark(true).setHasLights(true).build();

      Painting paintingForRoom1 = Painting.getInstance();
      Key key1 = new Key("Petra",50,"");

      this.itemsInMap.add(key1);
      Door door1 = doorBuilder.setName("Petra").setLocked(true).setRequestedKey(key1).build();
      key1.setRelatedDoor(door1.getName());
      Mirror mirrorForRoom1 = Mirror.valueOf(key1);
      Seller sellerForRoom1 = new Seller(this.itemsInMap);
      sellerForRoom1.addItem(new FlashLight(50));
      sellerForRoom1.addItem(key1);


      rooms[0].getWallInDirection(Directions.NORTH).setWallContent(paintingForRoom1);
      rooms[0].getWallInDirection(Directions.EAST).setWallContent(sellerForRoom1);
      rooms[0].addDoorToRoom(door1,rooms[1],Directions.SOUTH);
      rooms[0].getWallInDirection(Directions.WEST).setWallContent(mirrorForRoom1);

      Key key2 = new Key("Dead Sea",60,"");
      Door door2 = doorBuilder.setName("Dead Sea").setLocked(true).setRequestedKey(key2).build();
      key2.setRelatedDoor(door2.getName());

      Painting paint2 = Painting.valueOf(key2);
      rooms[1].getWallInDirection(Directions.WEST).setWallContent(paint2);
      rooms[1].addDoorToRoom(door2,rooms[2],Directions.EAST);

      Key key3 = new Key("Aqaba",40,"");
      Door door3 = doorBuilder.setName("Aqaba").setLocked(true).setRequestedKey(key3).build();
      key3.setRelatedDoor(door3.getName());

      this.demo1Map = new GameMap(rooms[0],rooms[2]);

    }
    public GameMap getDemoMap(){
        return this.demo1Map;
    }

}
