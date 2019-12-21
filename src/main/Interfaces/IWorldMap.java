package Interfaces;

import MapMech.Vector2d;

public interface IWorldMap {

    boolean isOccupied(Vector2d position);

    Object objectAt(Vector2d position);
}