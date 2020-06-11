package Backend.Builders;

import Controller.Game;

import java.io.*;

public class GameFileBuilder implements Serializable {
  public GameFileBuilder() {}

  public static void serializeGameInFile(Game game, String filePath) {
    try {
      FileOutputStream fileOut = new FileOutputStream(filePath);
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(game);
      out.close();
      fileOut.close();
    } catch (IOException i) {
      i.printStackTrace();
    }
  }

  public static void saveGameFile(Game game) {
    File file = new File("").getAbsoluteFile();
    GameFileBuilder.serializeGameInFile(
        game, file + "/src/Games/BuildInGames/" + game.getGameName() + ".ser");
  }

  public static Game getGameFromFile(String filePath) {
    Game gameFromFile = null;
    try {
      FileInputStream fileIn = new FileInputStream(filePath);
      ObjectInputStream in = new ObjectInputStream(fileIn);
      gameFromFile = (Game) in.readObject();
      in.close();
      fileIn.close();
    } catch (IOException i) {
      i.printStackTrace();
    } catch (ClassNotFoundException c) {
      c.printStackTrace();
    }
    return gameFromFile;
  }

  public static Game getSavedGame(String fileName) {
    File file = new File("").getAbsoluteFile();
    return GameFileBuilder.getGameFromFile(file + "/src/Games/BuildInGames/" + fileName + ".ser");
  }

  public static void saveGameInfo(Game game) {
    File file = new File("").getAbsoluteFile();
    GameFileBuilder.serializeGameInFile(
        game, file + "/src/Games/TemporaryGames/" + game.getGameName() + ".ser");
  }

  public static Game loadGameInfo(String fileName) {
    File file = new File("").getAbsoluteFile();
    return GameFileBuilder.getGameFromFile(file + "/src/Games/TemporaryGames/" + fileName + ".ser");
  }

  @Override
  public String toString() {
    return "GameFileBuilder";
  }
}
