package Backend.Items.NullObjects;

import Backend.Interfaces.Wallable;

public class Plain implements Wallable {
    @Override
    public String look() {
        return "Plain";
    }
}
