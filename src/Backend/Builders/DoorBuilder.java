package Backend.Builders;

import Backend.Items.Door;
import Backend.Items.Key;
import Backend.Items.NullObjects.EmptyKey;

public class DoorBuilder {

    private String name;
    private Key requestedKey = new EmptyKey();
    private boolean isLocked = true;


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

    public Door build(){
        if( (this.requestedKey.getDescription() == EmptyKey.description()) || this.name==null)
            throw new IllegalArgumentException();
        return new Door(this.name,this.isLocked,this.requestedKey);
    }

    private boolean notNull(Object obj) {
        if (obj != null) return true;
        throw new NullPointerException();
    }
}
