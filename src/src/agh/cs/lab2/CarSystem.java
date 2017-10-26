package agh.cs.lab2;

/**
 * Created by Kamil on 2017-10-16.
 */
public class CarSystem {

    public static void main(String args[]){
        System.out.println("System rozpoczyna działanie.");
        CarSystem.run();
        Car car = new Car();
        OptionsParser parser = new OptionsParser();
        for(MoveDirection direction : parser.parse(args)){
            car.move(direction);
        }
        System.out.println(car.toString());
        System.out.print("System kończy działanie.");

    }


    public static void run(){
        System.out.println("Samochód zaczyna się poruszać.");


    }
}
