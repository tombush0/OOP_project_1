package agh.cs.lab2.main;

import agh.cs.lab3.Animal;

public class World {
    public static void main(String[] args) {
       /*
        Vector2d position1 = new Vector2d(1, 2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2, 1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        */

        Animal t = new Animal();
        System.out.println(t.toString());
        t.move(MoveDirection.RIGHT);
        t.move(MoveDirection.FORWARD);
        t.move(MoveDirection.FORWARD);
        t.move(MoveDirection.FORWARD);
        System.out.println(t.toString());
    }
}
