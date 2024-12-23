package org.example._12;

import org.example._12.model.Grid;

import java.util.List;

import static org.example._12.model.Grid.buildGridFromString;
import static org.example.utils.InputReader.getStringListFromFilePath;

public class Decoder {

    public static long decode(String inputFileName) {
        List<List<String>> rawInput = getStringListFromFilePath(inputFileName);
        Grid grid = buildGridFromString(rawInput);
        return grid.computePrice();
    }

    public static long decodeSecondPart(String inputFileName) {
        return 0L;
    }
}
