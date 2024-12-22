package org.example._10.model;

import org.example.utils.Coordinate;

import java.util.HashSet;
import java.util.Set;

public class GridElement {
    private final Coordinate coordinate;
    private final int value;
    private final Set<Coordinate> zeroReacher;

    public GridElement(Coordinate coordinate, int value) {
        this.coordinate = coordinate;
        this.value = value;
        this.zeroReacher = new HashSet<>();
    }

    public boolean addZeroReacher(Coordinate coordinate) {
        return zeroReacher.add(coordinate);
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public int getValue() {
        return value;
    }
}
