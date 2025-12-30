import CrossyRoad.GameController;
import CrossyRoad.gui.GUI;
import CrossyRoad.state.State;
import CrossyRoad.state.StateManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GameControllerTest {

    @Mock private StateManager stateManager;
    @Mock private GUI gui;
    @Mock private State state;

    @Test
    void testGameLoopFinishesWhenStateIsNull() throws IOException {
        GameController gameController = new GameController(stateManager, gui);

        when(stateManager.getState())
                .thenReturn(state)
                .thenReturn(state)
                .thenReturn(null);

        gameController.start();

        verify(state, times(1)).step(eq(stateManager), eq(gui), anyLong());
        verify(gui, times(1)).refresh();
        verify(gui, times(1)).close();
    }
    @Test
    void testGameLoopRespectsFrameTime() throws IOException {
        GameController gameController = new GameController(stateManager, gui);
        when(stateManager.getState())
                .thenReturn(state, state) // Frame 1
                .thenReturn(state, state) // Frame 2
                .thenReturn(state, state) // Frame 3
                .thenReturn(null);

        long startTime = System.currentTimeMillis();
        gameController.start();
        long end = System.currentTimeMillis();

        long duration = end - startTime;

        // FPS = 60 -> Frame time ~= 16ms
        // 3 frames devem demorar pelo menos 3 * 16ms = 48ms
        assertTrue(duration >= 40, "Loop ran too fast! Thread.sleep might be missing.");
    }
    @Test
    void testSleepInterruption() throws IOException, InterruptedException {
        GameController gameController = new GameController(stateManager, gui);

        when(stateManager.getState())
                .thenReturn(state)
                .thenReturn(state)
                .thenReturn(state)
                .thenReturn(null);

        Thread testThread = new Thread(() -> {
            try {
                gameController.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        testThread.start();

        testThread.interrupt();

        testThread.join(1000);

        assertFalse(testThread.isAlive());
    }
}