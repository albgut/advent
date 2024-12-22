package org.example._10.model;

import org.example.utils.Coordinate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Grid {
    private final GridElement[][] gridElements;

    public Grid(GridElement[][] gridElements) {
        this.gridElements = gridElements;
    }

    public static Grid buildGridFromString(List<List<String>> listGrid) {
        GridElement[][] builtGrid = new GridElement[listGrid.size()][listGrid.size()];
        IntStream.range(0, listGrid.size())
                .forEach(i -> IntStream.range(0, listGrid.size())
                        .forEach(j ->
                                builtGrid[i][j] = new GridElement(
                                        new Coordinate(i, j), Integer.parseInt(listGrid.get(i).get(j)))
                        )
                );
        return new Grid(builtGrid);
    }

    /*private static GridElement getElementFromCoordinate(Coordinate coordinate, GridElement[][] currentGridElements) {
        return currentGridElements[coordinate.i()][coordinate.j()];
    }*/

    private GridElement getElementFromCoordinate(Coordinate coordinate) {
        return this.gridElements[coordinate.i()][coordinate.j()];
    }

    public long countTrailHead() {
        return Arrays.stream(gridElements).flatMap(elements -> Arrays.stream(elements).filter(gridElement -> gridElement.getValue() == 0))
                .map(gridElement -> this.countTrailHeadFromGridElement(gridElement, gridElement.getCoordinate()))
                .reduce(Integer::sum).orElse(0);
    }

    public long countTrailHeadAll() {
        return Arrays.stream(gridElements).flatMap(elements -> Arrays.stream(elements).filter(gridElement -> gridElement.getValue() == 0))
                .map(gridElement -> this.countTrailHeadFromGridElementAll(gridElement, gridElement.getCoordinate()))
                .reduce(Integer::sum).orElse(0);
    }

    private int countTrailHeadFromGridElement(GridElement gridElement, Coordinate initialCoordinate) {
        if (gridElement.getValue() == 9) {
            return gridElement.addZeroReacher(initialCoordinate) ? 1 : 0;
        } else {
            return getAllNeighbourWithValue(gridElement.getValue() + 1, gridElement)
                    .stream().map(nextGridElement -> this.countTrailHeadFromGridElement(nextGridElement, initialCoordinate)).reduce(Integer::sum).orElse(0);
        }
    }

    private int countTrailHeadFromGridElementAll(GridElement gridElement, Coordinate initialCoordinate) {
        if (gridElement.getValue() == 9) {
            return 1;
        } else {
            return getAllNeighbourWithValue(gridElement.getValue() + 1, gridElement)
                    .stream().map(nextGridElement -> this.countTrailHeadFromGridElementAll(nextGridElement, initialCoordinate)).reduce(Integer::sum).orElse(0);
        }
    }

    private List<GridElement> getAllNeighbourWithValue(int nextValue, GridElement gridElement) {
        return getAllNeighbour(gridElement)
                .stream().filter(element -> element.getValue() == nextValue).toList();
    }

    private List<GridElement> getAllNeighbour(GridElement gridElement) {
        return gridElement.getCoordinate().getNeighbour().stream().filter(this::isInBound)
                .map(this::getElementFromCoordinate).toList();
    }

    private boolean isInBound(Coordinate coordinate) {
        return !(coordinate.j() < 0 || coordinate.j() >= gridElements.length || coordinate.i() < 0 || coordinate.i() >= gridElements.length);
    }
}
