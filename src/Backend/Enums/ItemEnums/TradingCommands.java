package Backend.Enums.ItemEnums;

public enum TradingCommands {
  Buy(0),
  Sell(1),
  List(2),
  Finish(3);
  public int asInt;

  private TradingCommands(int asInt) {
    this.asInt = asInt;
  }
}
