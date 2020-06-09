package Backend.MapTools;

import Backend.Interfaces.Lightable;
import Backend.Items.FlashLight;

public class Room implements Lightable {

    private final int wallsNumber=4;
    private String name;
    private Wall [] Walls;
    private boolean isDark;
    private boolean hasLights;

    public Room(){
        this.name="Room";
        this.isDark=false;
        this.hasLights=true;
        this.Walls= new Wall[wallsNumber];
    }
    public void addWalls(Wall [] walls){
        for(int i=0;i<wallsNumber;i++) {
            notNull(walls[i]);
            this.Walls[i]=walls[i];
        }
    }
    public void addWallToDirection(Wall wall,int pos){
        notNull(wall);
        if(pos<this.wallsNumber || pos>=0)
            this.Walls[pos]=wall;
        else
            throw new IndexOutOfBoundsException();
    }

    public void setDark(boolean dark) {
        isDark = dark;
    }
    public boolean isDark() {
        return isDark;
    }

    private boolean notNull(Object obj) {
        if (obj != null) return true;
        throw new NullPointerException();
    }

    @Override
    public void useFlashlight(FlashLight flashLight) {
        notNull(flashLight);
        flashLight.switchFlashlight();
        if(flashLight.isLit() && this.isDark)
            this.isDark = false;
    }

    @Override
    public void switchLights() {
        if(this.hasLights) { this.isDark = !isDark; }
        else { System.out.println(this.name+" dosn't have lights."); }
    }


}
