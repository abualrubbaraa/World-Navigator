package Backend.Enums.ItemEnums;

public enum SellerCommands {
    trade('t');
    public int asInt;
    public char asChar;
    private SellerCommands(char c){
        this.asInt = ordinal();
        this.asChar=c;
    }
}
