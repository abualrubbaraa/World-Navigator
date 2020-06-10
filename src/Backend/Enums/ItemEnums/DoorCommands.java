package Backend.Enums.ItemEnums;

public enum DoorCommands {
    check('c'),open('o'),use_Key('k');
    public int asInt;
    public char asChar;

    private DoorCommands(char c){
        this.asInt = ordinal();
        this.asChar = c;
    }
}
