package agh.cs.lab6;

import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab5.IMapElement;

import java.util.Comparator;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{
    private TreeSet<Vector2d> oX = new TreeSet<>(new Comparator<Vector2d>() {
        @Override
        public int compare(Vector2d a, Vector2d b) {
            if (a.x < b.x) { return 1; }
            else if (a.x > b.x){ return -1; }
            else {
                return Integer.compare(a.y, b.y);
            }
        }});

    private TreeSet<Vector2d> oY = new TreeSet<>(new Comparator<Vector2d>() {
        @Override
        public int compare(Vector2d a, Vector2d b) {
            if (a.y < b.y) { return 1; }
            else if (a.y > b.y){ return -1; }
            else {
                return Integer.compare(a.x, b.x);
            }
        }});

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        oX.remove(oldPosition);
        oY.remove(oldPosition);

        oX.add(newPosition);
        oY.add(newPosition);
    }

    public Vector2d lowLeft(){
        if(oX.size() == 0 && oY.size() == 0){
            return new Vector2d(0,0);
        }
        return new Vector2d(oX.last().x, oY.last().y);
    }

    public Vector2d upRight(){
        if(oX.size() == 0 && oY.size() == 0){
            return new Vector2d(0,0);
        }
        return new Vector2d(oX.first().x, oY.first().y);
    }

    public void add(IMapElement elem){
        if(elem.getClass() == Animal.class){
            ((Animal)elem).addObserver(this);
        }
        oX.add(elem.getPosition());
        oY.add(elem.getPosition());
    }
}