import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class ElementTest {
    Element element;
    @BeforeEach
    public void setup() {
        this.element = new Element(10, 10) {
            @Override
            public void draw(TextGraphics graphics) {}
        };
    }

    @Test
    public void testPosition() {
        Position p = new Position(10,10);
        assertEquals(p, element.getPosition());

        Position p1 = new Position(2,2);
        assertFalse(element.equals(p1));
    }

    @Test
    public void testSetPosition() {
        Position p = new Position(5,5);
        element.setPosition(p);
        assertEquals(p, element.getPosition());
    }

    @Test
    public void testGetPosition() {
        Position p = new Position(10,10);
        assertEquals(p, element.getPosition());

        Position p1 = new Position(2,2);
        assertFalse(element.equals(p1));
    }
}
