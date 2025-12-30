package controller.game;

import CrossyRoad.controller.Game.CoinController;
import CrossyRoad.state.StateManager;
import CrossyRoad.session.GameSession; // Import novo
import CrossyRoad.model.game.elements.Chicken;
import CrossyRoad.model.game.elements.Coin;
import CrossyRoad.model.game.space.Space;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CoinControllerTest {

    private Space space;
    private CoinController controller;
    private StateManager stateManager;
    private GameSession gameSession;

    @BeforeEach
    void setUp() {
        space = new Space(5, 5);

        // Inicializa listas para evitar NullPointer no Controller
        space.setBushes(new ArrayList<>());
        space.setCars(new ArrayList<>());
        space.setTrucks(new ArrayList<>());
        space.setLogs(new ArrayList<>());
        space.setRiver(new ArrayList<>());
        space.setEndLines(new ArrayList<>());
        space.setWalls(new ArrayList<>());

        space.setCoins(new ArrayList<>());

        Chicken chicken = new Chicken(2,2);
        space.setChicken(chicken);

        controller = new CoinController(space);

        stateManager = mock(StateManager.class);
        gameSession = mock(GameSession.class);

        when(stateManager.getGameSession()).thenReturn(gameSession);
    }

    @Test
    void collectsCoinWhenChickenOnSamePosition() {
        Coin coin = new Coin(2,2);
        space.getCoins().add(coin);
        assertEquals(1, space.getCoins().size());
        controller.step(stateManager, null, 0);
        assertTrue(space.getCoins().isEmpty());
        verify(gameSession, times(1)).addScore();
    }

    @Test
    void doesNotCollectCoinWhenChickenNotOnCoin() {
        Coin coin = new Coin(1,1); // Posição diferente da galinha (2,2)
        space.getCoins().add(coin);
        controller.step(stateManager, null, 0);
        assertEquals(1, space.getCoins().size());
        verify(gameSession, never()).addScore();
    }

    @Test
    void collectingSameCoinTwiceDoesNotIncreaseScore() {
        Coin coin = new Coin(2,2);
        space.getCoins().add(coin);
        controller.step(stateManager, null, 0);
        controller.step(stateManager, null, 0);
        verify(gameSession, times(1)).addScore();
        assertTrue(space.getCoins().isEmpty());
    }
}