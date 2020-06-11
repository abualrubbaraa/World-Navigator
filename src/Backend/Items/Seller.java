package Backend.Items;

import Backend.Interfaces.Containable;
import Backend.Interfaces.Tradable;
import Backend.Interfaces.Wallable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Seller implements Wallable, Tradable, Serializable {

    private ArrayList<Containable> sellerItems;

    public Seller(){
        this.sellerItems = new ArrayList<>();
    }

    public void addItem(Containable item){
        Objects.requireNonNull(item);
        if( !item.getDescription().equals("Null"))
            this.sellerItems.add(item);
        else
            throw new NullPointerException();
    }

    public ArrayList<Containable> getSellerItems() {
        return this.sellerItems;
    }

    @Override
    public String look() { return this.toString(); }
    @Override
    public List<Containable> getItems() {
        return getSellerItems();
    }
    @Override
    public boolean sellItem(Containable item) {
        Objects.requireNonNull(item);
        if(this.sellerItems.contains(item)){
            this.sellerItems.remove(item);
            return true;
        }
        return false;
    }
    @Override
    public void buyItem(Containable item) {
        Objects.requireNonNull(item);
        this.sellerItems.add(item);
    }

    public static String className(){ return "Seller"; }
    @Override
    public String toString() {
        return "Seller";
    }
}
