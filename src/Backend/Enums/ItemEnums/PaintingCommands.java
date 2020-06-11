package Backend.Enums.ItemEnums;

public enum PaintingCommands {
  check(0, 'c');
  public int asInt;
  public char asChar;

  private PaintingCommands(int asInt, char asChar) {
    this.asInt = asInt;
    this.asChar = asChar;
  }
}
