package Backend.Items;

import Backend.Interfaces.Containable;

public class FlashLight  implements Containable {
    private String name;
    private int price;
    private boolean isLit;

    public FlashLight(int price){
        this.name="Flashligh";
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
    public void switchFlashlight(){
        this.isLit = !this.isLit;
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

}
