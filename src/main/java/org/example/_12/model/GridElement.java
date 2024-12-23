package org.example._12.model;

import org.example.utils.Coordinate;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.UUID;

public class GridElement implements Comparable<GridElement>{
    private final Coordinate coordinate;
    private final int strangerNeighbour;
    private final String name;
    private UUID areaId;

    public GridElement(Coordinate coordinate, int strangerNeighbour, String name) {
        this.coordinate = coordinate;
        this.strangerNeighbour = strangerNeighbour;
        this.name = name;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public int getStrangerNeighbour() {
        return strangerNeighbour;
    }

    public String getName() {
        return name;
    }

    public UUID getAreaId() {
        return areaId;
    }

    public void setAreaId(UUID areaId) {
        this.areaId = areaId;
    }

    @Override
    public String toString() {
        return "GridElement{" +
                "coordinate=" + coordinate +
                ", strangerNeighbour=" + strangerNeighbour +
                ", name='" + name + '\'' +
                ", areaId=" + areaId +
                '}';
    }

    @Override
    public int compareTo(@NotNull GridElement gridElement) {
        return getAreaId().compareTo(gridElement.areaId);
    }
}
