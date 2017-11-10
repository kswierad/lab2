package agh.cs.lab2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kamil on 2017-11-08.
 */
public abstract class AbstractWorldMap implements IWorldMap {

    protected List<Car> cars = new ArrayList<>();

    @Override
    public abstract boolean canMoveTo(Position position);

    @Override
    public boolean place(Car car) {
        if(isOccupied(car.getPosition())) return false;
        this.cars.add(car);
        return true;
    }

    @Override
    public void run(MoveDirection[] directions) {
        int whichCar=0;
        System.out.println(this);
        if(this.cars.size()>0) {
            for (MoveDirection direction : directions) {
                this.cars.get(whichCar % this.cars.size()).move(direction);
                whichCar++;
            }
        }
        System.out.println(this);
    }
    @Override
    public boolean isOccupied(Position position) {
        if(this.objectAt(position)!=null) return true;
        return false;
    }


    @Override
    public abstract Object objectAt(Position position);


}
