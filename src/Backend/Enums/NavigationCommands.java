package Backend.Enums;

public enum NavigationCommands {

    Left('a'),Right('d'),Forward('w'),Backword('s');

    public char asChar;
    NavigationCommands(char c) {
        this.asChar=c;
    }

}
