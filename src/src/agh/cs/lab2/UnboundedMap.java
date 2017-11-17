package agh.cs.lab2;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kamil on 2017-11-08.
 */
public class UnboundedMap extends AbstractWorldMap{

    public final List<HayStack> hayStacks;




    public UnboundedMap(List<HayStack> hayStacks) {

        this.hayStacks = hayStacks;
        for(HayStack element : hayStacks){
            this.objectMap.put(element.getPosition(),element);
        }
    }


    @Override
    public boolean canMoveTo(Position position) {
        return !this.isOccupied(position);
    }

    @Override
    public String toString(){
        Position lowerCorner, upperCorner;
        lowerCorner = upperCorner = cars.get(0).getPosition();
        Collection<IMapElement> elements = this.objectMap.values();
        for(IMapElement element : elements){
            if(element.getPosition().smaller(lowerCorner)) lowerCorner = element.getPosition();
            if(element.getPosition().larger(upperCorner)) upperCorner = element.getPosition();
        }
        return new MapVisualizer().dump(this, lowerCorner, upperCorner);
    }


}
