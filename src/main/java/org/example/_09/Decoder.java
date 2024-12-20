package org.example._09;

import org.example.utils.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.example.utils.CollectionUtils.allButFirst;
import static org.example.utils.CollectionUtils.buildConcatList;
import static org.example.utils.InputReader.getStringFromFilePath;

public class Decoder {

    public static long decode(String inputFileName) {
        List<Integer> inputList = Arrays.stream(getStringFromFilePath(inputFileName).split(""))
                .map(Integer::parseInt)
                .toList();
        List<Integer> rawFileIds = buildRawFileIds(inputList);
        rawFileIds.forEach(System.out::print);
        List<Integer> tartiflette = computeResult(inputList, rawFileIds);
        System.out.println();
        tartiflette.forEach(System.out::print);
        return getResultInt(tartiflette);
    }

    private static long getResultInt(List<Integer> integerList) {
        return IntStream.range(0, integerList.size())
                .map(index -> index * integerList.get(index))
                .sum();
    }

    private static List<Integer> computeResult(List<Integer> inputList, List<Integer> rawFileIds) {
        return computeResultRec(inputList, rawFileIds, true);
    }

    private static List<Integer> computeResultRec(List<Integer> inputList, List<Integer> rawFileIds, boolean isPair) {
        if (inputList.isEmpty()) {
            return List.of();
        } else {
            if (isPair) {
                return buildConcatList(
                        rawFileIds.subList(0, Math.min(rawFileIds.size(), inputList.getFirst())),
                        computeResultRec(allButFirst(inputList), rawFileIds.subList(Math.min(rawFileIds.size(), inputList.getFirst()), rawFileIds.size()), false)
                );
            } else {
                return buildConcatList(
                        rawFileIds.subList(Math.max(0, rawFileIds.size() - inputList.getFirst()), rawFileIds.size()).reversed(),
                        computeResultRec(allButFirst(inputList), rawFileIds.subList(0, Math.max(0, rawFileIds.size() - inputList.getFirst())), true)
                );
            }
        }
    }

    private static List<Integer> buildRawFileIds(List<Integer> inputList) {
        return IntStream.range(0, inputList.size() / 2 + 1)
                .mapToObj(index -> buildFileId(inputList, index))
                .reduce(CollectionUtils::buildConcatList)
                .orElse(List.of());
    }

    private static List<Integer> buildFileId(List<Integer> inputList, int index) {
        return IntStream.range(0, inputList.get(index * 2))
                .map(operand -> index)
                .boxed().toList();
    }

    public static long decodeSecondPart(String inputFileName) {
        getStringFromFilePath(inputFileName);
        return 0;
    }
}
