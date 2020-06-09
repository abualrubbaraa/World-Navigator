package Backend;

import Backend.Builders.ChestBuilder;
import Backend.Builders.DoorBuilder;
import Backend.Builders.RoomBuilder;
import Backend.Items.*;
import Backend.MapTools.Room ;

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

     Room room = new RoomBuilder().setDark(true).setHasLights(false).build();




    }
}
