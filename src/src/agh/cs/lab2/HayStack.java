package agh.cs.lab2;

/**
 * Created by Kamil on 2017-11-08.
 */
public class HayStack implements IMapElement{
    public final Position position;

    public HayStack(Position position) {
        this.position = position;
    }

    public Position getPosition(){ return this.position; }

    @Override
    public String toString() {
        return "s";
    }
}
