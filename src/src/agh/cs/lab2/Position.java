package agh.cs.lab2;

import javafx.geometry.Pos;

/**
 * Created by Kamil on 2017-10-16.
 */
public class Position {


    public final int x;
    public final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        String result;
        result = String.format("(%d,%d)", this.x, this.y);
        return result;
    }

    public boolean smaller(Position operand) {
        return this.x < operand.x && this.y < operand.y;
    }

    public boolean larger(Position operand) {
        return this.x > operand.x && this.y > operand.y;
    }

    public Position add(Position operand) {
        return new Position(this.x + operand.x, this.y + operand.y);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        return y == position.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
