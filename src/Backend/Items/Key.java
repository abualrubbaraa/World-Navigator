package Backend.Items;

import Backend.Interfaces.Containable;

public class Key implements Containable {

    private final String name;
    private final int price;
    private final String relatedLock;

    public Key(String name, int price, String relatedLock){
        if(notNull(name) && notNull(relatedLock) && price>=0)
        {
            this.name=name;
            this.price= price;
            this.relatedLock=relatedLock;
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

}
