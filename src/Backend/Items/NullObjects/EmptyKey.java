package Backend.Items.NullObjects;

import Backend.Items.Key;

public class EmptyKey extends Key {
    public EmptyKey() {
        super("Null", 0, "Null");
    }

    public static String description(){
        return "Empty";
    }

    @Override
    public String getDescription() {
        return description();
    }

}
