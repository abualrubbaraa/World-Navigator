package Backend.Items;

import Backend.Interfaces.Containable;

import java.io.Serializable;

public class Key implements Containable , Serializable {

    private  String name;
    private  int price;
    private  String relatedDoor;

    public Key(String name, int price, String relatedDoor){
        if(notNull(name) && notNull(relatedDoor) && price>=0) {
            this.name=name;
            this.price= price;
            this.relatedDoor=relatedDoor;
        }
        else
            throw new NullPointerException();
    }

    public void setRelatedDoor(String relatedDoor){
        if(notNull(relatedDoor))
            this.relatedDoor=relatedDoor;
        else
            throw new NullPointerException();
    }
    public String getRelatedDoor() {
        return relatedDoor;
    }

    private boolean notNull(Object obj){
        if(obj!=null)
            return true;
        return false;
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
}
