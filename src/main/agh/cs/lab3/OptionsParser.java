package agh.cs.lab3;

import agh.cs.lab2.MoveDirection;

import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] parse(String[] way) throws IllegalArgumentException {
        MoveDirection[] moves = new MoveDirection[way.length];
        int x=0;
        for(int i=0; i<way.length; i++){
            switch(way[i]){
                case "f" :
                case "forward" :
                    moves[x++] = MoveDirection.FORWARD;
                    break;
                case "b":
                case "backward":
                    moves[x++] = MoveDirection.BACKWARD;
                    break;
                case "l" :
                case "left" :
                    moves[x++] = MoveDirection.LEFT;
                    break;
                case "r" :
                case "right" :
                    moves[x++] = MoveDirection.RIGHT;
                    break;
                default:
                    throw new IllegalArgumentException(way[i] + " is not legal move specification");
            }
        }
        return Arrays.copyOfRange(moves, 0, x);
    }
}
