package Backend.Enums;

public enum BaseCommands {
  Look('l'),
  Use_Flashlight('f'),
  Turn_Lights('t'),
  Player_Status('p'),
  Restart('r'),
  Quit('q');

  public char asChar;

  BaseCommands(char c) {
    this.asChar = c;
  }
}
