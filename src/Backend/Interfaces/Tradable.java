package Backend.Interfaces;

import java.util.List;

public interface Tradable extends Buyable, Sellable {
  public List<Containable> getItems();
}
