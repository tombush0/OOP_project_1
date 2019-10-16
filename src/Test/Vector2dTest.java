package Test;

import org.junit.Test;

import static org.junit.Assert.*;

import agh.cs.lab2.*;

public class Vector2dTest {
    @Test
    public void equals() {

        assertTrue(new Vector2d(1, 4).equals(new Vector2d(1, 4)));
        ;
    }

    @Test
    public void testToString() {
        assertEquals(new Vector2d(1, 4).toString(), "(1,4)");
    }

    @Test
    public void precedes() {
        assertTrue(new Vector2d(5, 2).precedes(new Vector2d(2, 2)));
        assertTrue(new Vector2d(5, 2).precedes(new Vector2d(5, 1)));
        assertTrue(new Vector2d(5, 2).precedes(new Vector2d(5, 2)));
    }

    @Test
    public void follows() {
        assertTrue(new Vector2d(1, 4).follows(new Vector2d(2, 4)));
        assertTrue(new Vector2d(1, 4).follows(new Vector2d(1, 5)));
        assertTrue(new Vector2d(1, 4).follows(new Vector2d(2, 5)));
    }

    @Test
    public void testUpperRight() {
        assertEquals((new Vector2d(1, 1).upperRight(new Vector2d(2, 3))), new Vector2d(2, 3));
    }

    @Test
    public void testLowerLeft() {
        assertEquals((new Vector2d(1, 1).lowerLeft(new Vector2d(2, 3))), new Vector2d(1, 1));
    }

    @Test
    public void testAdd() {
        assertEquals((new Vector2d(1, 2).add(new Vector2d(3, 4))), new Vector2d(4, 6));
    }

    @Test
    public void testSubtract() {
        assertEquals((new Vector2d(4, 6).subtract(new Vector2d(1, 2))), new Vector2d(3, 4));
    }

    @Test
    public void testOpposite() {
        assertEquals(new Vector2d(2, 3).opposite(), new Vector2d(-2, -3));
    }
}
