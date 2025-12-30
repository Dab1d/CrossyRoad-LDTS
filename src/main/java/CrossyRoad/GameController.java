package CrossyRoad;

import CrossyRoad.state.StateManager;
import CrossyRoad.gui.GUI;

import java.io.IOException;

public class GameController {
    private final StateManager stateManager;
    private final GUI gui;

    public GameController(StateManager stateManager, GUI gui) {
        this.stateManager = stateManager;
        this.gui = gui;
    }

    public void start() throws IOException {
        int FPS = 60;
        int frameTime = 1000 / FPS;

        while (stateManager.getState() != null) {
            long startTime = System.currentTimeMillis();

            stateManager.getState().step(stateManager, gui, startTime);
            gui.refresh();

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;
            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        gui.close();
    }
}