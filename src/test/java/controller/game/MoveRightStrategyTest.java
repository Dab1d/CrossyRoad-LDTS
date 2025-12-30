package controller.game;

import CrossyRoad.controller.Game.MoveStrategies.MoveRightStrategy;
import CrossyRoad.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MoveRightStrategyTest {
    private MoveRightStrategy strategy;
    private Position position;
    private final int BORDER = 20;

    @BeforeEach
    void setUp() {
        strategy = new MoveRightStrategy();
    }

    @Test
    void testMoveWithinBounds() {
        position = new Position(10, 5);
        int speed = 5;

        int result = strategy.move(position, speed, BORDER);

        assertEquals(15, position.getX(), "Deve mover 5 unidades para a direita");
        assertEquals(5, result, "Deve retornar a velocidade (deslocamento positivo)");
    }

    @Test
    void testMoveWrapAround() {
        position = new Position(18, 5);
        int speed = 5;

        int result = strategy.move(position, speed, BORDER);

        assertEquals(0, position.getX(), "Deve resetar para 0 ao ultrapassar a borda");
        assertEquals(5, result);
    }

    @Test
    void testMoveExactlyAtBorder() {
        position = new Position(15, 5);
        int speed = 5;

        strategy.move(position, speed, BORDER);

        assertEquals(0, position.getX(), "Deve resetar para 0 quando x é exatamente igual ao border");
    }
}