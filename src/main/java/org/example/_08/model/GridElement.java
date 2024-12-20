package org.example._08.model;

import org.example.utils.Coordinate;

public class GridElement {
    private final Coordinate coordinate;
    private final String value;

    public GridElement(Coordinate coordinate, String value) {
        this.coordinate = coordinate;
        this.value = value;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public String getValue() {
        return value;
    }

    public boolean isFree() {
        return !value.equals(".");
    }

    public boolean isNotWithValue(String value) {
        return !this.value.equals(value);
    }
}
