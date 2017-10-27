package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student9 on 2017-10-27.
 */
public class RectangularMap implements IWorldMap{

    private final int width;
    private final int height;
    private final Position upperCorner;
    private final Position lowerCorner = new Position(0,0);
    List<Car> cars = new ArrayList<>();

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
        this.upperCorner = new Position(width,height);
    }


    @Override
    public boolean canMoveTo(Position position) {
        return position.smaller(upperCorner) && position.larger(lowerCorner);
    }

    @Override
    public boolean place(Car car) {
        if(!isOccupied(car.getPosition())) return false;
        cars.add(car);
        return true;
    }

    @Override
    public void run(MoveDirection[] directions) {

    }

    @Override
    public boolean isOccupied(Position position) {
        for(Car car : this.cars){
            if(car.getPosition().equals(position)) return true;

        }
        return false;
    }

    @Override
    public Object objectAt(Position position) {
        for(Car car : this.cars){
            if(car.getPosition().equals(position)) return car;

        }
        return null;
    }
}
