package Backend.Enums;

import Backend.GameTools.Wall;

public enum Directions {

     NORTH,EAST,SOUTH,WEST;

    public int asInt;
    Directions() {
        this.asInt = ordinal();
    }
    public static Directions getOppositeDirection(Directions direction){
        switch (direction) {
            case NORTH:
                return SOUTH;
            case EAST:
                return WEST;
            case WEST:
                return EAST;
            case SOUTH:
                return NORTH;
        }
        throw new IllegalArgumentException();
    }

}
