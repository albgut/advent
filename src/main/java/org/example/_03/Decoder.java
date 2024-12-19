package org.example._03;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import static org.example.utils.InputReader.getStringFromFilePath;

public class Decoder {

    private static final Pattern PATTERN_MUL = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)");
    private static final Pattern PATTERN_DONT = Pattern.compile("don't\\(\\)");
    private static final Pattern PATTERN_DO = Pattern.compile("do\\(\\)");

    public static int decode(String inputFileName) {
        String rawInput = getStringFromFilePath(inputFileName);
        return findAndComputeFromString(rawInput);
    }

    public static int decodeSecondPart(String inputFileName) {
        String rawInput = getStringFromFilePath(inputFileName);

        List<String> finalListToCompute = getCuttedList(rawInput);

        return IntStream.range(0, finalListToCompute.size())
                .filter(x -> x % 2 == 0)
                .map(i -> findAndComputeFromString(finalListToCompute.get(i)))
                .sum();
    }

    @NotNull
    private static List<String> getCuttedList(String rawInput) {
        List<String> finalListToCompute = new ArrayList<>();
        String currentInput = rawInput;
        Pattern currentPattern = PATTERN_DONT;
        List<String> resultCut;
        do {
            resultCut = cutInPart(currentInput, currentPattern);
            finalListToCompute.add(resultCut.get(0));
            currentInput = resultCut.get(resultCut.size() - 1);
            currentPattern = currentPattern.equals(PATTERN_DONT) ? PATTERN_DO : PATTERN_DONT;
        } while(resultCut.size() != 1);
        return finalListToCompute;
    }

    private static List<String> cutInPart(String newInput, Pattern nextPattern) {
        Matcher matcher = nextPattern.matcher(newInput);
        int indexNextString = newInput.length();
        if (matcher.find()) {
            indexNextString = matcher.start();
        }
        return indexNextString == newInput.length() ? List.of(newInput) :
                List.of(newInput.substring(0, indexNextString), newInput.substring(indexNextString));
    }

    private static int findAndComputeFromString(String rawInput) {
        Matcher matcher = PATTERN_MUL.matcher(rawInput);
        int result = 0;
        while (matcher.find()) {
            result += extractAndCompute(matcher.group());
        }
        return result;
    }

    private static int extractAndCompute(String mult) {
        int indexMiddle = mult.indexOf(',');
        int firstExtracted = Integer.parseInt(mult.substring(4, indexMiddle));
        int secondExtracted = Integer.parseInt(mult.substring(indexMiddle + 1, mult.length() - 1));
        return firstExtracted * secondExtracted;
    }
}
