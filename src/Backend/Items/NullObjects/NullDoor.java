package Backend.Items.NullObjects;

import Backend.Items.Door;
import Backend.Items.Key;

import java.io.Serializable;

public class NullDoor extends Door implements Serializable {
    public NullDoor() {
        super("Null",false ,new NullKey() );
    }
    public static String className(){
        return "Null";
    }
}
