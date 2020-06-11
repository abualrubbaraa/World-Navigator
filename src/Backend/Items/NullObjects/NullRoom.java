package Backend.Items.NullObjects;
import Backend.GameTools.Room;

import java.io.Serializable;

public class NullRoom extends Room implements Serializable {
    public NullRoom() {
        super(true,false);
    }
    public static String className(){
        return "Null";
    }
}
