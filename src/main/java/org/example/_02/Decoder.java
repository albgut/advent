package org.example._02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;

import static org.example.utils.InputReader.getStringFromFilePath;

public class Decoder {

    public static int decode(String inputFileName) {
        String rawInput = getStringFromFilePath(inputFileName);
        return Arrays.stream(rawInput.split("\r\n"))
                .map(x -> Arrays.stream(x.split(" "))
                        .map(Integer::parseInt)
                        .toList())
                .mapToInt(Decoder::ifSafeSetToOne)
                .sum();
    }

    public static int decodeSecondPart(String inputFileName) {
        String rawInput = getStringFromFilePath(inputFileName);

        return Arrays.stream(rawInput.split("\r\n"))
                .map(x -> Arrays.stream(x.split(" "))
                        .map(Integer::parseInt)
                        .toList())
                .mapToInt(Decoder::ifSafeWithOneLessSetToOne)
                .sum();
    }

    private static int ifSafeWithOneLessSetToOne(List<Integer> reports) {
        boolean isSafe = isSafe(reports);
        boolean isSafeForOneLess = buildAllListWithOneElementLeft(reports).stream()
                .map(Decoder::isSafe)
                .reduce(Boolean::logicalOr).orElse(false);
        return isSafe || isSafeForOneLess ? 1 : 0;
    }

    private static List<List<Integer>> buildAllListWithOneElementLeft(List<Integer> baseList) {
        List<List<Integer>> baseResult = new ArrayList<>();
        for (int i = 0; i < baseList.size(); i++) {
            List<Integer> currentList = new ArrayList<>(baseList);
            currentList.remove(i);
            baseResult.add(currentList);
        }
        return baseResult;
    }

    private static int ifSafeSetToOne(List<Integer> reports) {
        return isSafe(reports) ? 1 : 0;
    }

    private static boolean isSafe(List<Integer> reports) {
        boolean isClose = IntStream.range(0, reports.size() - 1)
                .boxed()
                .allMatch(i -> Math.abs(reports.get(i) - reports.get(i + 1)) <= 3);

        boolean isCroissant = IntStream.range(0, reports.size() - 1)
                .boxed()
                .allMatch(i -> reports.get(i) < reports.get(i + 1));

        boolean isDecroissant = IntStream.range(0, reports.size() - 1)
                .boxed()
                .allMatch(i -> reports.get(i) > reports.get(i + 1));

        return isClose && (isCroissant || isDecroissant);
    }
}
