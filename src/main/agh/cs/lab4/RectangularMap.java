package agh.cs.lab4;

import agh.cs.lab2.Vector2d;
import agh.cs.lab5.AbstractWorldMap;


public class RectangularMap extends AbstractWorldMap {
    private Vector2d lowerLeft;
    private Vector2d upperRight;


    public RectangularMap(Vector2d lowerLeft, Vector2d upperRight) {
        this.lowerLeft = lowerLeft;
        this.upperRight = upperRight;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(position.follows(this.upperRight) || position.precedes(this.lowerLeft)) && super.canMoveTo(position);
    }


    public Vector2d getUpperRight(){
        return this.upperRight;
    }

    public Vector2d getLowerLeft(){
        return this.lowerLeft;
    }
}
