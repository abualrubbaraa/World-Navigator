package Backend.GameTools;

import Backend.Enums.Directions;
import Backend.Interfaces.Containable;
import Backend.Items.FlashLight;
import Backend.Items.Gold;
import Backend.Items.Key;
import Backend.Items.NullObjects.NullKey;
import Backend.Items.NullObjects.NullFlashlight;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Player implements Serializable {

  private Directions direction;
  private int money;
  private FlashLight flashlight;
  private ArrayList<Key> playerKeys;

  public Player() {
    this.direction = Directions.NORTH;
    this.playerKeys = new ArrayList<>();
    this.money = 0;
    this.flashlight = new NullFlashlight();
  }

  public Player(Directions direction, int money, FlashLight flashLight) {
    this.direction = direction;
    this.money = money;
    this.flashlight = flashLight;
    this.playerKeys = new ArrayList<>();
  }

  public int getMoney() {
    return this.money;
  }

  public ArrayList<Key> getPlayerKeys() {
    return this.playerKeys;
  }

  public boolean hasFlashlight() {
    return (this.flashlight.getDescription() != NullFlashlight.className());
  }

  public boolean hasKey(Key key) {
    Objects.requireNonNull(key);
    return this.playerKeys.contains(key);
  }

  public Key getKeyPosition(int keypos) {
    if (keypos >= 0 && keypos < this.playerKeys.size()) return this.playerKeys.get(keypos);
    throw new IndexOutOfBoundsException();
  }

  public FlashLight getFlashlight() {
    return this.flashlight;
  }

  public void addItem(Containable item) {
    Objects.requireNonNull(item);
    if (item instanceof FlashLight) {
      if (this.flashlight.getName() == NullFlashlight.className())
        this.flashlight = (FlashLight) item;
    } else if (item instanceof Gold) this.money += ((Gold) item).getPrice();
    else if (item instanceof Key) addKey((Key) item);
  }

  private void addKey(Key key) {
    Objects.requireNonNull(key);
    if (!key.getDescription().equals(NullKey.description())) ;
    this.playerKeys.add(key);
  }

  public Key takeKey(Key key) {
    Objects.requireNonNull(key);
    if (this.playerKeys.contains(key)) {
      this.playerKeys.remove(key);
      return key;
    }
    return new NullKey();
  }

  public boolean buyItem(Containable item) {
    Objects.requireNonNull(item);
    if (this.money >= item.getPrice()) {
      this.money -= item.getPrice();
      addItem(item);
      return true;
    } else return false;
  }

  public boolean sellItem(Containable item) {
    Objects.requireNonNull(item);
    if (item instanceof FlashLight) {
      if (this.flashlight.getDescription() != NullFlashlight.className()) {
        this.money += this.flashlight.getPrice();
        this.flashlight = new NullFlashlight();
        return true;
      }
    } else if (item instanceof Key) {
      if (playerKeys.contains(item)) {
        this.money += item.getPrice();
        this.playerKeys.remove(item);
        return true;
      } else return false;
    }
    return false;
  }

  public void addItems(ArrayList<Containable> items) {
    for (Containable item : items) {
      this.addItem(item);
    }
  }

  public void setItems(ArrayList<Containable> items) {
    this.playerKeys = new ArrayList<Key>();
    this.money = 0;
    this.flashlight = new NullFlashlight();
    addItems(items);
  }

  public void moveRight() {
    this.direction = Directions.values()[((this.direction.asInt + 1) % Directions.values().length)];
  }

  public void moveLeft() {
    this.direction =
        Directions.values()[
            (this.direction.asInt + Directions.values().length - 1) % Directions.values().length];
  }

  public Directions getDirection() {
    return this.direction;
  }

  @Override
  public String toString() {
    return "Player";
  }
}
