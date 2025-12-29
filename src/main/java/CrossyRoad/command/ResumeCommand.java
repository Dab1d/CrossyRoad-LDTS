package CrossyRoad.command;

import CrossyRoad.state.StateManager;

public class ResumeCommand implements Command {
    private final StateManager stateManager;

    public ResumeCommand(StateManager stateManager) {
            this.stateManager = stateManager;
    }

    public void execute() {
        stateManager.resumeGame();
    }
}
