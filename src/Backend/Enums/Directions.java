package Backend.Enums;

public enum Directions {

    NORTH,EAST,SOUTH,WEST;
    public static int getPosInNumbers(Directions direction){
        for (int i=0;i<Directions.values().length;i++) {
            if(Directions.values()[i]==direction) { return i; }
        }

        throw new IndexOutOfBoundsException();
    }

}
