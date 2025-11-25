package model;

import CrossyRoad.model.Position;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void testGetLeft() {
        Position pos = new Position(5, 5);
        Position left = pos.getLeft();
        assertEquals(4, left.getX());
        assertEquals(5, left.getY());
    }

    @Test
    void testGetRight() {
        Position pos = new Position(5, 5);
        Position right = pos.getRight();
        assertEquals(6, right.getX());
        assertEquals(5, right.getY());
    }

    @Test
    void testGetUp() {
        Position pos = new Position(5, 5);
        Position up = pos.getUp();
        assertEquals(5, up.getX());
        assertEquals(4, up.getY());
    }

    @Test
    void testGetDown() {
        Position pos = new Position(5, 5);
        Position down = pos.getDown();
        assertEquals(5, down.getX());
        assertEquals(6, down.getY());
    }
}
