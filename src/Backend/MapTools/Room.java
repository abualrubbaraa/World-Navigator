package Backend.MapTools;

import Backend.Enums.Directions;
import Backend.Interfaces.Lightable;
import Backend.Items.FlashLight;
import Backend.Items.NullObjects.Plain;

public class Room implements Lightable {

    private final int wallsNumber=4;
    private String name;
    private boolean isDark;
    private boolean hasLights;
    private Wall [] walls;

    public Room(boolean isDark,boolean hasLights){
        this.name="Room";
        this.isDark=isDark;
        this.hasLights=hasLights;
        this.walls= new Wall[wallsNumber];
        for(int i=0;i<this.wallsNumber;i++)
            this.walls[i]=new Wall();
    }

    public Wall getWallinDirection(Directions direction){
        validDirection(direction);
        int dirNum = Directions.getPosInNumbers(direction);
        return this.walls[dirNum];
    }

    private void validDirection(Directions direction) {
        int temp = Directions.getPosInNumbers(direction);
        if( !(temp> 0 && temp<Directions.values().length) )
             throw new IndexOutOfBoundsException("Wrong Direction");
    }

//    public void addWallToDirection(Wall wall,int pos){
//        notNull(wall);
//        if(pos<this.wallsNumber || pos>=0)
//            this.walls[pos]=wall;
//        else
//            throw new IndexOutOfBoundsException();
//    }

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
