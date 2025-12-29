package CrossyRoad.command;

import CrossyRoad.state.StateManager;

import java.io.IOException;

public class PauseCommand implements Command {
    private final StateManager stateManager;

    public PauseCommand(StateManager stateManager) {
            this.stateManager = stateManager;
    }

    public void execute() throws IOException {
        stateManager.pauseGame();
    }
}
