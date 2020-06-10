package Backend.GameTools;

import Backend.Interfaces.Wallable;
import Backend.Items.NullObjects.Plain;

public class Wall {

    private Wallable wallContent;

    public Wall(){
        this.wallContent=new Plain();
    }
    public void setWallContent(Wallable content){
        notNull(content);
        this.wallContent=content;
    }
    public Wallable getWallContent(){ return this.wallContent; }
    private boolean notNull(Object obj) {
        if (obj != null) return true;
        throw new NullPointerException();
    }
}
