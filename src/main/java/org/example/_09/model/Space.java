package org.example._09.model;

public record Space(int size, String value) {

    public boolean isFile() {
        return !value.equals(".");
    }

    @Override
    public String toString() {
        return "SPACE [size = " + size + ", value = " + value + "]";
    }

    public Integer getValueDefault() {
        return isFile() ? Integer.parseInt(value) : 0;
    }

    public static Space buildEmptySpaceWithSize(int size) {
        return new Space(size, ".");
    }
}
