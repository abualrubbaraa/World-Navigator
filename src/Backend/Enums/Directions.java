package Backend.Enums;

public enum Directions {
  NORTH(0),
  EAST(1),
  SOUTH(2),
  WEST(3);
  public int asInt;

  Directions(int asInt) {
    this.asInt = asInt;
  }

  public static Directions getOppositeDirection(Directions direction) {
    switch (direction) {
      case NORTH:
        return SOUTH;
      case EAST:
        return WEST;
      case WEST:
        return EAST;
      case SOUTH:
        return NORTH;
    }
    throw new IllegalArgumentException();
  }
}
