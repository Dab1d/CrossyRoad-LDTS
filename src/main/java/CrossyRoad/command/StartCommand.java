package CrossyRoad.command;

import CrossyRoad.state.StateManager;

import java.io.IOException;

public class StartCommand implements Command {
    private final StateManager stateManager;

    public StartCommand(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    public void execute() throws IOException {
        stateManager.initGame();
    }
}
