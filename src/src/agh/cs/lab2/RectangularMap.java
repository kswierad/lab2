package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by student9 on 2017-10-27.
 */
public class RectangularMap extends AbstractWorldMap {

    private final int width;
    private final int height;
    private final Position upperCorner;
    private final Position lowerCorner = new Position(0, 0);


    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.upperCorner = new Position(width, height);
    }


    @Override
    public boolean canMoveTo(Position position) {
        return position.smaller(upperCorner) && position.larger(lowerCorner) && !this.isOccupied(position);
    }

    @Override
    public String toString() {
        return new MapVisualizer().dump(this, this.lowerCorner, this.upperCorner);
    }

    @Override
    public Object objectAt(Position position) {
        return this.objectMap.get(position);
    }
}







