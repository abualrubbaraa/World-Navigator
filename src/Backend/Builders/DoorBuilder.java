package Backend.Builders;

import Backend.Items.Door;
import Backend.Items.Key;
import Backend.Items.NullObjects.EmptyKey;
import Backend.MapTools.Room;

public class DoorBuilder {

    private String name= "Door";
    private Key requestedKey = new EmptyKey();
    private boolean isLocked = true;
    private Room mainRoom, sideRoom;


    public DoorBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public DoorBuilder setRequestedKey(Key requestedKey) {
        notNull(requestedKey);
        this.requestedKey = requestedKey;
        return this;
    }
    public DoorBuilder setLocked(boolean locked) {
        isLocked = locked;
        return this;
    }
    public DoorBuilder setSides(Room[] sides) {
        this.sides = sides;
        return this;
    }

    public Door build(){
        if( (this.requestedKey.getDescription() == EmptyKey.description()) || this.name=="Door")
            throw new IllegalArgumentException();
        return new Door(this.name,this.isLocked,this.requestedKey,this.sides);
    }

    private boolean notNull(Object obj) {
        if (obj != null) return true;
        throw new NullPointerException();
    }
}
