package state;

import CrossyRoad.session.GameSession;
import CrossyRoad.state.State;
import CrossyRoad.state.StateFactory;
import CrossyRoad.state.StateManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StateManagerTest {

    @Mock
    private StateFactory stateFactory;
    @Mock
    private State menuState;
    @Mock
    private State gameState;
    @Mock
    private State pauseState;
    @Mock
    private State winState;
    @Mock
    private State gameOverState;
    @Mock
    private State helpState;

    private StateManager stateManager;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        when(stateFactory.createMenuState()).thenReturn(menuState);
        stateManager = new StateManager(stateFactory);
    }

    @Test
    void testConstructorInitialization() {
        assertEquals(menuState, stateManager.getState());
        assertNotNull(stateManager.getGameSession());
    }

    @Test
    void testInitGame() throws IOException {
        when(stateFactory.createGameState(anyInt())).thenReturn(gameState);
        stateManager.initGame();

        verify(stateFactory).createGameState(1); // Assume nível inicial 1
        assertEquals(gameState, stateManager.getState());
        assertEquals(0, stateManager.getGameSession().getScore()); // Verifica resetScore
    }

    @Test
    void testReturnToMenu() throws IOException {
        stateManager.returnToMenu();
        verify(stateFactory, times(2)).createMenuState(); // 1 no construtor + 1 agora
        assertEquals(menuState, stateManager.getState());
        assertEquals(0, stateManager.getGameSession().getScore()); // Verifica resetScore
    }

    @Test
    void testPauseGame() throws IOException {
        when(stateFactory.createPauseState()).thenReturn(pauseState);
        State estadoAntesDaPausa = stateManager.getState();
        stateManager.pauseGame();

        assertEquals(estadoAntesDaPausa, stateManager.getPrevious());
        assertEquals(pauseState, stateManager.getState());
    }

    @Test
    void testResumeGameWithPreviousState() {
        stateManager.setPrevious(menuState);
        stateManager.setState(pauseState);
        stateManager.resumeGame();

        assertEquals(menuState, stateManager.getState());
    }

    @Test
    void testResumeGameWithoutPreviousState() {
        stateManager.setPrevious(null);
        stateManager.setState(menuState);
        stateManager.resumeGame();

        assertEquals(menuState, stateManager.getState());
    }

    @Test
    void testWinGame() throws IOException {
        when(stateFactory.createWinState()).thenReturn(winState);
        stateManager.winGame();

        assertEquals(winState, stateManager.getState());
    }

    @Test
    void testLoseGame() throws IOException {
        when(stateFactory.createGameOverState()).thenReturn(gameOverState);
        stateManager.loseGame();

        assertEquals(gameOverState, stateManager.getState());
    }

    @Test
    void testGoToHelp() throws IOException {
        when(stateFactory.createHelpState()).thenReturn(helpState);
        stateManager.goToHelp();

        assertEquals(helpState, stateManager.getState());
    }

    @Test
    void testQuitGame() {
        stateManager.quitGame();
        assertNull(stateManager.getState());
    }

    @Test
    void testAdvanceLevelNotMax() throws IOException {
        when(stateFactory.createGameState(anyInt())).thenReturn(gameState);
        GameSession session = stateManager.getGameSession();
        int initialLevel = session.getLevel();
        stateManager.advanceLevel();

        assertTrue(session.getLevel() > initialLevel);
        verify(stateFactory).createGameState(session.getLevel());
        assertEquals(gameState, stateManager.getState());
    }

    @Test
    void testFinishGame() throws IOException {
        when(stateFactory.createWinState()).thenReturn(winState);
        stateManager.finishGame();

        verify(stateFactory).createWinState();
        assertEquals(winState, stateManager.getState());
    }

    @Test
    void testAdvanceLevelAtMaxLevel() throws IOException, URISyntaxException, FontFormatException {
        when(stateFactory.createMenuState()).thenReturn(menuState);
        when(stateFactory.createWinState()).thenReturn(winState);
        GameSession sessionMock = mock(GameSession.class);
        when(sessionMock.isMaxLevel()).thenReturn(true);

        StateManager manager = new StateManager(stateFactory, sessionMock);
        manager.advanceLevel();

        verify(sessionMock).isMaxLevel();
        verify(sessionMock, never()).nextLevel();
        verify(stateFactory).createWinState();
        assertEquals(winState, manager.getState());
    }
}