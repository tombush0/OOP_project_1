package agh.cs.lab5;

import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.MapVisualizer;
import agh.cs.lab6.IPositionChangeObserver;

import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    List<Animal> animals = new ArrayList<>();
    Map<Vector2d, IMapElement> objects = new HashMap<>();

    public abstract Vector2d getLowerLeft();
    public abstract Vector2d getUpperRight();

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (objectAt(position) == null) || (objectAt(position).getClass() != Animal.class);
    }

    @Override
    public boolean place(Animal animal) {
        if (isOccupied((animal.getPosition()))) {
            throw new IllegalArgumentException("Field occupied");
        }
        else {
            animals.add(animal);
            animal.addObserver(this);
            objects.put(animal.getPosition(), animal);
            return true;
        }
    }

    @Override
    public void run(MoveDirection[] directions) {
        int aSize = animals.size();
        int a = 0;
        for (MoveDirection x : directions) {
            Animal herbivorous = animals.get(a);
            objects.remove(herbivorous.getPosition());
            herbivorous.move(x);
            objects.put(herbivorous.getPosition(), herbivorous);
            a = (a + 1) % aSize;
            System.out.println(this.toString());
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return objectAt(position) != null;
    }

    @Override
    public IMapElement objectAt(Vector2d position) {
        return objects.get(position);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        System.out.println(oldPosition);
        System.out.println(newPosition);
        IMapElement ob = objectAt(oldPosition);
        objects.remove(oldPosition);
        objects.put(newPosition, ob);
    }

    @Override
    public String toString(){
        Vector2d lowerLeft = getLowerLeft();
        Vector2d upperRight = getUpperRight();
        if(!lowerLeft.precedes(upperRight)) {
            return new MapVisualizer(this).draw(new Vector2d(0, 0), new Vector2d(1, 1));
        }


        return new MapVisualizer(this).draw(lowerLeft, upperRight);
    }
}