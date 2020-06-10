package Backend.Items;

import Backend.Builders.DoorBuilder;
import Backend.Interfaces.Checkable;
import Backend.Interfaces.Lockable;
import Backend.Interfaces.Openable;
import Backend.Interfaces.Wallable;
import Backend.GameTools.Room;


public class Door implements Wallable, Checkable.ForOpenablility, Openable , Lockable {

    private String name;
    private Key requestedKey;
    private boolean isLocked;
    private Room sideRoom;
    private Door linkedDoor;

    public Door(String name,boolean isLocked, Key requestedKey){
        this.name=name;
        this.isLocked=isLocked;
        this.requestedKey=requestedKey;
        this.linkedDoor = this;
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
    public String look() { return Door.className(); }
    @Override
    public boolean check() {
        if( ! isLocked ) return true;
        else return false;
    }
    @Override
    public void open() {
        if( ! isLocked )
            System.out.println("nothing happenes\n");
        else
            System.out.println(this.requestedKey.getName()+" key required to unlock\n");
    }
    @Override
    public String useKey(Key key) {
        notNull(key);
        if (this.requestedKey == key) {
            isLocked = !isLocked;
            this.linkedDoor.setLocked(isLocked);
            return(Door.className()+ ((isLocked == true) ? " looked" : " opened"));
        } else
            return(key.getName() + " key is not suitable for this door." + this.requestedKey.getName() + " needed.\n");
    }

    private boolean notNull(Object obj) {
        if (obj != null) return true;
        throw new NullPointerException();
    }

    public static String className() {
        return "Door";
    }
}
