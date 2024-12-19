package org.example._01;

import org.example.utils.Pair;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static org.example.utils.InputReader.getStringFromFilePath;

public class Decoder {

    public static int decode(String inputFileName) {
        String rawInput = getStringFromFilePath(inputFileName);
        List<Pair> pairList = Arrays.stream(rawInput.split("\r\n"))
                .filter(x -> !x.isBlank())
                .map(x -> Pair.buildFromList(x.split("   ")))
                .toList();

        List<Integer> leftList = pairList.stream().map(Pair::a).sorted().toList();
        List<Integer> rightList = pairList.stream().map(Pair::b).sorted().toList();

        return computeDifference(pairList, leftList, rightList);
    }

    public static int decodeSecondPart(String inputFileName) {
        String rawInput = getStringFromFilePath(inputFileName);
        List<Pair> pairList = Arrays.stream(rawInput.split("\r\n"))
                .filter(x -> !x.isBlank())
                .map(x -> Pair.buildFromList(x.split("   ")))
                .toList();

        List<Integer> leftList = pairList.stream().map(Pair::a).sorted().toList();
        List<Integer> rightList = pairList.stream().map(Pair::b).sorted().toList();

        return computeSimilarity(pairList, leftList, rightList);
    }

    @NotNull
    private static Integer computeDifference(List<Pair> pairList, List<Integer> leftList, List<Integer> rightList) {
        return IntStream.range(0, pairList.size())
                .boxed()
                .map(i -> Math.abs(leftList.get(i) - rightList.get(i)))
                .reduce(Integer::sum).orElse(0);
    }

    private static Integer computeSimilarity(List<Pair> pairList, List<Integer> leftList, List<Integer> rightList) {
        return IntStream.range(0, pairList.size())
                .boxed()
                .map(i -> Math.abs(leftList.get(i) * rightList.stream().filter(x -> Objects.equals(x, leftList.get(i))).count()))
                .map(Long::intValue)
                .reduce(Integer::sum).orElse(0);
    }
}
