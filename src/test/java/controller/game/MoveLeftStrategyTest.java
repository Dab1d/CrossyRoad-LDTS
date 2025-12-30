package controller.game;

import CrossyRoad.controller.Game.MoveStrategies.MoveLeftStrategy;
import CrossyRoad.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveLeftStrategyTest {

    private MoveLeftStrategy strategy;
    private Position position;
    private final int BORDER = 20;

    @BeforeEach
    void setUp() {
        strategy = new MoveLeftStrategy();
    }

    @Test
    void testMoveWithinBounds() {
        position = new Position(10, 5);
        int speed = 3;

        int result = strategy.move(position, speed, BORDER);

        assertEquals(7, position.getX(), "Deve mover 3 unidades para a esquerda");
        assertEquals(-3, result, "Deve retornar o deslocamento negativo");
    }

    @Test
    void testMoveWrapAround() {
        position = new Position(2, 5);
        int speed = 5;

        int result = strategy.move(position, speed, BORDER);

        assertEquals(BORDER - 1, position.getX(), "Deve saltar para a borda direita");
        assertEquals(-5, result);
    }

    @Test
    void testMoveExactlyToEdge() {
        // Path coverage adicional: Testar o limite exato (x = 0)
        position = new Position(5, 5);
        int speed = 5;

        strategy.move(position, speed, BORDER);

        assertEquals(0, position.getX(), "Deve ficar exatamente no zero sem ativar o wrap-around");
    }
}
