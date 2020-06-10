package Backend.Items;

import Backend.Interfaces.Containable;
import Backend.Items.NullObjects.NullFlashlight;

public class FlashLight  implements Containable {
    private final String name;
    private int price;
    private boolean isLit;

    public FlashLight(int price){
        this.name = FlashLight.className();
        this.price=price;
        this.isLit=false;
    }

    public void setLit(boolean lit) {
        isLit = lit;
    }
    public void turnOn() {
        this.isLit=true;
    }
    public void turnOff() {
        this.isLit=false;
    }
    public boolean isLit(){
        return this.isLit;
    }

    public boolean switchFlashlight(){
        if(this.getName()== NullFlashlight.className())
            return false;
        this.isLit = !this.isLit;
        return true;
    }


    @Override
    public String getName() {
        return name;
    }
    @Override
    public int getPrice() {
        return price;
    }
    @Override
    public String getDescription() { return (getName()); }


    public static String className(){
        return "Flashlight";
    }

}
