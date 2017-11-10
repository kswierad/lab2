package agh.cs.lab2;

import java.util.List;

/**
 * Created by Kamil on 2017-11-08.
 */
public class UnboundedMap extends AbstractWorldMap{

    public final List<HayStack> hayStacks;

    public UnboundedMap(List<HayStack> hayStacks) {
        this.hayStacks = hayStacks;
    }
    @Override
    public Object objectAt(Position position) {
        for(Car car : this.cars){
            if(car.getPosition().equals(position)) return car;

        }

        for(HayStack hayStack : this.hayStacks){
            if(hayStack.getPosition().equals(position)) return hayStack;
        }
        return null;
    }

    @Override
    public boolean canMoveTo(Position position) {
        return !this.isOccupied(position);
    }

    @Override
    public String toString(){
        Position lowerCorner, upperCorner;
        lowerCorner = upperCorner = cars.get(0).getPosition();
        for (Car car : cars){
            if(car.getPosition().smaller(lowerCorner)) lowerCorner = car.getPosition();
            if(car.getPosition().larger(upperCorner)) upperCorner = car.getPosition();
        }

        for (HayStack hayStack : hayStacks){
            if (hayStack.getPosition().smaller(lowerCorner)) lowerCorner = hayStack.getPosition();
            if (hayStack.getPosition().larger(upperCorner)) upperCorner = hayStack.getPosition();
        }
        return new MapVisualizer().dump(this, lowerCorner, upperCorner);
    }


}
