package Backend.Items;

import Backend.Interfaces.Containable;

public class Gold implements Containable {

    private String name;
    private int goldPrice;

    public Gold(int price){
        this.name="Gold";
        this.goldPrice = price;
    }

    @Override
    public String getName() { return this.name; }
    @Override
    public int getPrice() { return this.goldPrice; }
    @Override
    public String getDescription() { return this.goldPrice+" of "+this.name; }

    public static String className(){
        return "Gold";
    }
}
