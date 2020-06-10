package Backend.Enums.ItemEnums;

public enum PaintingCommands {
    check;
    public int asInt;
    private PaintingCommands(){
        this.asInt = ordinal();
    }
}
