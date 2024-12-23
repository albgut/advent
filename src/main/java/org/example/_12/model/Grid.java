package org.example._12.model;

import org.example.utils.Coordinate;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;

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
                                builtGrid[i][j] = buildGridElement(listGrid, i, j)
                        )
                );
        Arrays.stream(builtGrid).forEach(x -> Arrays.stream(x).forEach(
                gridElement -> gridElement.setAreaId(buildAreaId(gridElement, builtGrid))
        ));
        Grid grid = new Grid(builtGrid);
//        Arrays.stream(grid.gridElements).forEach(x -> Arrays.stream(x).sorted().forEach(System.out::println));
        return grid;
    }

    private static boolean isInBound(Coordinate coordinate, int gridElementsLength) {
        return !(coordinate.j() < 0 || coordinate.j() >= gridElementsLength || coordinate.i() < 0 || coordinate.i() >= gridElementsLength);
    }

    private static @NotNull GridElement buildGridElement(List<List<String>> listGrid, int i, int j) {
        Coordinate coordinate = new Coordinate(i, j);
        String currentName = listGrid.get(i).get(j);
        return new GridElement(
                coordinate,
                buildStrangerNeighbour(listGrid, coordinate, currentName),
                currentName
        );
    }

    private static int buildStrangerNeighbour(List<List<String>> listGrid, Coordinate coordinate, String currentName) {
        return ((int) coordinate.getNeighbour().stream()
                .filter(neighbourCoordinate -> isInBound(neighbourCoordinate, listGrid.size()))
                .filter(neighbourCoordinate ->
                        !listGrid.get(neighbourCoordinate.i()).get(neighbourCoordinate.j())
                                .equals(currentName)
                )
                .count()) + ((int)
                coordinate.getNeighbour().stream()
                .filter(neighbourCoordinate -> !isInBound(neighbourCoordinate, listGrid.size())).count());
    }

    private static UUID buildAreaId(GridElement gridElement, GridElement[][] gridElements) {
        Optional<UUID> previousUUID = gridElement.getCoordinate().getUpperNeighbour().stream()
                .filter(neighbourCoordinate -> isInBound(neighbourCoordinate, gridElements.length))
                .map(neighbourCoordinate -> gridElements[neighbourCoordinate.i()][neighbourCoordinate.j()])
                .filter(neighbourGridElement -> neighbourGridElement.getName().equals(gridElement.getName()))
                .map(GridElement::getAreaId)
                .filter(Objects::nonNull)
                .findAny();
        List<UUID> listUUID = gridElement.getCoordinate().getUpperNeighbour().stream()
                .filter(neighbourCoordinate -> isInBound(neighbourCoordinate, gridElements.length))
                .map(neighbourCoordinate -> gridElements[neighbourCoordinate.i()][neighbourCoordinate.j()])
                .filter(neighbourGridElement -> neighbourGridElement.getName().equals(gridElement.getName()))
                .map(GridElement::getAreaId)
                .filter(Objects::nonNull)
                .distinct().toList();
        if (listUUID.size() == 2) {
            Arrays.stream(gridElements).forEach(x -> Arrays.stream(x)
                    .filter(gridElement1 -> gridElement1.getAreaId() != null)
                    .filter(
                    gridElement1 -> gridElement1.getAreaId().equals(listUUID.get(1))
            ).forEach(newValues -> newValues.setAreaId(listUUID.getFirst())));
        }
        return listUUID.stream().findFirst().orElseGet(UUID::randomUUID);
    }

    public long computePrice() {
        Map<UUID, List<GridElement>> gridGroupByArea = Arrays.stream(gridElements).flatMap(Arrays::stream)
                .collect(groupingBy(GridElement::getAreaId));
        return gridGroupByArea.values().stream()
                .mapToLong(elements -> elements.size() * elements.stream()
                        .mapToLong(GridElement::getStrangerNeighbour)
                        .sum()
                ).sum();
    }
}
