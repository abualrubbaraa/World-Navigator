package Backend.Interfaces;

import Backend.Items.Chest;
import Backend.Items.Key;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.HashMap;

public interface Checkable {

  public interface ForContent {
    public Key check();
  }

  public interface ForOpenablility {
    public boolean check();
  }

  public interface ForLockedContent {
    public HashMap<Boolean, ArrayList<Containable>> check();
  }
}
