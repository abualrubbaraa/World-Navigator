package Backend.MapTools;

import Backend.Interfaces.Wallable;
import Backend.Items.NullObjects.Plain;

public class Wall {

    private Wallable wallContent;

    public Wall(Wallable content){
        this.wallContent=content;
    }
    public Wall(){
        this.wallContent=new Plain();
    }

}
