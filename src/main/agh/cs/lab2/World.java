package agh.cs.lab2;

import agh.cs.lab3.Animal;
import agh.cs.lab3.OptionsParser;
import agh.cs.lab4.IWorldMap;
//import agh.cs.lab4.RectangularMap;
import agh.cs.lab5.GrassField;

import java.sql.SQLOutput;

public class World {
    public static void main(String[] args) {

        try {
            MoveDirection[] directions = new OptionsParser().parse(args);

            IWorldMap map = new GrassField(new Vector2d(0, 0), new Vector2d(4, 4), 10);
            map.place(new Animal(map));
            map.place(new Animal(map, new Vector2d(1, 1)));
            System.out.println(map);
            map.run(directions);
            System.out.println(map);
        }
        catch(IllegalArgumentException a) {
            System.out.println(a); return;}
    }
}