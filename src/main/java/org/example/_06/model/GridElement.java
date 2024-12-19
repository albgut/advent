package org.example._06.model;

import org.example.utils.Coordinate;

public class GridElement {

    private boolean isPassedIn = false;

    private final boolean isObstacle;

    private final Coordinate coordinate;

    public GridElement(boolean isObstacle, Coordinate coordinate) {
        this.isObstacle = isObstacle;
        this.coordinate = coordinate;
    }

    public boolean isPassedIn() {
        return isPassedIn;
    }

    public void makePassedIn() {
        isPassedIn = true;
    }

    public boolean isObstacle() {
        return isObstacle;
    }

    public Coordinate getCoordonate() {
        return coordinate;
    }
}
