package Backend.Builders;
import Backend.Items.Key;

public class KeyBuilder {

    private  String name;
    private  int price;
    private  String relatedDoor;

    public KeyBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public KeyBuilder setPrice(int price) {
        this.price = price;
        return this;
    }
    public KeyBuilder setRelatedDoor(String relatedDoor) {
        this.relatedDoor = relatedDoor;
        return this;
    }

    public Key build(){
        if(name==null || relatedDoor==null)
            throw new IllegalArgumentException();
        return new Key(this.name,0,this.relatedDoor);
    }

}
