package Backend.Enums;

public enum DoorCommands {
    check,open,use_Key;

    public int asInt;

    private DoorCommands(){
        this.asInt = ordinal();
    }
}
