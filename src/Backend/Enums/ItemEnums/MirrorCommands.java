package Backend.Enums.ItemEnums;

public enum MirrorCommands {
    check('c');

    public int asInt;
    public char asChar;
    private MirrorCommands(char c){
        this.asInt = ordinal();
        this.asChar = c;
    }

}
