package org.example._11;

import com.google.inject.Key;
import org.example._11.model.Pair;

import java.util.*;

import static org.example.utils.InputReader.getStringFromFilePath;

public class Decoder {

    private final Map<Pair, Long> memory = new HashMap<>();

    public static long decode(String inputFileName) {
        List<Long> currentInput = Arrays.stream(getStringFromFilePath(inputFileName).split(" ")).map(Long::parseLong).toList();
        for (int i = 0; i < 25; i++) {
            currentInput = currentInput.parallelStream()
                    .map(Decoder::blink)
                    .flatMap(Collection::stream)
                    .toList();
            System.out.println("parcours n°" + i + " : " + currentInput.size());
        }
        return currentInput.size();
    }

    private static List<Long> blink(Long stoneValue) {
        if (stoneValue == 0) {
            return List.of(1L);
        } else if (String.valueOf(stoneValue).length() % 2 == 0) {
            String currentLong = String.valueOf(stoneValue);
            long leftSide = Long.parseLong(currentLong.substring(0, currentLong.length() / 2));
            long rightSide = Long.parseLong(currentLong.substring(currentLong.length() / 2));
            return List.of(leftSide, rightSide);
        } else {
            return List.of(2024 * stoneValue);
        }
    }

    private long blinkSecondVersion(Long stoneValue) {
        if (stoneValue == 0) {
            return 1;
        } else if (String.valueOf(stoneValue).length() % 2 == 0) {
            String currentLong = String.valueOf(stoneValue);
            long leftSide = Long.parseLong(currentLong.substring(0, currentLong.length() / 2));
            long rightSide = Long.parseLong(currentLong.substring(currentLong.length() / 2));
            return 0;
        } else {
            return 0;
        }
    }

    public long decodeSecondPart(String inputFileName) {
        long result =  Arrays.stream(getStringFromFilePath(inputFileName).split(" "))
                .mapToLong(Long::parseLong)
                .map(stoneVale -> computeSecondVersion(stoneVale, 75))
                .sum();
        System.out.println(memory.size());
        /*memory.forEach((pair, aLong) ->
                System.out.println(
                        "(stone => " + pair.statueValue() + ", iteration => " + pair.iterationRank() + ") -> value => " + aLong
                )
        );*/
        return result;
    }

    private long computeSecondVersion(long stoneValue, long iterationRank) {
        if (iterationRank == 0) {
            return 1;
        } else {
            Pair key = new Pair(stoneValue, iterationRank);
            if (!memory.containsKey(key)) {
                memory.put(key, countForNumber(stoneValue, iterationRank));
            }
            return memory.get(key);
        }
    }

    private long countForNumber(long stoneValue, long iterationRank) {
        if (stoneValue == 0) {
            return computeSecondVersion(1, iterationRank - 1);
        } else if (String.valueOf(stoneValue).length() % 2 == 0) {
            String currentLong = String.valueOf(stoneValue);
            long leftSide = Long.parseLong(currentLong.substring(0, currentLong.length() / 2));
            long rightSide = Long.parseLong(currentLong.substring(currentLong.length() / 2));
            return computeSecondVersion(leftSide, iterationRank - 1) + computeSecondVersion(rightSide, iterationRank - 1);
        } else {
            return computeSecondVersion(stoneValue * 2024, iterationRank - 1);
        }
    }
}
