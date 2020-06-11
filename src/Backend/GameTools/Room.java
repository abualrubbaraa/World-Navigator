package Backend.GameTools;

import Backend.Builders.DoorBuilder;
import Backend.Enums.Directions;
import Backend.Interfaces.Lightable;
import Backend.Items.Door;
import Backend.Items.FlashLight;

import java.io.Serializable;

public class Room implements Lightable, Serializable {

    private final int wallsNumber=4;

    private boolean isDark;
    private boolean hasLights;
    private Wall [] roomWalls;

    public Room(boolean isDark,boolean hasLights){
        this.isDark=isDark;
        this.hasLights=hasLights;

        this.roomWalls = new Wall[wallsNumber];
        for(int i=0;i<this.wallsNumber;i++)
            this.roomWalls[i]=new Wall();
    }


    public void setDark(boolean dark) { isDark = dark; }
    public void addDoorToRoom(Door door, Room room, Directions direction){
        notNull(door);
        notNull(room);
        notNull(direction);
        int doorPos = direction.asInt;
        Door otherSideDoor = new DoorBuilder().setOpen(door.isOpen()).setName(door.getName()).setRequestedKey(door.getRequestedKey()).build();

        otherSideDoor.setSideRoom(this);
        otherSideDoor.setLinkedDoor(door);
        room.addDoorFrom(otherSideDoor,this,Directions.getOppositeDirection(direction));

        door.setSideRoom(room);
        door.setLinkedDoor(otherSideDoor);
        this.roomWalls[doorPos].setWallContent(door);
    }

    public void addDoorFrom(Door door,Room room , Directions direction){
        notNull(door);
        notNull(room);
        notNull(direction);
        this.roomWalls[direction.asInt].setWallContent(door);
    }

    public boolean isDark() { return isDark; }
    public boolean isDark(FlashLight fl) {
        if ( fl.isOn() ) { return false; }
        return isDark;
    }

    public Wall getWallInDirection(Directions direction){
        return this.roomWalls[direction.asInt];
    }

    private boolean notNull(Object obj) {
        if (obj != null) return true;
        throw new NullPointerException();
    }

    public String look(Directions direction){
        if(isDark)
            return ("Dark");
        else {
            int dirNumber = direction.asInt;
            return this.roomWalls[dirNumber].getWallContent().look();
        }
    }
    public String look(Directions direction,FlashLight fl){
        if(isDark && !fl.isOn())
            return ("Dark");
        else {
            int dirNumber = direction.asInt;
            return this.roomWalls[dirNumber].getWallContent().look();
        }
    }

    public boolean lookIfDoor(Directions pos){
        int dirNumber = pos.asInt;
        return (this.roomWalls[dirNumber].getWallContent().look() == Door.className());
    }

    public Door getIfDoor(Directions pos){
        int dirNumber = pos.asInt;
        if(lookIfDoor(pos))
            return (Door)this.roomWalls[dirNumber].getWallContent();
        throw new IllegalArgumentException();
    }

    @Override
    public void switchLights() {
        if(this.hasLights) {
            this.isDark = !isDark;
            System.out.println("lights switched to "+( (isDark==false)?"on":"off") );
        }
        else { System.out.println(Room.className()+" doesn't have lights."); }
    }

    public static String className(){
        return "Room";
    }

}
