package Backend.Items.NullObjects;

import Backend.Interfaces.Wallable;
import Backend.GameTools.Wall;
import Backend.Items.Door;

public class DarkWall extends Wall {

    public DarkWall(){
        super();
        this.setWallContent(new Wallable() {
            @Override
            public String look() {
                return "Dark";
            }
        });

    }
    public static String className(){
        return "Dark "+ Door.className();
    }

}