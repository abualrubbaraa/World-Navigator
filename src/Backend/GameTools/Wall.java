package Backend.GameTools;

import Backend.Interfaces.Wallable;
import Backend.Items.NullObjects.Plain;

import java.io.Serializable;
import java.util.Objects;

public class Wall implements Serializable {
  private Wallable wallContent;

  public Wall() {
    this.wallContent = new Plain();
  }

  public void setWallContent(Wallable content) {
    Objects.requireNonNull(content);
    this.wallContent = content;
  }

  public Wallable getWallContent() {
    return this.wallContent;
  }

  @Override
  public String toString() {
    return "Wall";
  }
}
