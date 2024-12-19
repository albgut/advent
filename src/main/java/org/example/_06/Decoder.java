package org.example._06;

import org.example._06.model.Grid;

import java.util.List;

import static org.example._06.model.Grid.buildGridFromString;
import static org.example.utils.InputReader.getStringListFromFilePath;

public class Decoder {
    public static int decode(String inputFileName) {
        List<List<String>> rawInput = getStringListFromFilePath(inputFileName);
        Grid grid = buildGridFromString(rawInput);
        return grid.travel();
    }

    public static int decodeSecondPart(String inputFileName) {
        List<List<String>> rawInput = getStringListFromFilePath(inputFileName);
        Grid grid = buildGridFromString(rawInput);
        return grid.computeInfinityForAll();
    }
}
