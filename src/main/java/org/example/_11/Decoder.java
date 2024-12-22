package org.example._11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.example.utils.InputReader.getStringFromFilePath;

public class Decoder {

    public static long decode(String inputFileName) {
        List<Long> currentInput = Arrays.stream(getStringFromFilePath(inputFileName).split(" ")).map(Long::parseLong).toList();
        for (int i = 0; i < 25; i++) {
            currentInput = currentInput.stream()
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

    public static long decodeSecondPart(String inputFileName) {
        List<Long> currentInput = Arrays.stream(getStringFromFilePath(inputFileName).split(" ")).map(Long::parseLong).toList();
        ArrayList<Long> mutableList = new ArrayList<>(currentInput);
        for (int i = 0; i < 75; i++) {
            for (int j = 0; j < mutableList.size(); j++) {
                long current = mutableList.get(j);
                if (current == 0) {
                    mutableList.set(j, 1L);
                } else if (String.valueOf(current).length() % 2 == 0) {
                    String currentLong = String.valueOf(current);
                    long leftSide = Long.parseLong(currentLong.substring(0, currentLong.length() / 2));
                    long rightSide = Long.parseLong(currentLong.substring(currentLong.length() / 2));
                    mutableList.set(j, rightSide);
                    mutableList.add(j, leftSide);
                } else {
                    mutableList.set(j, current * 2024);
                }
            }
            System.out.println("parcours n°" + i + " : " + mutableList.size());
        }
//        System.out.println(currentInput.stream().map(String::valueOf)
//                .reduce((s, s2) -> String.join(" ", s, s2)));
        return currentInput.size();
    }
}
