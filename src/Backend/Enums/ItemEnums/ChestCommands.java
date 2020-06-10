package Backend.Enums.ItemEnums;

public enum ChestCommands {
    check,use_Key;
    public int asInt;
    private ChestCommands(){
        this.asInt = ordinal();
    }
}
