package org.example.utils;

public class CoordinateUtils {
    public static boolean isOutOfBound(Coordinate coordinate, int length) {
        return coordinate.j() < 0 || coordinate.j() >= length || coordinate.i() < 0 || coordinate.i() >= length;
    }

    public static boolean isInBound(Coordinate coordinate, int length) {
        return !isOutOfBound(coordinate, length);
    }
}
