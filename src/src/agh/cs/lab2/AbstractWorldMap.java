package agh.cs.lab2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kamil on 2017-11-08.
 */
public abstract class AbstractWorldMap implements IWorldMap {

    protected List<Car> cars = new ArrayList<>();
    protected Map<Position, IMapElement> objectMap = new HashMap<>();
    @Override
    public abstract boolean canMoveTo(Position position);

    @Override
    public void place(Car car) {
        if(isOccupied(car.getPosition())) {
            throw new IllegalArgumentException("Nie można dodać obiektu w miejsce: "+car.getPosition()+", ponieważ jest już zajęte.");
        }
        this.cars.add(car);
        this.objectMap.put(car.getPosition(),car);
    }

    @Override
    public void run(MoveDirection[] directions) {
        int whichCar=0;
        System.out.println(this);
        if(this.cars.size()>0) {
            for (MoveDirection direction : directions) {
                Car localCar = this.cars.get(whichCar % this.cars.size());
                Position oldPosition = localCar.getPosition();
                localCar.move(direction);
                if(!localCar.getPosition().equals(oldPosition)){
                    this.objectMap.remove(oldPosition);
                    this.objectMap.put(localCar.getPosition(),localCar);
                }
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
    public Object objectAt(Position position) {
        return this.objectMap.get(position);
    }

}
