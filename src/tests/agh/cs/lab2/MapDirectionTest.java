package agh.cs.lab2.test;

import agh.cs.lab2.MapDirection;
import org.junit.Test;

import static org.junit.Assert.*;

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
}
