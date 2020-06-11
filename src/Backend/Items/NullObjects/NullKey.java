package Backend.Items.NullObjects;

import Backend.Items.Key;

import java.io.Serializable;

public class NullKey extends Key implements Serializable {
    public NullKey() {
        super("Null",0,"Null");
    }

    public static String description(){
        return "Null";
    }
    @Override
    public String getDescription() {
        return "Null";
    }
}
