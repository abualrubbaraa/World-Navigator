package Backend.Factories;

import Backend.Builders.*;
import Backend.Enums.Directions;
import Backend.GameTools.GameMap;
import Backend.GameTools.Room;
import Backend.Interfaces.Containable;
import Backend.Items.*;

import java.io.Serializable;
import java.util.ArrayList;

public class GameMapFactory implements Serializable {

  private RoomBuilder roomBuilder = new RoomBuilder();
  private DoorBuilder doorBuilder = new DoorBuilder();
  private ChestBuilder chestBuilder = new ChestBuilder();
  private KeyBuilder keyBuilder = new KeyBuilder();
  private GameMap demoMap = null;
  private ArrayList<Containable> itemsInMap = new ArrayList<>();

  public GameMapFactory() {}

  private void demoMapBuild() {
    itemsInMap = new ArrayList<>();
    int flashLightPrice = 50;

    Room petraRoom = roomBuilder.setDark(false).setHasLights(true).build();
    Seller sellerInPetraRoom = new Seller();

    FlashLight flashInPertaRoom = FlashLight.valueOf(flashLightPrice);
    sellerInPetraRoom.addItem(flashInPertaRoom);
    this.itemsInMap.add(flashInPertaRoom);

    Key petraKey = this.keyBuilder.setName("Petra").setPrice(50).build();
    Door petraDoor = this.doorBuilder.setName("Petra").setOpen(false).setRequestedKey(petraKey).build();
    petraKey.setRelatedLock(petraDoor.getName());
    this.itemsInMap.add(petraKey);
    Painting paintingforPetraRoom  = Painting.valueOf(petraKey);
    petraRoom.getWallInDirection(Directions.EAST).setWallContent(paintingforPetraRoom);
    petraRoom.getWallInDirection(Directions.WEST).setWallContent(sellerInPetraRoom);

    Room deadSeaRoom = roomBuilder.setDark(true).setHasLights(true).build();
    Key deadSeaKey = this.keyBuilder.setName("Dead Sea").setPrice(300).build();
    Door deadSeaDoor = this.doorBuilder.setName("Dead Sea").setOpen(false).setRequestedKey(deadSeaKey).build();
    this.itemsInMap.add(deadSeaKey);
    deadSeaKey.setRelatedLock(deadSeaDoor.getName());

    Key ammanKey = this.keyBuilder.setName("Amman").setPrice(75).build();
    Door ammanDoor = this.doorBuilder.setName("Amman").setOpen(false).setRequestedKey(ammanKey).build();
    this.itemsInMap.add(ammanKey);
    ammanKey.setRelatedLock(ammanDoor.getName());

    Key aqabaKey = this.keyBuilder.setName("Aqaba").setPrice(50).build();
    Door aqabaDoor = this.doorBuilder.setName("Aqaba").setOpen(true).setRequestedKey(aqabaKey).build();
    this.itemsInMap.add(aqabaKey);
    aqabaKey.setRelatedLock(aqabaDoor.getName());

    Room endRoom = roomBuilder.build();

    Room aqabaRoom = roomBuilder.setHasLights(false).setDark(true).build();
    Room ammanRoom = roomBuilder.setHasLights(true).setDark(true).build();

    Seller aqabaSeller = new Seller();
    aqabaSeller.addItem(deadSeaKey);

    aqabaSeller.addItem(FlashLight.valueOf(flashLightPrice));
    Mirror aqabaMirror = Mirror.valueOf(ammanKey);
    aqabaRoom.getWallInDirection(Directions.NORTH).setWallContent(aqabaSeller);
    aqabaRoom.getWallInDirection(Directions.EAST).setWallContent(aqabaMirror);

    Key ammanChestKey = keyBuilder.setName("Amman Chest Key").setPrice(60).build();
    Chest ammanChest = chestBuilder.setChestName("Amman Chest").setOpen(false).setRequiredKey(ammanChestKey).build();
    ammanChestKey.setRelatedLock(ammanChest.getChestName());
    this.itemsInMap.add(ammanChestKey);
    Painting ammanPainting = Painting.valueOf(ammanChestKey);
    ammanChest.addItemToChest(new Gold(500));
    ammanRoom.getWallInDirection(Directions.NORTH).setWallContent(ammanPainting);
    ammanRoom.getWallInDirection(Directions.SOUTH).setWallContent(ammanChest);

    petraRoom.addDoorToRoom(petraDoor,deadSeaRoom,Directions.NORTH);
    deadSeaRoom.addDoorToRoom(deadSeaDoor,endRoom,Directions.WEST);
    deadSeaRoom.addDoorToRoom(aqabaDoor,aqabaRoom,Directions.NORTH);
    deadSeaRoom.addDoorToRoom(ammanDoor,ammanRoom,Directions.EAST);

    this.demoMap= GameMap.create(petraRoom,endRoom,this.itemsInMap);
  }
  public GameMap getDemoMap() {
    demoMapBuild();
    return this.demoMap;
  }

  @Override
  public String toString() {
    return "GameMapFactory";
  }
}
