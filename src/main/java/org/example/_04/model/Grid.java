package org.example._04.model;

import org.example.utils.Coordinate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Grid {
    private final String[][] matrixGrid;
    private static final Pattern PATTERN_XMAS = Pattern.compile("XMAS");
    private static final Pattern PATTERN_SAMX = Pattern.compile("SAMX");
    private static final Pattern PATTERN_MAS = Pattern.compile("MAS");
    private static final Pattern PATTERN_SAM = Pattern.compile("SAM");

    private Grid(String[][] matrixGrid) {
        this.matrixGrid = matrixGrid;
    }

    public static Grid buildGridFromString(List<List<String>> listGrid) {
        String[][] arrayGrid = new String[listGrid.size()][listGrid.size()];
        return new Grid(listGrid.stream().map(x -> x.toArray(new String[listGrid.size()])).toList().toArray(arrayGrid));
    }

    public int howManyXMAS() {
        return this.howManyXMASHorizontal() + this.howManyXMASVertical() + this.howManyXMASDiagonal();
    }

    public int howManyMASInX() {
        return loopDiagonallyLeftWithIndex(this.matrixGrid)
                .stream().map(x -> howManyInArrayInX(x, matrixGrid))
                .reduce(Integer::sum).orElse(0);
    }

    private int howManyXMASDiagonal() {
        return howManyXMASDiagonalLeft() + howManyXMASDiagonalRight();
    }

    private int howManyXMASDiagonalLeft() {
        return Arrays.stream(loopDiagonallyLeft(this.matrixGrid).split(" "))
                .map(x -> x.split(""))
                .map(Grid::howManyInArrayAndReverse)
                .reduce(Integer::sum)
                .orElse(0);
    }

    private int howManyXMASDiagonalRight() {
        return Arrays.stream(loopDiagonallyRight(matrixGrid).split(" "))
                .map(x -> x.split(""))
                .map(Grid::howManyInArrayAndReverse)
                .reduce(Integer::sum)
                .orElse(0);
    }

    private int howManyXMASHorizontal() {
        return Arrays.stream(this.matrixGrid)
                .map(Grid::howManyInArrayAndReverse)
                .reduce(Integer::sum)
                .orElse(0);
    }

    private int howManyXMASVertical() {
        String[][] verticalLines = IntStream.range(0, matrixGrid[0].length)
                .mapToObj(i -> Arrays.stream(matrixGrid).map(strings -> strings[i]).toArray(String[]::new))
                .toArray(String[][]::new);
        return Arrays.stream(verticalLines)
                .map(Grid::howManyInArrayAndReverse)
                .reduce(Integer::sum)
                .orElse(0);
    }

    private static int howManyInArrayAndReverse(String[] array) {
        String line = String.join("", array);
        Matcher matchXmas = PATTERN_XMAS.matcher(line);
        Matcher matchSamx = PATTERN_SAMX.matcher(line);
        long result = matchXmas.results().count() + matchSamx.results().count();
        return (int) result;
    }

    private static int howManyInArrayInX(List<InputPair> inputPairList, String[][] matrixGrid) {
        String line = inputPairList.stream().map(InputPair::value).collect(Collectors.joining());
        Matcher matchMas = PATTERN_MAS.matcher(line);
        Matcher matchSam = PATTERN_SAM.matcher(line);
        return (int) (getCountFromMatcher(inputPairList, matchSam, matrixGrid) + getCountFromMatcher(inputPairList, matchMas, matrixGrid));
    }

    private static long getCountFromMatcher(List<InputPair> inputPairList, Matcher matcher, String[][] matrixGrid) {
        List<Integer> integers = new ArrayList<>();
        while (matcher.find()){
            integers.add(matcher.start());
        }
        return integers.stream()
                .map(x -> x + 1)
                .map(inputPairList::get)
                .filter(inputPair ->
                        inputPair.coordinate().i() - 1 >= 0 &&
                                inputPair.coordinate().j() - 1 >= 0 &&
                                inputPair.coordinate().i() + 1 < matrixGrid.length &&
                                inputPair.coordinate().j() + 1 < matrixGrid.length
                )
                .filter(inputPair ->
                        (matrixGrid[inputPair.coordinate().i() - 1][inputPair.coordinate().j() + 1].equals("S") &&
                                matrixGrid[inputPair.coordinate().i() + 1][inputPair.coordinate().j() - 1].equals("M")) ||
                                (matrixGrid[inputPair.coordinate().i() - 1][inputPair.coordinate().j() + 1].equals("M") &&
                                        matrixGrid[inputPair.coordinate().i() + 1][inputPair.coordinate().j() - 1].equals("S"))

                ).count();
    }

    private int unitaryTest(int index, int indexDiag) {

        return 0;
    }

    private String loopDiagonallyRight(String[][] twoDArray) {

        int length = twoDArray.length;
        int diagonalLines = (length + length) - 1;
        int itemsInDiagonal = 0;
        int midPoint = (diagonalLines / 2) + 1;
        StringBuilder output = new StringBuilder();

        for (int i = 1; i <= diagonalLines; i++) {

            StringBuilder items = new StringBuilder();
            int rowIndex;
            int columnIndex;

            if (i <= midPoint) {
                itemsInDiagonal++;
                for (int j = 0; j < itemsInDiagonal; j++) {
                    rowIndex = (i - j) - 1;
                    columnIndex = j;
                    items.append(twoDArray[rowIndex][columnIndex]);
                }
            } else {
                itemsInDiagonal--;
                for (int j = 0; j < itemsInDiagonal; j++) {
                    rowIndex = (length - 1) - j;
                    columnIndex = (i - length) + j;
                    items.append(twoDArray[rowIndex][columnIndex]);
                }
            }

            if (i != diagonalLines) {
                output.append(items).append(" ");
            } else {
                output.append(items);
            }
//            System.out.println(items);
        }

        return output.toString();
    }

    private String loopDiagonallyLeft(String[][] twoDArray) {

        int length = twoDArray.length;
        int diagonalLines = (length + length) - 1;
        int itemsInDiagonal = 0;
        int midPoint = (diagonalLines / 2) + 1;
        StringBuilder output = new StringBuilder();

        for (int i = 1; i <= diagonalLines; i++) {

            StringBuilder items = new StringBuilder();
            int rowIndex;
            int columnIndex;

            List<String> s = new ArrayList<>();
            if (i <= midPoint) {
                itemsInDiagonal++;
                for (int j = 0; j < itemsInDiagonal; j++) {
                    rowIndex = length - i + j;
                    columnIndex = j;
                    s.add(rowIndex + ", " + columnIndex);
                    items.append(twoDArray[rowIndex][columnIndex]);
                }
            } else {
                itemsInDiagonal--;
                for (int j = 0; j < itemsInDiagonal; j++) {
                    rowIndex = j;
                    columnIndex = i - length + j;
                    s.add(rowIndex + ", " + columnIndex);
                    items.append(twoDArray[rowIndex][columnIndex]);
                }
            }
            System.out.println(String.join(" | ", s));

            if (i != diagonalLines) {
                output.append(items).append(" ");
            } else {
                output.append(items);
            }
            System.out.println(items);
        }

        return output.toString();
    }

    private List<List<InputPair>> loopDiagonallyLeftWithIndex(String[][] twoDArray) {

        int length = twoDArray.length;
        int diagonalLines = (length + length) - 1;
        int itemsInDiagonal = 0;
        int midPoint = (diagonalLines / 2) + 1;
        StringBuilder output = new StringBuilder();
        List<List<InputPair>> inputPairs = new ArrayList<>();

        for (int i = 1; i <= diagonalLines; i++) {

            StringBuilder items = new StringBuilder();
            int rowIndex;
            int columnIndex;

            List<String> s = new ArrayList<>();
            List<InputPair> inputPairsList = new ArrayList<>();
            if (i <= midPoint) {
                itemsInDiagonal++;
                for (int j = 0; j < itemsInDiagonal; j++) {
                    rowIndex = length - i + j;
                    columnIndex = j;
                    s.add(rowIndex + ", " + columnIndex);
                    items.append(twoDArray[rowIndex][columnIndex]);
                    inputPairsList.add(
                            new InputPair(
                                    twoDArray[rowIndex][columnIndex],
                                    new Coordinate(rowIndex, columnIndex)
                            )
                    );
                }
            } else {
                itemsInDiagonal--;
                for (int j = 0; j < itemsInDiagonal; j++) {
                    rowIndex = j;
                    columnIndex = i - length + j;
                    s.add(rowIndex + ", " + columnIndex);
                    items.append(twoDArray[rowIndex][columnIndex]);
                    inputPairsList.add(
                            new InputPair(
                                    twoDArray[rowIndex][columnIndex],
                                    new Coordinate(rowIndex, columnIndex)
                            )
                    );
                }
            }
            System.out.println(String.join(" | ", s));
            inputPairs.add(new ArrayList<>(inputPairsList));

            if (i != diagonalLines) {
                output.append(items).append(" ");
            } else {
                output.append(items);
            }
            System.out.println(items);
        }

        return inputPairs;
    }
}
