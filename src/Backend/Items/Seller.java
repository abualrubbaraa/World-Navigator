package Backend.Items;
import Backend.Interfaces.Containable;
import Backend.Interfaces.Tradable;
import Backend.Interfaces.Wallable;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Seller implements Wallable, Tradable {

    private String name;
    private ArrayList<Containable> sellerItems;

    public Seller(){
        this.name = "Seller";
        this.sellerItems = new ArrayList<>();
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
        return this.getName();
    }

    @Override
    public void trade() {
        Scanner in = new Scanner(System.in);
        boolean finish = false;
        if(this.sellerItems.size()>0){
            displayContent();
            while(!finish){
                displayTradeOptions();
                int commandNumber = getInput(1,4,"Please enter a positive number of the command you want. ");
                switch (commandNumber){
                    case 3 :
                        displayContent();
                        break;
                    case 4 :
                        finish =true;
                        break ;
                    case 1 :
                    case 2 :
                        int itemNumber = getInput(1,this.sellerItems.size(),"Please enter the item number..");
                        System.out.println(itemNumber);
                        break;
                }
            }
        }
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

}
