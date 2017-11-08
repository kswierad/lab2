package agh.cs.lab2;

/**
 * Created by Kamil on 2017-10-16.
 */
public class CarSystem {

    public static void main(String args[]){
        System.out.println("System rozpoczyna działanie.");
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        if(!map.place(new Car(map))) { System.out.println("Nie dodaje"); }
        if(!map.place(new Car(map,3,4))) { System.out.println("Nie dodaje"); }

        map.run(directions);
        System.out.print("System kończy działanie.");

    }


}
