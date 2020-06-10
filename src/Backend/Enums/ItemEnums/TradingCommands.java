package Backend.Enums.ItemEnums;

public enum TradingCommands {
    Buy,Sell,List,Finish;
    public int asInt;
    private TradingCommands(){
        this.asInt = ordinal();
    }

}
