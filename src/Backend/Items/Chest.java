package Backend.Items;

import Backend.Interfaces.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Chest implements Wallable,Checkable.ForLockedContent,Lockable, Serializable {

    private boolean isOpen;
    private Key requiredKey;
    private ArrayList<Containable> content;

    public Chest(boolean isOpen,Key requiredKey,ArrayList content){
        this.isOpen=isOpen;
        this.requiredKey=requiredKey;
        this.content = content;
    }

    public void addItemToChest(Containable item){
        if(notNull(item))
            this.content.add(item);
        else
            throw new NullPointerException();
    }
    public void setContent(ArrayList content){
        this.content=content;
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

    private boolean notNull(Containable obj) {
        if (obj != null && !obj.getDescription().equals("Null") ) return true;
        throw new NullPointerException();
    }

    @Override
    public String look() { return Chest.className(); }
    @Override
    public HashMap<Boolean, ArrayList<Containable>> check() {
        if( this.isOpen()){
            ArrayList<Containable> temp = this.content;
            this.content = new ArrayList<Containable>();
            HashMap<Boolean,ArrayList<Containable>> res = new HashMap<>();
            res.put(true,temp);
            return res;
        }
        else {
            ArrayList<Containable> keyHolder = new ArrayList<>();
            keyHolder.add(this.requiredKey);
            HashMap<Boolean,ArrayList<Containable>> res = new HashMap<>();
            res.put(false,keyHolder);
            return res;
        }
    }
    @Override
    public String useKey(Key key) {
        notNull(key);
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
}
