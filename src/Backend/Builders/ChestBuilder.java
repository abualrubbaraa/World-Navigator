package Backend.Builders;

import Backend.Interfaces.Containable;
import Backend.Items.Chest;
import Backend.Items.Key;
import Backend.Items.NullObjects.EmptyKey;

import java.util.ArrayList;

public  class ChestBuilder  {

    private boolean isOpen = false;
    private Key requiredKey = new EmptyKey();
    private ArrayList<Containable> content  = new ArrayList<>();

    public ChestBuilder setOpen(boolean open) {
        isOpen = open;
        return this;
    }
    public ChestBuilder setRequiredKey(Key requiredKey) {
        this.requiredKey = requiredKey;
        return this;
    }
    public ChestBuilder setContent(ArrayList<Containable> content) {
        this.content = content;
        return this;
    }

    public Chest build(){
        return new Chest(this.isOpen,this.requiredKey,this.content);
    }
}
