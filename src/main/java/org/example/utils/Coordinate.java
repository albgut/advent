package org.example.utils;

import java.util.List;

public record Coordinate(int i, int j) {
    public List<Coordinate> getNeighbour() {
        return List.of(
                new Coordinate(i - 1, j),
                new Coordinate(i, j + 1),
                new Coordinate(i + 1, j),
                new Coordinate(i, j - 1)
        );
    }

    @Override
    public String toString() {
        return i + "," + j;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Coordinate(int i1, int j1)) {
            return i1 == this.i && j1 == this.j;
        }
        return false;
    }
}
