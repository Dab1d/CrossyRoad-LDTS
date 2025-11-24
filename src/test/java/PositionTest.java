import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class PositionTest {
    Position position;
    @BeforeEach
    public void setup() {
        this.position = new Position(10,10);
    }

    @Test
    public void testGetX(){
        assertEquals(10,position.getX());
    }

    @Test
    public void testGetY(){
        assertEquals(10,position.getY());
    }

    @Test
    public void testEqualsObject(){
        assertTrue(position.equals(new Position(10,10)));
    }

    @Test
    public void testEqualsNullObject(){
        assertFalse(position.equals(null));
    }

    @Test
    public void testEquals(){
        Position p1 = new Position(10,10);
        assertTrue(p1.equals(p1));
    }
}
