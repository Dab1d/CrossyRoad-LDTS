package CrossyRoad;

import CrossyRoad.state.StateManager;
import CrossyRoad.state.GameState;
import CrossyRoad.gui.GUI;
import CrossyRoad.view.menu.HUDView;

import java.io.IOException;

public class GameController {
    private final StateManager stateManager;
    private final GUI gui;
    private final HUDView hud;

    public GameController(StateManager stateManager, GUI gui) {
        this.stateManager = stateManager;
        this.gui = gui;
        this.hud = new HUDView();
    }

    public void start() throws IOException {
        int FPS = 60;
        int frameTime = 1000 / FPS;

        while (stateManager.getState() != null) {
            long startTime = System.currentTimeMillis();

            stateManager.getState().step(stateManager, gui, startTime);
            if (stateManager.getState() instanceof GameState)  hud.draw(gui, stateManager.getScore(), stateManager.getLevel());

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