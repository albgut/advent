package org.example._09;

import org.example._09.model.Space;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.example._09.Decoder.getResultInt;
import static org.example.utils.InputReader.getStringFromFilePath;

public class DecoderPartTwo {

    public static long decodeSecondPart(String inputFileName) {
        List<Integer> inputList = Arrays.stream(getStringFromFilePath(inputFileName).split(""))
                .map(Integer::parseInt)
                .toList();
        List<Space> spaces = buildSpaces(inputList);
        return getResultInt(buildFromSpaces(computeFromSpaces(spaces)));
    }

    private static List<Space> computeFromSpaces(List<Space> spaces) {
        List<Space> result = new ArrayList<>(spaces);
        int j = result.size() - 1;
        while (j > 0) {
            Space currentSpace = result.get(j);
            if (currentSpace.isFile()) {
                int i = 0;
                boolean found = false;
                while (!found && i < j) {
                    Space spaceToFill = result.get(i);
                    if (!spaceToFill.isFile() && spaceToFill.size() >= currentSpace.size()) {
                        int extraSize = spaceToFill.size() - currentSpace.size();
                        result.remove(j);
                        result.add(j, Space.buildEmptySpaceWithSize(currentSpace.size()));
                        result.remove(i);
                        result.add(i, currentSpace);
                        if (extraSize > 0) {
                            result.add(i + 1, Space.buildEmptySpaceWithSize(extraSize));
                        }
                        found = true;
                    }
                    i++;
                }
            }
            j--;
        }
        return result;
    }

    private static List<Integer> buildFromSpaces(List<Space> spaces) {
        return spaces.stream().flatMap(
                space -> IntStream
                        .range(0, space.size())
                        .mapToObj(x -> space.getValueDefault())
        ).toList();
    }

    private static List<String> buildFromSpacesReadable(List<Space> spaces) {
        return spaces.stream().flatMap(
                space -> IntStream
                        .range(0, space.size())
                        .mapToObj(x -> space.value())
        ).toList();
    }

    private static List<Space> buildSpaces(List<Integer> inputList) {
        return IntStream.range(0, inputList.size())
                .mapToObj(index -> index % 2 == 0 ?
                        new Space(inputList.get(index), String.valueOf(index / 2)) : new Space(inputList.get(index), "."))
                .toList();
    }
}
