import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SpaceTest {

    /** create the space object */

    Space space;
    @BeforeEach
    public  void setup() {
        int height = 30;
        int width = 30;
        space = new Space(width, height);
    }

    /** test getter and setter for width and height */
    @Test
    public void testSpaceWidth(){
        space.setWidth(100);

        assertEquals(100, space.getWidth());
    }

    @Test
    public void testSpaceHeight(){
        space.setHeight(100);

        assertEquals(100, space.getHeight());
    }

    /** test the min_x and max_x values and their getters */
    @Test
    public void testSpaceMin_x(){
        assertEquals(1,space.getMin_x());
    }

    @Test
    public void testSpaceMax_x(){
        assertEquals(28,space.getMax_x());
    }

    /** test if change in width or height update the min and max values */
    @Test
    public void testSpaceChangeDimension(){
        space.setWidth(50);
        space.setHeight(50);

        assertEquals(1,space.getMin_x());
        assertEquals(48,space.getMax_x());
    }
}
