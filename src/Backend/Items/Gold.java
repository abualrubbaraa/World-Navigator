package Backend.Items;
import Backend.Interfaces.Containable;

import java.io.Serializable;
import java.util.Objects;

public class Gold implements Containable, Serializable {

    private int goldPrice;

    public Gold(int price){
        Objects.requireNonNull(price);
        this.goldPrice = price;
    }

    @Override
    public String getName() { return Gold.className(); }
    @Override
    public int getPrice() { return this.goldPrice; }
    @Override
    public String getDescription() { return this.goldPrice+" of "+ Gold.className(); }

    public static String className(){
        return "Gold";
    }

    @Override
    public String toString() {
        return "Gold";
    }
}
