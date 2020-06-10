package Backend.GameTools;

import Backend.Enums.Directions;
import Backend.Interfaces.Containable;
import Backend.Items.FlashLight;
import Backend.Items.Gold;
import Backend.Items.Key;
import Backend.Items.NullObjects.EmptyKey;
import Backend.Items.NullObjects.NullFlashlight;

import java.net.ConnectException;
import java.util.ArrayList;

public class Player {

    private Directions pos;
    private int money;
    private ArrayList<Key> keys;
    private FlashLight flashlight;

    public Player(){
        this.pos=Directions.NORTH;
        this.keys=new ArrayList<>();
        this.money = 0;
        this.flashlight= new NullFlashlight();
    }

    public int getMoney() {
        return this.money;
    }
    public ArrayList<Key> getKeys(){
        return this.keys;
    }

    public boolean hasFlashlight(){
        return (this.flashlight.getName() != NullFlashlight.className());
    }
    public boolean hasKey(Key key){
        notNull(key);
        return this.keys.contains(key);
    }
    public Key getKey(Key key){
        notNull(key);
        if(this.keys.contains(key)) {
            this.keys.remove(key);
            return key;
        }
        return new EmptyKey();
    }
    public Key getKeyNumber(int keypos){
        if(keypos >=0 && keypos<this.keys.size())
            return this.keys.get(keypos);
        throw new IndexOutOfBoundsException();
    }
    public FlashLight getFlashlight(){
        return this.flashlight;
    }


    public boolean buyItem(Containable item){
        notNull(item);
        if(this.money >= item.getPrice()){
            this.money-=item.getPrice();
            addItem(item);
            return true;
        }
        else
            return false;
    }
    public boolean sellItem(Containable item){
        notNull(item);
        if(item instanceof FlashLight){
            if(this.flashlight.getDescription() != NullFlashlight.className()){
                this.money+=this.flashlight.getPrice();
                this.flashlight = new NullFlashlight();
                return true;
            }
        }
        else if(item instanceof Key){
            if(keys.contains(item)){
                this.money+=item.getPrice();
                this.keys.remove(item);
                return true;
            }
            else
                return false;
        }
        return false;
    }
    public void addItem(Containable item){
        notNull(item);

        if(item instanceof FlashLight){
            if(this.flashlight.getName()==NullFlashlight.className())
                this.flashlight = (FlashLight) item;
        }
        else if(item instanceof Gold)
            this.money += ((Gold)item).getPrice();
        else if(item instanceof Key)
            addKey((Key)item);

    }
    private void addKey(Key key){
        notNull(key);
        this.keys.add(key);
    }

    public void addItems(ArrayList<Containable> keys){
        for (Containable item:keys) {
            notNull(item);
            if(item instanceof FlashLight){
                if(this.flashlight.getName()==NullFlashlight.className()){
                    this.flashlight = (FlashLight) item;
                }
            }
            else if(item instanceof Gold)
                this.money += (item).getPrice();
            else if(item instanceof Key)
                addKey((Key)item);
        }
    }
    public void setItems(ArrayList<Containable> keys){
        this.keys = new ArrayList<Key>();
        this.money = 0;
        this.flashlight = new NullFlashlight();
        addItems(keys);
    }
    public void moveRight(){
        this.pos = Directions.values()[((this.pos.asInt+1)%Directions.values().length)];
    }
    public void moveLeft() {
        this.pos = Directions.values()[(this.pos.asInt + Directions.values().length-1) % Directions.values().length];
    }
    public Directions getPos(){
        return this.pos;
    }


    private boolean notNull(Object obj) {
        if (obj != null) return true;
        throw new NullPointerException();
    }
}
