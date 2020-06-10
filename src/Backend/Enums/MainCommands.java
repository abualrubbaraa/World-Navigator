package Backend.Enums;

public enum MainCommands {

    Look('l'),
    Use_Flashlight('f'),
    Turn_Lights('t'),
    Player_Status('p'),
    Restart('r'),
    Quit('q');

    public char asChar;
    MainCommands(char c) {
        this.asChar=c;
    }

}
