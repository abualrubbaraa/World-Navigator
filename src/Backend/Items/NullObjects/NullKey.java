package Backend.Items.NullObjects;

import Backend.Items.Key;

public class NullKey extends Key {

    public NullKey() {
        super("Null", 0, new NullDoor().getName());
    }

}
