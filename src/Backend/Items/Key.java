package Backend.Items;

import Backend.Interfaces.Containable;
import java.io.Serializable;
import java.util.Objects;

public class Key implements Containable , Serializable {

    private  String name;
    private  int price;
    private  String relatedLock;

    public Key(String name, int price, String relatedLock){
        Objects.requireNonNull(name);
        Objects.requireNonNull(relatedLock);
        if(price>=0) {
            this.name=name;
            this.price= price;
            this.relatedLock =relatedLock;
        }
        else
            throw new NullPointerException();
    }

    public void setRelatedLock(String relatedLock){
        Objects.requireNonNull(relatedLock);
        this.relatedLock =relatedLock;
    }
    public String getRelatedLock() {
        return relatedLock;
    }


    @Override
    public String getName() {
        return name;
    }
    @Override
    public int getPrice() {
        return price;
    }
    @Override
    public String getDescription() { return (this.name + " Key"); }

    public static String className(){
        return "Key";
    }

    @Override
    public String toString() {
        return this.getName()+" Key";
    }

}
