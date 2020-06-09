package Backend.Items.NullObjects;

import Backend.Items.FlashLight;
import Backend.MapTools.Room;
import Backend.MapTools.Wall;

public class EmptyRoom extends Room{

    public EmptyRoom() {
        super();
    }

    @Override
    public void addWalls(Wall[] walls) {
        super.addWalls(walls);
    }

    @Override
    public void addWallToDirection(Wall wall, int pos) {
        super.addWallToDirection(wall, pos);
    }

    @Override
    public void setDark(boolean dark) {
        super.setDark(dark);
    }

    @Override
    public boolean isDark() {
        return super.isDark();
    }

    @Override
    public void useFlashlight(FlashLight flashLight) {
        super.useFlashlight(flashLight);
    }

    @Override
    public void switchLights() {
        super.switchLights();
    }
}
