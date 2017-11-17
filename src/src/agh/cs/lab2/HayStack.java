package agh.cs.lab2;

/**
 * Created by Kamil on 2017-11-08.
 */
public class HayStack implements IMapElement{
    public final Position position;


    public HayStack(Position position, IWorldMap map) {
        if(map.isOccupied(position)) throw new IllegalArgumentException("Nie można dodać obiektu w miejsce: "+position+", ponieważ jest już zajęte.");
        this.position = position;

    }

    public Position getPosition(){ return this.position; }

    @Override
    public String toString() {
        return "s";
    }
}
