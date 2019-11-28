package agh.cs.lab5;

import agh.cs.lab2.Vector2d;
import agh.cs.lab3.Animal;
import agh.cs.lab4.IWorldMap;
import agh.cs.lab4.RectangularMap;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class GrassFieldTest {

    @Test
    public void testIsOccupied(){
        IWorldMap map = new RectangularMap(new Vector2d(0,0), new Vector2d(11,6));
        map.place(new Animal(map, new Vector2d(1,1)));

        assertFalse(map.isOccupied(new Vector2d(1,2)));
        assertFalse(map.isOccupied(new Vector2d(7,-5)));
        assertFalse(map.isOccupied(new Vector2d(3,1)));
        assertTrue(map.isOccupied(new Vector2d(1,1)));
    }

    @Test
    public void testCanMoveTo(){
        IWorldMap map = new RectangularMap(new Vector2d(0,0), new Vector2d(7,4));
        map.place(new Animal(map));

        assertFalse(map.canMoveTo(new Vector2d(10,3)));
        assertFalse(map.canMoveTo(new Vector2d(-1,5)));
        assertFalse(map.canMoveTo(new Vector2d(2,2)));
        assertTrue(map.canMoveTo(new Vector2d(4,2)));
        assertTrue(map.canMoveTo(new Vector2d(1,1)));
        assertTrue(map.canMoveTo(new Vector2d(5,2)));
    }

    @Test
    public void testObjectAt(){
        IWorldMap map = new RectangularMap(new Vector2d(0,0), new Vector2d(7,4));
        Animal a = new Animal(map);
        Animal b = new Animal(map, new Vector2d(6 ,3));
        map.place(a);
        map.place(b);

        assertNull(map.objectAt(new Vector2d(0,0)));
        assertNull(map.objectAt(new Vector2d(7,4)));
        assertEquals(map.objectAt(new Vector2d(6, 3)), b);
        assertEquals(map.objectAt(new Vector2d(2, 2)), a);
    }
}