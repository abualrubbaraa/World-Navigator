package Backend.Items;

import Backend.Interfaces.Containable;

public class Key implements Containable {

    private  String name;
    private  int price;
    private  String relatedDoor;

    public Key(String name, int price, String relatedDoor){
        if(notNull(name) && notNull(relatedDoor) && price>=0)
        {
            this.name=name;
            this.price= price;
            this.relatedDoor=relatedDoor;
        }
        else
            throw new NullPointerException();
    }

    private boolean notNull(Object obj){
        if(obj!=null)
            return true;
        return false;
    }
    public String getRelatedDoor() {
        return relatedDoor;
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

    public void setRelatedDoor(String relatedDoor){
        this.relatedDoor=relatedDoor;
    }
    public static String className(){
        return "Key";
    }

}
