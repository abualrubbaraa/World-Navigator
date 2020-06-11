package Backend.Enums.ItemEnums;

public enum ChestCommands {
  check(0, 'c'),
  use_Key(1, 'k');
  public int asInt;
  public char asChar;

  private ChestCommands(int asInt, char c) {
    this.asInt = asInt;
    this.asChar = c;
  }
}
