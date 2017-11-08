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
    private List<Car> cars = new ArrayList<>();

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
        this.upperCorner = new Position(width,height);
    }


    @Override
    public boolean canMoveTo(Position position) {
        return position.smaller(upperCorner) && position.larger(lowerCorner) && !this.isOccupied(position);
    }

    @Override
    public boolean place(Car car) {
        if(isOccupied(car.getPosition())) return false;
        this.cars.add(car);
        System.out.println("Dodaje auto");
        return true;
    }

    @Override
    public void run(MoveDirection[] directions) {
        int whichCar=0;
        System.out.println(this.toString());
        if(this.cars.size()>0) {
            for (MoveDirection direction : directions) {
                Car newCar = new Car(this.cars.get(whichCar % this.cars.size()).getPosition(), this.cars.get(whichCar % this.cars.size()).getMapDirection());
                newCar.move(direction);
                if (this.canMoveTo(newCar.getPosition())) this.cars.get(whichCar % this.cars.size()).move(direction);
                whichCar++;
            }
        }
        System.out.println(this.toString());
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

    @Override
    public String toString() {
        return new MapVisualizer().dump(this, this.lowerCorner, this.upperCorner);
    }
}
