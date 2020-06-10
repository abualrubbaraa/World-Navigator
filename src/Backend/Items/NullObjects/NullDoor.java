package Backend.Items.NullObjects;

import Backend.Items.Door;
import Backend.Items.Key;

public class NullDoor extends Door {

    public NullDoor() {
        super("Null", false,new NullKey() );
    }

}
