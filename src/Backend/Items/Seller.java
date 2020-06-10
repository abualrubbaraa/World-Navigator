package Backend.Items;

import Backend.Interfaces.Checkable;
import Backend.Interfaces.Containable;
import Backend.Interfaces.Tradable;
import Backend.Interfaces.Wallable;

import java.util.ArrayList;
import java.util.Scanner;

public class Seller implements Wallable, Tradable {

    private String name;
    private ArrayList<Containable> sellerItems;
    private ArrayList<Containable> selleingList;

    public Seller(ArrayList<Containable> selleingList){
        this.name = "Seller";
        this.sellerItems = new ArrayList<>();
        this.selleingList = selleingList;
    }

    public void addItem(Containable item){
        if(notNull(item))
            this.sellerItems.add(item);
        else
            throw new NullPointerException();
    }
    private boolean notNull(Object obj) { return (obj!=null); }

    public String getName() {
        return name;
    }
    public ArrayList<Containable> getSellerItems() {
        return sellerItems;
    }


    @Override
    public String look() {
        return Seller.className();
    }


    @Override
    public ArrayList<Containable> getItems() {
        return this.sellerItems;
    }

    @Override
    public ArrayList<Containable> getSellList() {
        return this.selleingList;
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

    private void displayTradeOptions() {
        System.out.println("You have these options");
        System.out.println("1. Buy");
        System.out.println("2. Sell");
        System.out.println("3. List");
        System.out.println("4. Finish");
    }
    private void displayContent() {
        System.out.println("\n"+this.name + " have these items:- ");
        System.out.println("Item        Price");
        for(int i=0;i<this.sellerItems.size();i++)
            System.out.println((i+1)+") "+sellerItems.get(i).getDescription()+"    "+sellerItems.get(i).getPrice());
        System.out.println("    ***    ");
    }
    private int getInput(int from,int to,String msg){
        Scanner in = new Scanner(System.in);
        int commandNumber;
        boolean first=true;
        System.out.println(msg);
        do {
            if(!first){ System.out.println("** number not in the range **"); }
            while (!in.hasNextInt()) {
                System.out.println(msg);
                String input = in.next();
                System.out.printf("\"%s\" is not a valid number.\n", input);
            }
            commandNumber = in.nextInt();
            if(first) { first = false; }

        } while (commandNumber < from || commandNumber > to);
        return commandNumber;
    }
    public static String className(){
        return "Seller";
    }
}
