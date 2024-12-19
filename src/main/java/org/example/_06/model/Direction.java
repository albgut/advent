package org.example._06.model;

import org.example.utils.Coordinate;

public enum Direction {
    NORD,
    OUEST,
    EST,
    SUD;

    public Coordinate nextCoordonatetoMove(Coordinate initialCoordinate) {
        switch (this) {
            case NORD -> {
                return new Coordinate(initialCoordinate.i() - 1, initialCoordinate.j());
            }
            case OUEST -> {
                return new Coordinate(initialCoordinate.i(), initialCoordinate.j() - 1);
            }
            case EST -> {
                return new Coordinate(initialCoordinate.i(), initialCoordinate.j() + 1);
            }
            case SUD -> {
                return new Coordinate(initialCoordinate.i() + 1, initialCoordinate.j());
            }
            default -> throw new RuntimeException();
        }
    }

    public Direction turnRight() {
        switch (this) {
            case NORD -> {
                return EST;
            }
            case OUEST -> {
                return NORD;
            }
            case EST -> {
                return SUD;
            }
            case SUD -> {
                return OUEST;
            }
            default -> throw new RuntimeException();
        }
    }
}
