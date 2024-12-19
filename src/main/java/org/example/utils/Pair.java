package org.example.utils;

import static java.lang.Integer.parseInt;

public record Pair(int a, int b) {
    public static Pair buildFromList(String[] strings) {
        return new Pair(parseInt(strings[0]), parseInt(strings[1]));
    }
}
