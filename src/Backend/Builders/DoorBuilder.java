package Backend.Builders;

import Backend.GameTools.Room;
import Backend.Items.Door;
import Backend.Items.Key;
import Backend.Items.NullObjects.NullKey;

public class DoorBuilder {

    private String name;
    private Key requestedKey = new NullKey();
    private boolean isOpen = true;
    private Room sideRoom;
    private Door linkedDoor;


    public DoorBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public DoorBuilder setRequestedKey(Key requestedKey) {
        notNull(requestedKey);
        this.requestedKey = requestedKey;
        return this;
    }
    public DoorBuilder setOpen(boolean open) {
        isOpen = open;
        return this;
    }

    public Door build(){
        if( (this.requestedKey.getDescription() == NullKey.description()) || this.name==null)
            throw new IllegalArgumentException();
        return new Door(this.name,this.isOpen,this.requestedKey);
    }

    private boolean notNull(Object obj) {
        if (obj != null) return true;
        throw new NullPointerException();
    }
}
