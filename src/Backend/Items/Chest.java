package Backend.Items;

import Backend.Interfaces.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Chest implements Wallable,Checkable.ForLockedContent,Lockable, Serializable {

    private String chestName;
    private boolean isOpen;
    private Key requiredKey;
    private ArrayList<Containable> chestContents;

    public Chest(String chestName,boolean isOpen,Key requiredKey,ArrayList content){
        this.chestName= chestName;
        this.isOpen=isOpen;
        this.requiredKey=requiredKey;
        this.chestContents = content;
    }

    public void addItemToChest(Containable item){
        if(notNullObject(item))
            this.chestContents.add(item);
        else
            throw new NullPointerException();
    }
    public void setChestContents(ArrayList<Containable> chestContents){
        for (Containable item:chestContents) { Objects.requireNonNull(item); }
        this.chestContents = chestContents;
    }

    public void setRequiredKey(Key requiredKey) {
        this.requiredKey = requiredKey;
    }

    public String getChestName() {
        return chestName;
    }

    public boolean isOpen() {
        return isOpen;
    }
    public Key getRequiredKey() {
        return requiredKey;
    }
    public ArrayList<Containable> getChestContents() {
        return chestContents;
    }

    private boolean notNullObject(Containable obj) {
        if (obj != null && !obj.getDescription().equals("Null") ) return true;
        throw new NullPointerException();
    }

    @Override
    public String look() { return Chest.className(); }
    @Override
    public HashMap<Boolean, ArrayList<Containable>> check() {
        if( this.isOpen()){
            ArrayList<Containable> temp = this.chestContents;
            this.chestContents = new ArrayList<Containable>();
            HashMap<Boolean,ArrayList<Containable>> res = new HashMap<>(1);
            res.put(true,temp);
            return res;
        }
        else {
            ArrayList<Containable> keyHolder = new ArrayList<>();
            keyHolder.add(this.requiredKey);
            HashMap<Boolean,ArrayList<Containable>> res = new HashMap<>(1);
            res.put(false,keyHolder);
            return res;
        }
    }
    @Override
    public String useKey(Key key) {
        notNullObject(key);
        if( this.requiredKey == key ){
            this.isOpen=!isOpen;
            return(Chest.className() +" " + ( (isOpen==true) ? "Opened" : "Closed") );
        }
        else
            return ( "This Key (" +key.getName() + ") is not sutable for the " + Chest.className());
    }

    public static String className(){
        return "Chest";
    }

    @Override
    public String toString() {
        return "Chest";
    }

}
