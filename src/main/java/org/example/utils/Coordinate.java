package org.example.utils;

public record Coordinate(int i, int j) {
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
