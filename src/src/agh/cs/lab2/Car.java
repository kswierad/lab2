package agh.cs.lab2;

/**
 * Created by Kamil on 2017-10-26.
 */
public class Car {
    private MapDirection mapDirection;
    private Position position;
    public Car(){
        this.mapDirection = MapDirection.North;
        this.position = new Position(2,2);
    }

    public void move(MoveDirection direction){
        switch (direction){
            case Left:
                this.mapDirection = this.mapDirection.previous();
                break;
            case Right:
                this.mapDirection = this.mapDirection.next();
                break;
            case Forward:
                switch (this.mapDirection){
                    case North:
                        if(this.position.y<4) this.position = new Position(this.position.x, this.position.y+1);
                        break;
                    case South:
                        if(this.position.y>0) this.position = new Position(this.position.x, this.position.y-1);
                        break;
                    case East:
                        if(this.position.x<4) this.position = new Position(this.position.x+1, this.position.y);
                        break;
                    case West:
                        if(this.position.x>0) this.position = new Position(this.position.x-1, this.position.y);
                        break;
                }
                break;
            case Backward:
                switch (this.mapDirection){
                    case North:
                        if(this.position.y>0) this.position = new Position(this.position.x, this.position.y-1);
                        break;
                    case South:
                        if(this.position.y<4) this.position = new Position(this.position.x, this.position.y+1);
                        break;
                    case East:
                        if(this.position.x>0) this.position = new Position(this.position.x-1, this.position.y);
                        break;
                    case West:
                        if(this.position.x<4) this.position = new Position(this.position.x+1, this.position.y);
                        break;
                }
                break;
        }
    }

    @Override
    public String toString(){
        return "Pozycja samochodu to "+this.position.toString()+", a orientacja to "+this.mapDirection.toString();
    }
}
