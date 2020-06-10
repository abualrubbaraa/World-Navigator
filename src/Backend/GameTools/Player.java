package Backend.GameTools;

import Backend.Enums.Directions;
import Backend.Interfaces.Containable;
import Backend.Items.FlashLight;
import Backend.Items.Gold;
import Backend.Items.Key;
import Backend.Items.NullObjects.EmptyKey;
import Backend.Items.NullObjects.NullFlashlight;

import java.util.ArrayList;

public class Player {

    private Directions pos;
    private int money;
    private ArrayList<Containable> items;
    private FlashLight flashlight;

    public Player(){
        this.pos=Directions.NORTH;
        this.items=new ArrayList<>();
        this.money = 0;
        this.flashlight= new NullFlashlight();
    }

    public int getMoney() {
        return money;
    }

    public ArrayList<Containable> getItems() {
        return items;
    }

    public boolean hasFlashlight(){
        return (this.flashlight.getName() != NullFlashlight.className());
    }

    public boolean hasKey(Key key){
        notNull(key);
        for (Containable item:this.items) {
            if(item.equals(key))
                return true;
        }
        return false;
    }

    public Key getKey(Key key){
        notNull(key);
        for (Containable item:this.items) {
            if(item.equals(key)){
                this.items.remove(key);
                return key;
            }
        }
        return new EmptyKey();
    }

    public FlashLight getFlashlight(){
        return this.flashlight;
    }

    public void addItem(Containable item){
        notNull(item);
        this.items.add(item);
        if(item instanceof FlashLight){
            this.flashlight = (FlashLight) item;
        }
        else if(item instanceof Gold)
            this.money += ((Gold)item).getPrice();
    }
    public void addItems(ArrayList<Containable> items){
        for (Containable item:items) {
            notNull(item);
            this.items.add(item);
            if(item instanceof FlashLight){
                System.out.println("shit");
                this.flashlight = ((FlashLight) item);
            }
            else if(item instanceof Gold)
                this.money += ((Gold)item).getPrice();

        }
    }
    public void setItems(ArrayList<Containable> items){
        for (Containable item:items) notNull(item);
        this.items=items;
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
