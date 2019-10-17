package agh.cs.lab3;

import agh.cs.lab2.main.MapDirection;
import agh.cs.lab2.main.MoveDirection;
import agh.cs.lab2.main.Vector2d;

public class Animal {
    private MapDirection dir = MapDirection.NORTH;
    private Vector2d pos = new Vector2d(2,2);

    @Override
    public String toString(){
        return String.format("Position: " + pos + ", orientation: " + dir);
    }

    public void move(MoveDirection direction){
        Vector2d ppos = pos;
        switch(direction){
            case LEFT:
                dir = dir.previous();
                break;
            case RIGHT:
                dir = dir.next();
                break;
            case FORWARD:
                pos = pos.add(dir.toUnitVector());
                break;
            case BACKWARD:
                pos = pos.subtract(dir.toUnitVector());
                break;
        }
        if(pos.precedes(new Vector2d(-1,-1)) || pos.follows(new Vector2d(5,5)))
            pos = ppos;
    }
}
