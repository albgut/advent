package org.example._06.model;

import org.example.utils.Coordinate;
import org.example.utils.GridGeneric;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Grid implements GridGeneric {

    public static final String OBSTACLE_STRING = "#";
    private static final String GUARD_NORTH = "^";
    private final GridElement[][] gridElements;
    private final Guard guard;

    private Grid(GridElement[][] gridElements, Guard guard) {
        this.gridElements = gridElements;
        this.guard = guard;
    }

    public static Grid buildGridFromString(List<List<String>> listGrid) {
        GridElement[][] builtGrid = new GridElement[listGrid.size()][listGrid.size()];
        IntStream.range(0, listGrid.size())
                .forEach(i -> IntStream.range(0, listGrid.size())
                        .forEach(j ->
                                builtGrid[i][j] = new GridElement(
                                        listGrid.get(i).get(j).equals(OBSTACLE_STRING),
                                        new Coordinate(i, j))
                        )
                );
        GridElement[][] gridElementsWithGuard = insertGuard(listGrid, builtGrid);
        Guard guard = buildGuard(listGrid);

        return new Grid(gridElementsWithGuard, guard);
    }

    public int travel() {
        while (!isOutOfBound(guard.getCoordonate())) {
            travelNextStep();
        }
        printAll();
        return countPassedCases();
    }

    public int computeInfinityForAll() {

        Stream<Long> longStream = Arrays.stream(gridElements).map(
                gridElements1 -> Arrays.stream(gridElements1)
                        .map(GridElement::getCoordonate)
                        .map(coordonate -> makeCloneGridWithObstacle(coordonate, gridElements, guard.clone()))
                        .filter(Grid::haveInfinity)
                        .count()
        );
        return longStream.reduce(Long::sum).map(Long::intValue).orElse(0);
    }

    public void printAll() {
        System.out.println("GUARD POSITION : " + guard.getCoordonate());
        System.out.println("GUARD DIRECTION : " + guard.getDirection());
        for (GridElement[] gridElement : gridElements) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < gridElements.length; j++) {
                s.append(gridElement[j].isObstacle() ? "@" : (gridElement[j].isPassedIn() ? "X" : " "));
            }
            System.out.println(s);
        }
    }

    private boolean haveInfinity() {
        List<Coordinate> currentTravel = new ArrayList<>();
        while (!haveCycle(currentTravel) && !isOutOfBound(guard.getCoordonate())) {
            travelNextStep();
            currentTravel.add(guard.getCoordonate());
        }
        if (haveCycle(currentTravel)) printAll();
        return haveCycle(currentTravel);
    }

    private static boolean haveCycle(List<Coordinate> currentTravel) {
        return currentTravel.size() > 2 &&
                Collections.indexOfSubList(currentTravel.subList(0, currentTravel.size() - 2),
                        currentTravel.subList(currentTravel.size() - 2, currentTravel.size())) != -1;
    }

    private static Grid makeCloneGridWithObstacle(Coordinate coordinate, GridElement[][] gridElements, Guard guard) {
        GridElement[][] builtGrid = new GridElement[gridElements.length][gridElements.length];
        IntStream.range(0, gridElements.length)
                .forEach(i -> IntStream.range(0, gridElements.length)
                        .forEach(j ->
                                builtGrid[i][j] = coordinate.i() == i && coordinate.j() == j ?
                                        new GridElement(true, new Coordinate(i, j)) :
                                        new GridElement(gridElements[i][j].isObstacle(), new Coordinate(i, j))
                        )
                );

        Arrays.stream(builtGrid).forEach(
                gridElements1 -> Arrays.stream(gridElements1)
                        .filter(gridElement -> gridElement.getCoordonate().equals(guard.getCoordonate()))
                        .forEach(GridElement::makePassedIn)
        );

        return new Grid(builtGrid, guard);
    }

    private int countPassedCases() {
        return Arrays.stream(gridElements)
                .map(x -> Arrays.stream(x).filter(GridElement::isPassedIn).count())
                .reduce(Long::sum).map(Long::intValue).orElse(0);
    }

    private void travelNextStep() {
        getElementFromCoordonate(guard.getCoordonate()).makePassedIn();
        while(!isTraversable(guard.getNextCoordonateToMove())){
            guard.turnRight();
        }
        guard.move();
    }

    private boolean isTraversable(Coordinate coordinate) {
        return isOutOfBound(coordinate) || !getElementFromCoordonate(coordinate).isObstacle();
    }

    private boolean isOutOfBound(Coordinate coordinate) {
        return coordinate.j() < 0 || coordinate.j() >= gridElements.length || coordinate.i() < 0 || coordinate.i() >= gridElements.length;
    }

    private GridElement getElementFromCoordonate(Coordinate coordinate) {
        return gridElements[coordinate.i()][coordinate.j()];
    }

    @NotNull
    private static Guard buildGuard(List<List<String>> listGrid) {
        Coordinate coordinate = IntStream.range(0, listGrid.size())
                .mapToObj(i -> IntStream.range(0, listGrid.size())
                        .filter(j -> listGrid.get(i).get(j).equals(GUARD_NORTH))
                        .mapToObj(j -> new Coordinate(i, j))
                        .toList()
                ).filter(l -> !l.isEmpty())
                .toList().get(0).get(0);

        return new Guard(Direction.NORD, coordinate);
    }

    private static GridElement[][] insertGuard(List<List<String>> listGrid, GridElement[][] builtGrid) {
        IntStream.range(0, listGrid.size())
                .forEach(i -> IntStream.range(0, listGrid.size())
                        .filter(j -> listGrid.get(i).get(j).equals(GUARD_NORTH))
                        .forEach(j -> builtGrid[i][j].makePassedIn())
                );

        return builtGrid;
    }
}
