package Backend.Items;

import Backend.Interfaces.Checkable;
import Backend.Interfaces.Wallable;
import Backend.Items.NullObjects.EmptyKey;

public class Mirror implements Wallable, Checkable.ForContent {
    private final String name;
    private Key itemIn;

    private Mirror(){
        this.name="Mirror";
        this.itemIn=new EmptyKey();
    }
    private Mirror(Key key){
        this.name="Mirror";
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

    public String getName() {
        return name;
    }
    public Key getInside() {
        return itemIn;
    }

    @Override
    public String look() { return Mirror.className(); }

    @Override
    public Key check() {
        if( this.itemIn.getDescription() != EmptyKey.description()){
            Key tempKey = this.itemIn;
            this.itemIn = new EmptyKey();
            return tempKey;
        }
        else
            return new EmptyKey();
    }

    public static String className(){
        return "Mirror";
    }
}
