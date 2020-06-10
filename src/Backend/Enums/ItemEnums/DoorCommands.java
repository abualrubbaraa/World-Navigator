package Backend.Enums.ItemEnums;

public enum DoorCommands {
    check,open,use_Key;
    public int asInt;
    private DoorCommands(){
        this.asInt = ordinal();
    }
}
