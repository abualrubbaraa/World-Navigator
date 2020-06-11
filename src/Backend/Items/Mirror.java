package Backend.Items;

import Backend.Interfaces.Checkable;
import Backend.Interfaces.Wallable;
import Backend.Items.NullObjects.NullKey;

import java.io.Serializable;

public class Mirror implements Wallable, Checkable.ForContent , Serializable {
    private Key itemIn;

    private Mirror(){
        this.itemIn=new NullKey();
    }
    private Mirror(Key key){
        this.itemIn=key;
    }
    public static Mirror getInstance(){
        return new Mirror();
    }
    public static Mirror valueOf(Key key){
        return new Mirror(key);
    }
    
    
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
    public String look() { return Mirror.className(); }
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
        return "Mirror";
    }
}
