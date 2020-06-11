package Backend.GameTools;

import Backend.Interfaces.Wallable;
import Backend.Items.NullObjects.Plain;

import java.io.Serializable;

public class Wall implements Serializable {
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
