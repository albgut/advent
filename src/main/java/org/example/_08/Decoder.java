package org.example._08;

import java.util.Arrays;
import java.util.List;

import static org.example.utils.InputReader.getStringFromFilePath;

public class Decoder {

    public static long decode(String inputFileName) {
        List<String> lines = Arrays.stream(getStringFromFilePath(inputFileName).split("\r\n")).toList();
        return lines.stream().map(Decoder::computeLine).reduce(Long::sum).orElse(0L);
    }

    public static long decodeSecondPart(String inputFileName) {
        List<String> lines = Arrays.stream(getStringFromFilePath(inputFileName).split("\r\n")).toList();
        return lines.stream().map(Decoder::computeLineThreeOperators).reduce(Long::sum).orElse(0L);
    }

    private static long computeLine(String line) {
        String[] rawInputSections = line.split(": ");
        long result = Long.parseLong(rawInputSections[0]);
        List<Long> numbersToCompute = Arrays.stream(rawInputSections[1].split(" "))
                .map(Long::parseLong).toList();
        return isComputable(result, numbersToCompute, 0) ? result : 0;
    }

    private static long computeLineThreeOperators(String line) {
        String[] rawInputSections = line.split(": ");
        long result = Long.parseLong(rawInputSections[0]);
        List<Long> numbersToCompute = Arrays.stream(rawInputSections[1].split(" "))
                .map(Long::parseLong).toList();
        return isComputableThreeOperators(result, numbersToCompute, 0) ? result : 0;
    }

    private static boolean isComputableThreeOperators(long result, List<Long> numbersToCompute, long currentValue) {
        if(numbersToCompute.isEmpty()){
            return result == currentValue;
        }
        return isComputableThreeOperators(result, numbersToCompute.subList(1, numbersToCompute.size()), currentValue + numbersToCompute.get(0)) ||
                isComputableThreeOperators(result, numbersToCompute.subList(1, numbersToCompute.size()), currentValue * numbersToCompute.get(0)) ||
                isComputableThreeOperators(result, numbersToCompute.subList(1, numbersToCompute.size()), concatLong(currentValue, numbersToCompute.get(0)));
    }

    private static long concatLong(long concatNumber1, long concatNumber2) {
        return Long.parseLong(String.valueOf(concatNumber1) + concatNumber2);
    }

    private static boolean isComputable(long result, List<Long> numbersToCompute, long currentValue) {
        if(numbersToCompute.isEmpty()){
            return result == currentValue;
        }
        return isComputable(result, numbersToCompute.subList(1, numbersToCompute.size()), currentValue + numbersToCompute.get(0)) ||
                isComputable(result, numbersToCompute.subList(1, numbersToCompute.size()), currentValue * numbersToCompute.get(0));
    }
}
