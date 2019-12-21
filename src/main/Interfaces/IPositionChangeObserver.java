package Interfaces;

import AnimalMech.Animal;
import MapMech.Vector2d;

public interface IPositionChangeObserver {
    void positionChanged(Vector2d oldPosition, Vector2d newPosition, Animal animal);

}
