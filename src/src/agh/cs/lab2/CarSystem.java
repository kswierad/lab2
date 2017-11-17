package agh.cs.lab2;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Kamil on 2017-10-16.
 */
public class CarSystem {

    public static void main(String args[]){

        try{
            System.out.println("System rozpoczyna działanie.");
            MoveDirection[] directions = new OptionsParser().parse(args);

            List<HayStack> hayStacks = new ArrayList<>();
            Map<Position, IMapElement> objectMap = new HashMap<>();
            IWorldMap map = new UnboundedMap(hayStacks);

            hayStacks.add(new HayStack(new Position(-4,-4),map));
            hayStacks.add(new HayStack(new Position(7,7),map));
            hayStacks.add(new HayStack(new Position(3,6),map));
            hayStacks.add(new HayStack(new Position(2,0),map));

            map.place(new Car(map));
            map.place(new Car(map,3,4));
            map.run(directions);
            System.out.print("System kończy działanie.");
        } catch(IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }


}
