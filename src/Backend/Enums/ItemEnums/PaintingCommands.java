package Backend.Enums.ItemEnums;

public enum PaintingCommands {
    check('c');
    public int asInt;
    public char asChar;
    private PaintingCommands(char c){
        this.asInt = ordinal();
        this.asChar = c;
    }
}
