package controller.game;

import CrossyRoad.controller.Game.SpaceController;
import CrossyRoad.session.GameSession;
import CrossyRoad.state.StateManager;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.game.elements.Bush;
import CrossyRoad.model.game.elements.Chicken;
import CrossyRoad.model.game.elements.Coin;
import CrossyRoad.model.game.space.Space;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SpaceControllerTest {

    private Space space;
    private SpaceController controller;
    private StateManager game;
    private GameSession session;

    @BeforeEach
    public void setUp() {
        space = new Space(10, 10);

        space.setBushes(new ArrayList<>());
        space.setCars(new ArrayList<>());
        space.setTrucks(new ArrayList<>());
        space.setLogs(new ArrayList<>());
        space.setRiver(new ArrayList<>());
        space.setEndLines(new ArrayList<>());
        space.setWalls(new ArrayList<>());
        space.setCoins(new ArrayList<>());

        space.setChicken(new Chicken(6,5));

        controller = new SpaceController(space);
        session = new GameSession();
        game = mock(StateManager.class);
    }

    @Test
    public void moveChickenUp_whenEmpty() throws IOException {
        Position initial = new Position(6, 5);
        controller.step(game, GUI.ACTION.UP, 0);
        Position after = space.getChicken().getPosition();

        assertEquals(initial.getX(), after.getX());
        assertEquals(initial.getY() - 1, after.getY());
    }

    @Test
    public void moveChickenDown_whenEmpty() throws IOException {
        Position initial = new Position(6, 5);
        controller.step(game, GUI.ACTION.DOWN, 0);
        Position after = space.getChicken().getPosition();
        assertEquals(initial.getX(), after.getX());
        assertEquals(initial.getY() + 1, after.getY());
    }

    @Test
    public void moveChickenLeft_whenEmpty() throws IOException {
        Position initial = new Position(6, 5);
        controller.step(game, GUI.ACTION.LEFT, 0);
        Position after = space.getChicken().getPosition();
        assertEquals(initial.getX() - 1, after.getX());
        assertEquals(initial.getY(), after.getY());
    }

    @Test
    public void moveChickenRight_whenEmpty() throws IOException {
        Position initial = new Position(6, 5);
        controller.step(game, GUI.ACTION.RIGHT, 0);
        Position after = space.getChicken().getPosition();
        assertEquals(initial.getX() + 1, after.getX());
        assertEquals(initial.getY(), after.getY());
    }

    @Test
    public void chickenDoesNotMoveIntoBush() throws IOException {
        space.getBushes().add(new Bush(6,4));
        Position initial = new Position(6, 5);
        controller.step(game, GUI.ACTION.UP, 0);
        Position after = space.getChicken().getPosition();
        assertEquals(initial.getX(), after.getX());
        assertEquals(initial.getY(), after.getY());
    }

    @Test
    public void coinIsCollected_whenChickenMoves() throws IOException {
        Coin coin = new Coin(6,4);
        space.getCoins().add(coin);
        assertFalse(space.getCoins().isEmpty());
        controller.step(game, GUI.ACTION.UP, 0);
        assertTrue(space.getCoins().isEmpty(), "A moeda devia ter sido removida");
        verify(session, times(1)).addScore();
    }
}