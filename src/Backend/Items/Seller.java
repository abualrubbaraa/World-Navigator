package Backend.Items;

import Backend.Interfaces.Containable;
import Backend.Interfaces.Tradable;
import Backend.Interfaces.Wallable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Seller implements Wallable, Tradable , Serializable {

    private ArrayList<Containable> sellerItems;

    public Seller(){
        this.sellerItems = new ArrayList<>();
    }

    public void addItem(Containable item){
        if(notNull(item) && !item.getDescription().equals("Null"))
            this.sellerItems.add(item);
        else
            throw new NullPointerException();
    }
    private boolean notNull(Object obj) { return (obj!=null); }

    public ArrayList<Containable> getSellerItems() {
        return this.sellerItems;
    }

    @Override
    public String look() {
        return Seller.className();
    }
    @Override
    public ArrayList<Containable> getItems() {
        return getSellerItems();
    }
    @Override
    public boolean sellItem(Containable item) {
        notNull(item);
        if(this.sellerItems.contains(item)){
            this.sellerItems.remove(item);
            return true;
        }
        return false;
    }
    @Override
    public void buyItem(Containable item) {
        notNull(item);
        this.sellerItems.add(item);
    }

    public static String className(){
        return "Seller";
    }
}
