package agh.cs.lab2;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Kamil on 2017-10-16.
 */
public class CarSystem {

    public static void main(String args[]){
        System.out.println("System rozpoczyna działanie.");
        MoveDirection[] directions = new OptionsParser().parse(args);
        List<HayStack> hayStacks = new ArrayList<>();
        hayStacks.add(new HayStack(new Position(-4,-4)));
        hayStacks.add(new HayStack(new Position(7,7)));
        hayStacks.add(new HayStack(new Position(3,6)));
        hayStacks.add(new HayStack(new Position(2,0)));
        IWorldMap map = new UnboundedMap(hayStacks);
        map.place(new Car(map));
        map.place(new Car(map,3,4));
        map.run(directions);
        System.out.print("System kończy działanie.");

    }


}
