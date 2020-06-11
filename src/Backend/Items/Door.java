package Backend.Items;

import Backend.Interfaces.Checkable;
import Backend.Interfaces.Lockable;
import Backend.Interfaces.Openable;
import Backend.Interfaces.Wallable;
import Backend.GameTools.Room;

import java.io.Serializable;
import java.util.Objects;


public class Door implements Wallable, Checkable.ForOpenablility, Openable , Lockable, Serializable {

    private String name;
    private Key requestedKey;
    private boolean isOpen;
    private Room sideRoom;
    private Door linkedDoor;



    public Door(String name, boolean isOpen, Key requestedKey){
        this.name=name;
        this.isOpen = isOpen;
        this.requestedKey=requestedKey;
        this.linkedDoor = this;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
    public void setSideRoom(Room room){
        Objects.requireNonNull(room);
        this.sideRoom=room;
    }
    public void setLinkedDoor(Door door){
        Objects.requireNonNull(door);
        this.linkedDoor = door;
    }
    public void setRequestedKey(Key requestedKey) {
        this.requestedKey = requestedKey;
    }

    public String getName() { return name; }
    public Key getRequestedKey() { return requestedKey; }
    public boolean isOpen() { return isOpen; }
    public Room getSideRoom() { return sideRoom; }
    public Door getLinkedDoor() { return linkedDoor; }

    @Override
    public String look() { return Door.className(); }
    @Override
    public boolean check() {
       return isOpen;
    }
    @Override
    public void open() {
        if(isOpen)
            System.out.println("nothing happenes\n");
        else
            System.out.println(this.requestedKey.getName()+" key required to unlock\n");
    }
    @Override
    public String useKey(Key key) {
        Objects.requireNonNull(key);
        if (this.requestedKey == key) {
            isOpen = !isOpen;
            this.linkedDoor.setOpen(isOpen);
            return(Door.className()+ ((isOpen == false) ? " looked" : " opened"));
        } else
            return(key.getName() + " key is not suitable for this door." + this.requestedKey.getName() + " needed.\n");
    }

    public static String className() {
        return "Door";
    }

    @Override
    public String toString() {
        return this.name + " Door";
    }

}
