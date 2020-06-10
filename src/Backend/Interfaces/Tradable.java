package Backend.Interfaces;

import java.util.ArrayList;

public interface Tradable {
    public ArrayList<Containable> getItems();
    public ArrayList<Containable> getSellList();
    public boolean sellItem(Containable item);
    public void buyItem(Containable item);

}
