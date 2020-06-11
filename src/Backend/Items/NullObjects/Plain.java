package Backend.Items.NullObjects;
import Backend.Interfaces.Wallable;

import java.io.Serializable;

public class Plain implements Wallable, Serializable {
    @Override
    public String look() {
        return "Plain";
    }
}
