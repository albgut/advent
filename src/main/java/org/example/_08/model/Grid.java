package org.example._08.model;

import org.example.utils.Coordinate;
import org.example.utils.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.example.utils.CoordinateUtils.isInBound;
import static org.example.utils.CoordinateUtils.isOutOfBound;
import static org.example.utils.CollectionUtils.buildConcatSet;

public class Grid {
    private final GridElement[][] gridElements;
    private final Map<String, Set<Coordinate>> ANTENNA_COORDINATES = new HashMap<>();

    public Grid(GridElement[][] gridElements) {
        this.gridElements = gridElements;
    }

    public Set<Coordinate> getAntiNodesCoordinates() {
        computeAntennaCoordinates();
        return computeAntinodes();
    }

    public Set<Coordinate> getAntiNodesCoordinatesAll() {
        computeAntennaCoordinates();
        return computeAntinodesAll();
    }

    private Set<Coordinate> computeAntinodes() {
//        return ANTENNA_COORDINATES.values().stream().map(coordinates -> getAllCoordinates(coordinates, valueToCompute, gridElements))
        return ANTENNA_COORDINATES.entrySet().stream().map(
                entry -> getAllCoordinates(entry.getValue(), entry.getKey(), gridElements))
                .reduce(new HashSet<>(), CollectionUtils::buildConcatSet);
    }

    private Set<Coordinate> computeAntinodesAll() {
//        return ANTENNA_COORDINATES.values().stream().map(coordinates -> getAllCoordinates(coordinates, valueToCompute, gridElements))
        return ANTENNA_COORDINATES.entrySet().stream().map(
                        entry -> getAllCoordinatesAll(entry.getValue(), entry.getKey(), gridElements))
                .reduce(new HashSet<>(), CollectionUtils::buildConcatSet);
    }

    private static Set<Coordinate> getAllCoordinates(Set<Coordinate> coordinates, String valueToCompute, GridElement[][] currentGridElements) {
        return coordinates.stream().map(coordinate -> computeFromCoordinate(coordinate, valueToCompute, coordinates, currentGridElements))
                .reduce(new HashSet<>(), CollectionUtils::buildConcatSet);
    }

    private static Set<Coordinate> getAllCoordinatesAll(Set<Coordinate> coordinates, String valueToCompute, GridElement[][] currentGridElements) {
        Set<Coordinate> reduce = coordinates.stream().map(coordinate -> computeFromCoordinateAll(coordinate, valueToCompute, coordinates, currentGridElements))
                .reduce(new HashSet<>(), CollectionUtils::buildConcatSet);
//        System.out.println("CURRENT ->  " + valueToCompute);
//        String b = reduce.stream().map(Coordinate::toString).reduce((s, s2) -> String.join(" ", s, s2)).orElse("");
//        System.out.println(b);
        return reduce;
    }

    private static Set<Coordinate> computeFromCoordinate(Coordinate currentCoordinate, String valueToCompute, Set<Coordinate> coordinates, GridElement[][] currentGridElements) {
        return coordinates.stream().map(
                coordinate -> new Coordinate(
                        2 * currentCoordinate.i() - coordinate.i(),
                        2 * currentCoordinate.j() - coordinate.j()
                )).filter(coordinate1 -> isInBound(coordinate1, currentGridElements.length))
                .filter(coordinate -> getElementFromCoordinate(coordinate, currentGridElements).isNotWithValue(valueToCompute))
                .collect(Collectors.toSet());
    }

    private static Set<Coordinate> computeFromCoordinateAll(Coordinate currentCoordinate, String valueToCompute, Set<Coordinate> coordinates, GridElement[][] currentGridElements) {

        Set<Coordinate> collect = coordinates.stream().flatMap(x -> getAllLines(x, currentCoordinate, currentGridElements).stream())
                .filter(coordinate1 -> isInBound(coordinate1, currentGridElements.length))
//                .filter(coordinate -> getElementFromCoordinate(coordinate, currentGridElements).isNotWithValue(valueToCompute))
                .collect(Collectors.toSet());
//        System.out.println("CURRENT ->  " + valueToCompute);
//        collect.forEach(System.out::print);
        return buildConcatSet(collect, coordinates);
    }

    private static Set<Coordinate> getAllLines(Coordinate coordinate, Coordinate currentCoordinate, GridElement[][] currentGridElements) {
//        System.out.println("CURENT = " + currentCoordinate.toString());
//        System.out.println("COOR = " + coordinate.toString());
        if(isOutOfBound(coordinate, currentGridElements.length) || coordinate.equals(currentCoordinate)) {
            return new HashSet<>();
        } else {
            Coordinate newCoordinate = new Coordinate(
                    2 * currentCoordinate.i() - coordinate.i(),
                    2 * currentCoordinate.j() - coordinate.j());
            return buildConcatSet(Set.of(newCoordinate), getAllLines(currentCoordinate, newCoordinate, currentGridElements));
        }
    }

    private static GridElement getElementFromCoordinate(Coordinate coordinate, GridElement[][] currentGridElements) {
        return currentGridElements[coordinate.i()][coordinate.j()];
    }

    private void computeAntennaCoordinates() {
        List<GridElement> nodes = Arrays.stream(gridElements).flatMap(gridElements1 -> Arrays.stream(gridElements1)
                .filter(GridElement::isFree)).toList();
        for (GridElement node : nodes) {
            addToAntennaMap(node);
        }
        ANTENNA_COORDINATES.forEach((s, coordinates) -> System.out.println(s + coordinates.stream().map(coordinate -> coordinate.i() + "," + coordinate.j()).reduce(" | ", (s1, s2) -> s1 + " " + s2)));
    }

    private void addToAntennaMap(GridElement gridElement) {
        Set<Coordinate> coordinates = ANTENNA_COORDINATES.getOrDefault(gridElement.getValue(), new HashSet<>());
        coordinates.add(gridElement.getCoordinate());
        ANTENNA_COORDINATES.put(gridElement.getValue(), coordinates);
    }

    public static Grid buildGridFromString(List<List<String>> listGrid) {
        GridElement[][] builtGrid = new GridElement[listGrid.size()][listGrid.size()];
        IntStream.range(0, listGrid.size())
                .forEach(i -> IntStream.range(0, listGrid.size())
                        .forEach(j ->
                                builtGrid[i][j] = new GridElement(
                                        new Coordinate(i, j), listGrid.get(i).get(j))
                        )
                );
        return new Grid(builtGrid);
    }
}
