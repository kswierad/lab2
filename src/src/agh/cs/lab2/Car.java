package agh.cs.lab2;


/**
 * Created by Kamil on 2017-10-26.
 */
public class Car implements IMapElement{
    private MapDirection mapDirection;
    private Position position;
    private IWorldMap map;
    public Car(){
        this.mapDirection = MapDirection.North;
        this.position = new Position(2,2);
    }

    public Car(IWorldMap map){
        this.position = new Position(2,2);
        this.mapDirection = MapDirection.North;
        this.map = map;
    }

    public Car(IWorldMap map, int x, int y){
        this.position = new Position(x,y);
        this.mapDirection = MapDirection.North;
        this.map = map;
    }

    public Position getPosition(){
        return this.position;
    }

    public void move(MoveDirection direction){
        Position newPos = new Position(0,0);
        switch (this.mapDirection){
            case North:
                newPos = new Position(0,1);
                break;
            case South:
                newPos = new Position(0,-1);
                break;
            case East:
                newPos = new Position(1,0);
                break;
            case West:
                newPos = new Position(-1,0);
                break;
        }
        switch (direction){
            case Left:
                this.mapDirection = this.mapDirection.previous();
                break;
            case Right:
                this.mapDirection = this.mapDirection.next();
                break;
            case Forward:
            case Backward:
                if(direction == MoveDirection.Backward) {
                    newPos = new Position(newPos.x*(-1),newPos.y*(-1));
                }
                newPos = newPos.add(this.position);
                if(this.map.canMoveTo(newPos)) {
                    this.position = newPos;
                }
                break;
        }
    }

    @Override
    public String toString(){
        switch (this.mapDirection){
            case North:
                return "↑";
            case South:
                return "↓";
            case East:
                return "→";
            case West:
                return "←";
            default:
                return null;
        }
    }
}
