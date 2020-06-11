package Backend.Items;

import Backend.Interfaces.Checkable;
import Backend.Interfaces.Wallable;
import Backend.Items.NullObjects.NullKey;

import java.io.Serializable;

public class Painting implements Wallable,Checkable.ForContent, Serializable {

    private Key itemIn;

    private Painting(){ this.itemIn=new NullKey(); }
    private Painting(Key key){ this.itemIn=key; }
    public static Painting getInstance(){ return new Painting(); }
    public static Painting valueOf(Key key){ return new Painting(key); }

    public void setInside(Key key){
        notNull(key);
        this.itemIn=key;
    }
    private boolean notNull(Object obj) {
        if (obj != null) return true;
        throw new NullPointerException();
    }

    public Key getInside() {
        return itemIn;
    }
    
    @Override
    public String look() { return Painting.className(); }
    @Override
    public Key check() {
        if( this.itemIn.getDescription() != NullKey.description()){
            Key tempKey = this.itemIn;
            this.itemIn = new NullKey();
            return tempKey;
        }
        else
            return new NullKey();
    }

    public static String className(){
        return "Painting";
    }
}
