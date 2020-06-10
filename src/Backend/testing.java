package Backend;

import Backend.Builders.ChestBuilder;
import Backend.Builders.DoorBuilder;
import Backend.Builders.RoomBuilder;
import Backend.Enums.Directions;
import Controller.Game;
import Backend.GameTools.Player;
import Backend.Items.*;
import Backend.GameTools.GameMap;
import Backend.GameTools.Room ;
import Controller.GameBuiler;

import java.util.Scanner;


public class testing {
    public static void main(String[] args) {
        Key petraKey = new Key("Petra",100,"shitoo");
        Mirror mirror = Mirror.valueOf(petraKey);
        Painting painting = Painting.valueOf(petraKey);

        Chest c = new ChestBuilder().setOpen(true).setRequiredKey(petraKey).build();
        Gold gold20 = new Gold(200);
        FlashLight fl = new FlashLight(90);
        c.addItemToChest(petraKey);
        c.addItemToChest(gold20);
        c.addItemToChest(fl);

        System.out.println(painting.look());
        painting.check();

        System.out.println(mirror.look());
        mirror.check();

        System.out.println(c.look());
//        c.check();
//        c.check();
//        c.useKey(petraKey);
//        c.useKey(petraKey);
//        c.useKey(petraKey);
//        c.useKey(petraKey);
//        c.useKey(new Key("jj",90,"l"));

////        Seller baraa = new Seller();
//        baraa.addItem(petraKey);
//        baraa.addItem(fl);


     Door door = new DoorBuilder().setName("Petra Door").setLocked(true).setRequestedKey(petraKey).build();
     door.check();
     door.useKey(petraKey);
     door.check();
     door.useKey(petraKey);

     Room room = new RoomBuilder().setDark(true).setHasLights(true).build();

     room.getWallInDirection(Directions.NORTH).setWallContent(Painting.valueOf(petraKey));
     room.getWallInDirection(Directions.SOUTH).setWallContent(c);
     System.out.println("***********");


     Room room2 = new RoomBuilder().setDark(true).build();

     room.addDoorToRoom(door,room2,Directions.WEST);
//     room.getWallInDirection(Directions.EAST).setWallContent(baraa);

     GameMap map = new GameMap(room,room2);


     Game game = new GameBuiler().setMap(map).setPlayer(new Player()).build();
     game.start();


    }
}
