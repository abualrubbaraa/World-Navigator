package Backend.Items;
import Backend.Interfaces.Containable;

import java.io.Serializable;

public class FlashLight  implements Containable , Serializable {

    private int price;
    private boolean isOn;

    public FlashLight(int price){
        this.price=price;
        this.isOn =false;
    }
    public static FlashLight getInstance(){
        return new FlashLight(50);
    }
    public static FlashLight valueOf(int price){
        return new FlashLight(price);
    }

    public void setOn(boolean on) {
        isOn = on;
    }
    public void turnOn() { this.isOn =true; }
    public void turnOff() {
        this.isOn =false;
    }
    public boolean switchFlashlight(){
        this.isOn = !this.isOn;
        return true;
    }

    public boolean isOn(){
        return this.isOn;
    }
    @Override
    public String getName() {
        return FlashLight.className();
    }
    @Override
    public int getPrice() {
        return price;
    }
    @Override
    public String getDescription() { return getName(); }

    public static String className(){
        return "Flashlight";
    }
}
