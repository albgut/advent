package org.example._05;

import org.example.utils.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.example.utils.InputReader.getStringFromFilePath;

public class Decoder {

    public static int decode(String inputFileName) {
        String rawInput = getStringFromFilePath(inputFileName);
        String[] sections = rawInput.split("\r\n\r\n");
        List<Pair> pairList = Arrays.stream(sections[0].split("\r\n"))
                .filter(x -> !x.isBlank())
                .map(x -> Pair.buildFromList(x.split("\\|")))
                .toList();
        List<List<Integer>> buildOrder = Arrays.stream(sections[1].split("\r\n"))
                .filter(x -> !x.isBlank())
                .map(x -> Arrays.stream(x.split(",")).map(Integer::parseInt).toList())
                .toList();

        return buildOrder.stream().filter(x -> isValid(x, pairList))
                .map(Decoder::takeMiddle)
                .reduce(Integer::sum).orElse(0);
    }

    public static int decodeSecondPart(String inputFileName) {
        String rawInput = getStringFromFilePath(inputFileName);
        String[] sections = rawInput.split("\r\n\r\n");
        List<Pair> pairList = Arrays.stream(sections[0].split("\r\n"))
                .filter(x -> !x.isBlank())
                .map(x -> Pair.buildFromList(x.split("\\|")))
                .toList();
        List<List<Integer>> buildOrder = Arrays.stream(sections[1].split("\r\n"))
                .filter(x -> !x.isBlank())
                .map(x -> Arrays.stream(x.split(",")).map(Integer::parseInt).toList())
                .toList();

        return buildOrder.stream().filter(x -> !isValid(x, pairList))
                .map(x -> restoreOrder(x, pairList))
                .map(Decoder::takeMiddle)
                .reduce(Integer::sum).orElse(0);
    }

    private static List<Integer> restoreOrder(List<Integer> integers, List<Pair> pairList) {
        List<Integer> resultList = new ArrayList<>(integers);
        for (int i = 0; i < resultList.size() - 1; i++) {
            if(!areInGoodPosition(resultList.get(i), pairList, resultList.subList(i + 1, resultList.size()))){
                resultList = goodPositionAndRepare(resultList.get(i), pairList, resultList.subList(i + 1, resultList.size()), resultList);
                //Pour retester au cas où on a créer une nouvelle erreur d'ordre
                i --;
            }
        }
        return resultList;
    }

    private static int takeMiddle(List<Integer> integers) {
        return integers.get(integers.size() / 2);
    }

    private static boolean isValid(List<Integer> integers, List<Pair> pairList) {
        return IntStream.range(0, integers.size())
                .allMatch(x -> areInGoodPosition(integers.get(x), pairList, integers.subList(x + 1, integers.size())));
    }

    private static boolean areInGoodPosition(Integer integer, List<Pair> pairList, List<Integer> followIntegers) {
        return pairList.stream().filter(x -> x.b() == integer)
                .map(Pair::a)
                .noneMatch(followIntegers::contains);
    }

    private static List<Integer> goodPositionAndRepare(Integer integer, List<Pair> pairList, List<Integer> followIntegers, List<Integer> allList) {
        return pairList.stream().filter(x -> x.b() == integer)
                .map(Pair::a)
                .filter(followIntegers::contains)
                .map(integerForbidden -> buildNewGoodList(allList, followIntegers, integerForbidden, integer))
                .toList().get(0);
    }

    private static List<Integer> buildNewGoodList(List<Integer> allList, List<Integer> followIntegers, Integer integerForbidden, Integer integer) {
        List<Integer> resultList = new ArrayList<>(allList);
        int indexOfCurrent = allList.size() - followIntegers.size() - 1;
        int indexOfForbiden = allList.size() - followIntegers.size() + followIntegers.indexOf(integerForbidden);
        resultList.set(indexOfCurrent, integerForbidden);
        resultList.set(indexOfForbiden, integer);
        return resultList;
    }
}
