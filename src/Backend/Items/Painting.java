package Backend.Items;

import Backend.Interfaces.Checkable;
import Backend.Interfaces.Wallable;
import Backend.Items.NullObjects.EmptyKey;

public class Painting implements Wallable,Checkable.ForContent{

    private final String name;
    private Key itemIn;

    private Painting(){
        this.name="Painting";
        this.itemIn=new EmptyKey();
    }
    private Painting(Key key){
        this.name="Painting";
        this.itemIn=key;
    }
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

    public String getName() {
        return this.name;
    }
    public Key getInside() {
        return itemIn;
    }
    
    @Override
    public String look() { return Painting.className(); }

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
        return "Painting";
    }

}
