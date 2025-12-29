package CrossyRoad.command;

import CrossyRoad.state.StateManager;

public class QuitCommand implements Command {
    private final StateManager stateManager;
    public QuitCommand(StateManager stateManager) {
            this.stateManager = stateManager;
    }

    public void execute() {
        stateManager.quitGame();
    }
}
