package Backend.Enums.ItemEnums;

public enum SellerCommands {
    trade;
    public int asInt;
    private SellerCommands(){ this.asInt = ordinal(); }
}
