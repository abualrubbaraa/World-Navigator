package Backend.Enums.ItemEnums;

public enum MirrorCommands {
    check;

    public int asInt;

    private MirrorCommands(){
        this.asInt = ordinal();
    }

}
