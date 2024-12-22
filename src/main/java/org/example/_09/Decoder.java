package org.example._09;

import org.example.utils.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static org.example.utils.CollectionUtils.allButFirst;
import static org.example.utils.CollectionUtils.buildConcatList;
import static org.example.utils.InputReader.getStringFromFilePath;

public class Decoder {

    public static long decode(String inputFileName) {
        List<Integer> inputList = Arrays.stream(getStringFromFilePath(inputFileName).split(""))
                .map(Integer::parseInt)
                .toList();
        List<Integer> rawFileIds = buildRawFileIds(inputList);
//        rawFileIds.forEach(System.out::print);
        List<Integer> tartiflette = computeResult(inputList, rawFileIds);
//        System.out.println();
//        tartiflette.forEach(System.out::print);
        return getResultInt(tartiflette);
    }

    public static long decodeSecondPart(String inputFileName) {
        return DecoderPartTwo.decodeSecondPart(inputFileName);
    }

    static long getResultInt(List<Integer> integerList) {
        return LongStream.range(0, integerList.size())
                .map(index -> index * integerList.get(((int) index)))
                .sum();
    }

    private static List<Integer> computeResult(List<Integer> inputList, List<Integer> rawFileIds) {
        List<Integer> mutableInputList = new ArrayList<>(inputList);
        List<Integer> mutableRawFileIds = new ArrayList<>(rawFileIds);
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = rawFileIds.size();
        boolean isPair = true;

        while (i < j) {
            Integer inputListFirst = mutableInputList.getFirst();
            if (isPair) {
                int minIndex = Math.min(mutableRawFileIds.size(), inputListFirst);
                result.addAll(mutableRawFileIds.subList(0, minIndex));
                mutableInputList.removeFirst();
                for (int n = 0; n < minIndex; n++) {
                    if (!mutableRawFileIds.isEmpty()) {
                        mutableRawFileIds.removeFirst();
                        i++;
                    }
                }
            } else {
                int maxIndex = Math.max(0, mutableRawFileIds.size() - inputListFirst);
                result.addAll(mutableRawFileIds.subList(maxIndex, mutableRawFileIds.size()).reversed());
                mutableInputList.removeFirst();
                for (int m = mutableRawFileIds.size(); m > maxIndex; m--) {
                    if (!mutableRawFileIds.isEmpty()) {
                        j --;
                        mutableRawFileIds.removeLast();
                    }
                }
            }
            isPair = !isPair;
        }
        return result;
    }

    /*private static List<Integer> computeResultRec(List<Integer> inputList, List<Integer> rawFileIds, boolean isPair) {
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
    }*/

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
}
