package Backend.Items;

import Backend.Interfaces.*;
import java.util.ArrayList;

public class Chest implements Wallable,Checkable,Lockable {

    private String name;
    private boolean isOpen;
    private Key requiredKey;
    private ArrayList<Containable> content;

    public Chest(boolean isOpen,Key requiredKey,ArrayList content){
        this.name="Chest";
        this.isOpen=isOpen;
        this.requiredKey=requiredKey;
        this.content = content;
    }

    public void setContent(ArrayList content){
        this.content=content;
    }
    public void addItemToChest(Containable item){
        if(notNull(item))
            this.content.add(item);
        else
            throw new NullPointerException();
    }
    private boolean notNull(Object obj) {
        if (obj != null) return true;
        throw new NullPointerException();
    }

    public String getName() {
        return name;
    }
    public boolean isOpen() {
        return isOpen;
    }
    public Key getRequiredKey() {
        return requiredKey;
    }
    public ArrayList<Containable> getContent() {
        return content;
    }

    @Override
    public String look() { return this.name; }
    @Override
    public void check() {
        if( this.isOpen()){
            if(this.content.size()>0){
                System.out.println("These items are aquired :-");
                for(Containable item:this.content)
                    System.out.println(item.getDescription());
                this.setContent(new ArrayList<Containable>());
            }
            else
                System.out.println("Empty "+this.name);
        }
        else
            System.out.println( this.getName()+" closed "+this.getRequiredKey()+" key is needed to unlock");

    }
    @Override
    public void useKey( Key key ) {
        notNull(key);
        if( this.requiredKey == key ){
            this.isOpen=!isOpen;
            System.out.println(this.name +" " + ( (isOpen==true) ? "Opened" : "Closed") );
        }
        else
            System.out.println( "This Key (" +key.getName() + ") is not sutable for the " + this.name);
    }
}
