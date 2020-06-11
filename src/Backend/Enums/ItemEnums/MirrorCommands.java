package Backend.Enums.ItemEnums;

public enum MirrorCommands {
  check(0, 'c');

  public int asInt;
  public char asChar;

  private MirrorCommands(int asInt, char c) {
    this.asInt = asInt;
    this.asChar = c;
  }
}
