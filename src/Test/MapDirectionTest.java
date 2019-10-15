package Test;

import org.junit.Test;

import static org.junit.Assert.*;

import agh.cs.lab2.*;

public class MapDirectionTest {

    @Test
    public void next() {
        assertEquals(MapDirection.NORTH, MapDirection.WEST.next());
        assertEquals(MapDirection.WEST, MapDirection.SOUTH.next());
        assertEquals(MapDirection.SOUTH, MapDirection.EAST.next());
        assertEquals(MapDirection.EAST, MapDirection.NORTH.next());
    }

    @Test
    public void previous() {
        assertEquals(MapDirection.SOUTH, MapDirection.WEST.previous());
        assertEquals(MapDirection.EAST, MapDirection.SOUTH.previous());
        assertEquals(MapDirection.NORTH, MapDirection.EAST.previous());
        assertEquals(MapDirection.WEST, MapDirection.NORTH.previous());
    }

    Vector2d v1 = new Vector2d(1, 4);

    @Test
    public void equals() {
        Vector2d v2 = new Vector2d(1, 4);
        assertTrue(v1.equals(v2));
    }

    /*@Test
    public void testToString() {
        String Name = toString(v1);

    }

     */

}
