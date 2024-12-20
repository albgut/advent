package org.example._08;

import org.example._08.model.Grid;

import java.util.Arrays;
import java.util.List;

import static org.example._08.model.Grid.buildGridFromString;
import static org.example.utils.InputReader.getStringFromFilePath;
import static org.example.utils.InputReader.getStringListFromFilePath;

public class Decoder {

    public static long decode(String inputFileName) {
        List<List<String>> rawInput = getStringListFromFilePath(inputFileName);
        Grid grid = buildGridFromString(rawInput);

        grid.getAntiNodesCoordinates().stream().map(coordinate -> coordinate.i() + "," + coordinate.j())
                .reduce((s1, s2) -> String.join(" | ", s1, s2))
                .ifPresent(System.out::println);

        return grid.getAntiNodesCoordinates().size();
    }

    public static long decodeSecondPart(String inputFileName) {
        List<List<String>> rawInput = getStringListFromFilePath(inputFileName);
        Grid grid = buildGridFromString(rawInput);

        grid.getAntiNodesCoordinatesAll().stream().map(coordinate -> coordinate.i() + "," + coordinate.j())
                .reduce((s1, s2) -> String.join(" | ", s1, s2))
                .ifPresent(System.out::println);

        return grid.getAntiNodesCoordinatesAll().size();
    }
}
