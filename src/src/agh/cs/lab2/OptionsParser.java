package agh.cs.lab2;

/**
 * Created by Kamil on 2017-10-26.
 */
public class OptionsParser {

    public MoveDirection[] parse(String args[]){
        int numberOfArgs = 0;
        MoveDirection[] parsedArgs = new MoveDirection[args.length];
        for(String arg : args){
                switch (arg){
                    case "forward":
                        parsedArgs[numberOfArgs] = MoveDirection.Forward;
                        numberOfArgs++;
                        break;
                    case "f":
                        parsedArgs[numberOfArgs] = MoveDirection.Forward;
                        numberOfArgs++;
                        break;
                    case "backward":
                        parsedArgs[numberOfArgs] = MoveDirection.Backward;
                        numberOfArgs++;
                        break;
                    case "b":
                        parsedArgs[numberOfArgs] = MoveDirection.Backward;
                        numberOfArgs++;
                        break;
                    case "left":
                        parsedArgs[numberOfArgs] = MoveDirection.Left;
                        numberOfArgs++;
                        break;
                    case "l":
                        parsedArgs[numberOfArgs] = MoveDirection.Left;
                        numberOfArgs++;
                        break;
                    case "right":
                        parsedArgs[numberOfArgs] = MoveDirection.Right;
                        numberOfArgs++;
                        break;
                    case "r":
                        parsedArgs[numberOfArgs] = MoveDirection.Right;
                        numberOfArgs++;
                        break;
                    default:
                        break;
                }

        }
        return parsedArgs;
    }
}
