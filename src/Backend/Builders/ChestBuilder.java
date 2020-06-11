package Backend.Builders;

import Backend.Interfaces.Containable;
import Backend.Items.Chest;
import Backend.Items.Key;
import Backend.Items.NullObjects.NullKey;

import java.util.ArrayList;
import java.util.Objects;

public class ChestBuilder {

  private String chestName;
  private boolean isOpen = false;
  private Key requiredKey = new NullKey();
  private ArrayList<Containable> content = new ArrayList<>();

  public ChestBuilder setChestName(String name) {
    this.chestName = name;
    return this;
  }

  public ChestBuilder setOpen(boolean open) {
    isOpen = open;
    return this;
  }

  public ChestBuilder setRequiredKey(Key requiredKey) {
    Objects.requireNonNull(requiredKey);
    this.requiredKey = requiredKey;
    return this;
  }

  public ChestBuilder setContent(ArrayList<Containable> content) {
    for (Containable itemInList : content) {
      Objects.requireNonNull(itemInList);
    }
    this.content = content;
    return this;
  }

  public Chest build() {
    if ((this.requiredKey.getDescription() == NullKey.description()) || this.chestName == null)
      throw new IllegalArgumentException();
    return new Chest(this.chestName,this.isOpen, this.requiredKey, this.content);
  }

  @Override
  public String toString() {
    return "ChestBuilder";
  }
}
