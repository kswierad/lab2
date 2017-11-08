package agh.cs.lab2;

/**
 * Created by Kamil on 2017-10-16.
 */
public enum MoveDirection {
    Forward,
    Backward,
    Left,
    Right;

    @Override
    public String toString() {
        switch (this) {
            case Forward:
                return "f";
            case Backward:
                return "b";
            case Left:
                return "l";
            case Right:
                return "r";
        }
        return null;
    }
}
