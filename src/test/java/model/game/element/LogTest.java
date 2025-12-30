package model.game.element;

import CrossyRoad.controller.Game.MoveStrategies.MoveRightStrategy;
import CrossyRoad.controller.Game.MoveStrategies.MoveStrategy;
import CrossyRoad.model.Position;
import CrossyRoad.model.game.elements.Log;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

public class LogTest {
    Log log;
    @BeforeEach
    public void setUp() {
        this.log = new Log(5,5, 1, new MoveRightStrategy());
    }

    @Test
    public void testConstructor() {
        assertEquals(log.getPosition().getX(), 5 );
        assertFalse( log.getPosition().getX() == 6);
        assertFalse( log.getPosition().getX() == 4);


        assertEquals(log.getPosition().getY(), 5);
        assertFalse( log.getPosition().getY() == 6);
        assertFalse( log.getPosition().getY() == 4);
    }

        @Test
        void testUpdatePositionCallsStrategy() {
            MoveStrategy mockStrategy = mock(MoveStrategy.class);
            Log log = new Log(5, 5, 2, mockStrategy);
            int width = 20;
            int expectedNewX = 7;
            when(mockStrategy.move(any(Position.class), eq(2), eq(width)))
                    .thenReturn(expectedNewX);

            int result = log.updatePosition(width);
            assertEquals(expectedNewX, result);
            verify(mockStrategy, times(1)).move(log.getPosition(), 2, width);
        }
    }
