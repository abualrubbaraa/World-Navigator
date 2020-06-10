package Backend.Items;

import Backend.Interfaces.Checkable;
import Backend.Interfaces.Lockable;
import Backend.Interfaces.Openable;
import Backend.Interfaces.Wallable;
import Backend.GameTools.Room;


public class Door implements Wallable, Checkable, Openable , Lockable {

    private String name;
    private Key requestedKey;
    private boolean isLocked;
    private Room sideRoom;
    private Door linkedDoor;

    public Door(String name,boolean isLocked, Key requestedKey){
        this.name=name;
        this.isLocked=isLocked;
        this.requestedKey=requestedKey;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }
    public void setSideRoom(Room room){
        notNull(room);
        this.sideRoom=room;
    }
    public void setLinkedDoor(Door door){
        notNull(door);
        this.linkedDoor = door;
    }

    public String getName() { return name; }
    public Key getRequestedKey() { return requestedKey; }
    public boolean isLocked() { return isLocked; }
    public Room getSideRoom() { return sideRoom; }
    public Door getLinkedDoor() { return linkedDoor; }

    @Override
    public String look() { return "Door"; }
    @Override
    public void check() {
        if( ! isLocked )
            System.out.println(this.name+" Door is open");
        else
            System.out.println(this.name+" Door is locked, "+this.requestedKey.getName()+" key is needed to unlock");
    }
    @Override
    public void open() {
        if( ! isLocked )
            System.out.println("nothing happenes\n");
        else
            System.out.println(this.requestedKey.getName()+" key required to unlock\n");
    }
    @Override
    public void useKey(Key key) {
        notNull(key);
        if (this.requestedKey == key) {
            isLocked = !isLocked;
            System.out.println("Door " + ((isLocked == true) ? "looked" : "opened"));
        } else
            System.out.println(key.getName() + " key is not suitable for this door." + this.requestedKey.getName() + " needed.\n");
    }

    private boolean notNull(Object obj) {
        if (obj != null) return true;
        throw new NullPointerException();
    }

    public static String className() {
        return "Door";
    }
}
