package agh.cs.lab3;

import agh.cs.lab2.MapDirection;
import agh.cs.lab2.MoveDirection;
import agh.cs.lab2.Vector2d;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab5.IMapElement;
import agh.cs.lab6.IPositionChangeObserver;

import java.util.LinkedList;


public class Animal implements IMapElement {
    public MapDirection dir = MapDirection.NORTH;
    private Vector2d pos = new Vector2d(2, 2);
    private IWorldMap map;

    LinkedList<IPositionChangeObserver> observers = new LinkedList<IPositionChangeObserver>();

    public Animal(IWorldMap map){
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.pos = initialPosition;
    }
    @Override
    public Vector2d getPosition(){
        return this.pos;
    }

    @Override
    public String toString() {
        String orient = String.valueOf(dir);
        return Character.toString(orient.charAt(0));
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case LEFT:
                dir = dir.previous();
                break;
            case RIGHT:
                dir = dir.next();
                break;
            case FORWARD:
                if(map.canMoveTo(pos.add(dir.toUnitVector())))
                    pos = pos.add(dir.toUnitVector());
                break;
            case BACKWARD:
                if(map.canMoveTo(pos.subtract(dir.toUnitVector())))
                    pos = pos.subtract(dir.toUnitVector());
                break;
        }
    }

    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }

    void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }

    void positionChange(Vector2d oldPosition, Vector2d newPosition){
        System.out.println(observers.size());
        for(IPositionChangeObserver observer: observers){
            observer.positionChanged(oldPosition, newPosition);
        }
    }
}
