package Backend.Items;

import Backend.Enums.Directions;
import Backend.Interfaces.Checkable;
import Backend.Interfaces.Lockable;
import Backend.Interfaces.Openable;
import Backend.Interfaces.Wallable;
import Backend.Items.NullObjects.EmptyRoom;
import Backend.MapTools.Room;


public class Door implements Wallable, Checkable, Openable , Lockable {

    private String name;
    private Key requestedKey;
    private boolean isLocked;
    private Room mainRoom, sideRoom;

    // 2 sides

    public Door(String name,boolean isLocked, Key requestedKey,Room mainRoom){
        this.name=name;
        this.isLocked=isLocked;
        this.requestedKey=requestedKey;
        this.mainRoom= mainRoom;
        this.sideRoom= new EmptyRoom();
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }
    public void setMainRoom(Room mainRoom) {
        notNull(mainRoom);
        this.mainRoom = mainRoom;
    }
    public void setSideRoom(Room otherRoom) {
        notNull(sideRoom);
        this.sideRoom = otherRoom;
    }


    public String getName() {
        return name;
    }
    public Room getMainRoom() {
        return mainRoom;
    }
    public Key getRequestedKey() {
        return requestedKey;
    }
    public boolean isLocked() {
        return isLocked;
    }
    public Room getOtherRoom() {
        return sideRoom;
    }

    //setSideTodirectionCode
//    public void addSideToDirection(Room room, Directions direction){
////        notNull(room);
////        int tempPos = Directions.getPosInNumbers(direction);
////        if(tempPos >= Directions.values().length || tempPos < 0)
////            throw new IndexOutOfBoundsException();
////
////        if(isNE==false && isSW==false){
////            if(tempPos<=1) { this.isNE=true; }
////            else { this.isSW=true; }
////            sides[((tempPos+1)%2)]=room;
////        }
////        else if(isNE){
////            if(tempPos<=1) { sides[((tempPos+1)%2)]=room; }
////            else { throw new IllegalArgumentException("Can't add room for that direction.(not opposite)"); }
////        }
////        else if(isSW){
////            if(tempPos>1) { sides[((tempPos+1)%2)]=room; }
////            else { throw new IllegalArgumentException("Can't add room for that direction.(not opposite)"); }
////        }
//
//    }

    @Override
    public String look() {
        return "Door";
    }
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
}
