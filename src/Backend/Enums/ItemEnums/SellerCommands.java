package Backend.Enums.ItemEnums;

public enum SellerCommands {
  trade(0, 't');
  public int asInt;
  public char asChar;

  private SellerCommands(int asInt, char asChar) {
    this.asInt = ordinal();
    this.asChar = asChar;
  }
}
