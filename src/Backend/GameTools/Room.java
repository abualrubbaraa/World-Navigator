package Backend.GameTools;

import Backend.Builders.DoorBuilder;
import Backend.Enums.Directions;
import Backend.Interfaces.Lightable;
import Backend.Interfaces.Wallable;
import Backend.Items.Door;
import Backend.Items.FlashLight;
import Backend.Items.NullObjects.DarkWall;
import Backend.Items.NullObjects.NullFlashlight;

public class Room implements Lightable {

    private final int wallsNumber=4;
    private String name;
    private boolean isDark;
    private boolean hasLights;
    private Wall [] walls;

    public Room(boolean isDark,boolean hasLights){
        this.name="Room";
        this.isDark=isDark;
        this.hasLights=hasLights;
        this.walls= new Wall[wallsNumber];
        for(int i=0;i<this.wallsNumber;i++)
            this.walls[i]=new Wall();
    }


    public void setDark(boolean dark) { isDark = dark; }
    public void addDoorToRoom(Door door, Room room, Directions direction){
        notNull(door);
        notNull(room);
        notNull(direction);
        int doorPos = direction.asInt;
        Door otherSideDoor = new DoorBuilder().setLocked(door.isLocked()).setName(door.getName()).setRequestedKey(door.getRequestedKey()).build();

        otherSideDoor.setSideRoom(this);
        otherSideDoor.setLinkedDoor(door);
        room.addDoorFrom(otherSideDoor,this,Directions.getOppositeDirection(direction));

        door.setSideRoom(room);
        door.setLinkedDoor(otherSideDoor);
        this.walls[doorPos].setWallContent(door);
    }

    public void addDoorFrom(Door door,Room room , Directions direction){
        notNull(door);
        notNull(room);
        notNull(direction);
        this.walls[direction.asInt].setWallContent(door);
    }

    public boolean isDark() { return isDark; }
    public boolean isDark(FlashLight fl) {
        if ( fl.isLit() ) { return false; }
        return isDark;
    }

    public Wall getWallInDirection(Directions direction){
        return this.walls[direction.asInt];
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
            return this.walls[dirNumber].getWallContent().look();
        }
    }
    public String look(Directions direction,FlashLight fl){
        if(isDark && !fl.isLit())
            return ("Dark");
        else {
            int dirNumber = direction.asInt;
            return this.walls[dirNumber].getWallContent().look();
        }
    }

    public boolean loofIfDoor(Directions pos){
        int dirNumber = pos.asInt;
        return (this.walls[dirNumber].getWallContent().look() == Door.className());
    }

    public Door getIfDoor(Directions pos){
        int dirNumber = pos.asInt;
        if(loofIfDoor(pos))
            return (Door)this.walls[dirNumber].getWallContent();
        throw new IllegalArgumentException();
    }



    @Override
    public void switchLights() {
        if(this.hasLights) {
            this.isDark = !isDark;
            System.out.println("lights switched to "+( (isDark==false)?"on":"off") );
        }
        else { System.out.println(this.name+" doesn't have lights."); }
    }

}
