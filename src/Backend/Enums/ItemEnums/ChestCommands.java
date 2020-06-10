package Backend.Enums.ItemEnums;

public enum ChestCommands {
    check('c'),use_Key('k');
    public int asInt;
    public char asChar;
    private ChestCommands(char c){
        this.asInt = ordinal();
        this.asChar = c;
    }
}
