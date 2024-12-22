package org.example._10;

import org.example._10.model.Grid;

import java.util.Arrays;
import java.util.List;

import static org.example._10.model.Grid.buildGridFromString;
import static org.example.utils.InputReader.getStringListFromFilePath;

public class Decoder {

    public static long decode(String inputFileName) {
        List<List<String>> rawInput = getStringListFromFilePath(inputFileName);
        Grid grid = buildGridFromString(rawInput);
        return grid.countTrailHead();
    }

    public static long decodeSecondPart(String inputFileName) {
        List<List<String>> rawInput = getStringListFromFilePath(inputFileName);
        Grid grid = buildGridFromString(rawInput);
        return grid.countTrailHeadAll();
    }
}
