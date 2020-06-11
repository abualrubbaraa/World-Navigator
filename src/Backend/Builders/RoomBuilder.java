package Backend.Builders;
import Backend.GameTools.Room;

public class RoomBuilder {
    private boolean isDark=false;
    private boolean hasLights=true;

    public RoomBuilder setDark(boolean dark) {
        isDark = dark;
        return this;
    }
    public RoomBuilder setHasLights(boolean hasLights) {
        this.hasLights = hasLights;
        return this;
    }
    public Room build(){ return new Room(isDark,hasLights); }

}
