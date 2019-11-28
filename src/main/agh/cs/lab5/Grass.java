package agh.cs.lab5;

import agh.cs.lab2.Vector2d;

public class Grass implements IMapElement{
    private Vector2d pos;
    Grass(Vector2d position){
        this.pos = position;
    }

    @Override
    public Vector2d getPosition(){
        return pos;
    }

    @Override
    public String toString(){
        return "*";
    }
}
