package Backend;

import Backend.Builders.ChestBuilder;
import Backend.Builders.DoorBuilder;
import Backend.Builders.RoomBuilder;
import Backend.Enums.Directions;
import Backend.GameTools.Game;
import Backend.GameTools.Player;
import Backend.Items.*;
import Backend.GameTools.Map;
import Backend.GameTools.Room ;



public class testing {
    public static void main(String[] args) {
        Key petraKey = new Key("Petra",100,"shitoo");
        Mirror mirror = Mirror.valueOf(petraKey);
        Painting painting = Painting.valueOf(petraKey);

        Chest c = new ChestBuilder().setOpen(true).setRequiredKey(petraKey).build();
        Gold gold20 = new Gold(20);
        FlashLight fl = new FlashLight(90);
        c.addItemToChest(petraKey);
        c.addItemToChest(gold20);
        c.addItemToChest(fl);

        System.out.println(painting.look());
        painting.check();

        System.out.println(mirror.look());
        mirror.check();

        System.out.println(c.look());
        c.check();
        c.check();
        c.useKey(petraKey);
        c.useKey(petraKey);
        c.useKey(petraKey);
        c.useKey(petraKey);
        c.useKey(new Key("jj",90,"l"));

        Seller baraa = new Seller();
        baraa.addItem(petraKey);
        baraa.addItem(fl);
//        baraa.trade();

     Door door = new DoorBuilder().setName("Petra Door").setLocked(false).setRequestedKey(petraKey).build();
     door.check();
     door.useKey(petraKey);
     door.check();
     door.useKey(petraKey);

     Room room = new RoomBuilder().setDark(true).setHasLights(true).build();
     room.getWallInDirection(Directions.NORTH).setWallContent(Painting.valueOf(petraKey));

     System.out.println("***********");
//     ((Painting) (room.getWallInDirection(Directions.NORTH).getWallContent())).check();
//     ((Painting) (room.getWallInDirection(Directions.NORTH).getWallContent())).check();

     Room room2 = new RoomBuilder().setDark(true).build();

     room.addDoorToRoom(door,room2,Directions.WEST);

//     System.out.println(((Door)(room.getWallInDirection(Directions.WEST).getWallContent())).getSideRoom() );

//     System.out.println(((Door)(room2.getWallInDirection(Directions.EAST).getWallContent())).getSideRoom());

     Map map = new Map(room,room2);


     Game game = new Game(map,new Player());
     game.start();

    }
}
