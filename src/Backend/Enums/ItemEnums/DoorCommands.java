package Backend.Enums.ItemEnums;

public enum DoorCommands {
  check(0, 'c'),
  open(1, 'o'),
  use_Key(2, 'k');
  public int asInt;
  public char asChar;

  private DoorCommands(int asInt, char c) {
    this.asInt = asInt;
    this.asChar = c;
  }
}
