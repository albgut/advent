package org.example._06.model;

import org.example.utils.Coordinate;

public class Guard {
    private Direction direction;
    private Coordinate coordinate;

    public Guard(Direction direction, Coordinate coordinate) {
        this.direction = direction;
        this.coordinate = coordinate;
    }

    public Direction getDirection() {
        return direction;
    }

    public Coordinate getCoordonate() {
        return coordinate;
    }

    public Coordinate getNextCoordonateToMove() {
        return direction.nextCoordonatetoMove(coordinate);
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void move() {
        coordinate = direction.nextCoordonatetoMove(coordinate);
    }

    public Guard clone() {
        return new Guard(direction, new Coordinate(coordinate.i(), coordinate.j()));
    }
}
