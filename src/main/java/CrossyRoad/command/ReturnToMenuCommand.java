package CrossyRoad.command;

import CrossyRoad.state.StateManager;
import java.io.IOException;

public class ReturnToMenuCommand implements Command {
    private final StateManager stateManager;

    public ReturnToMenuCommand(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    public void execute() throws IOException {
        stateManager.returnToMenu();
    }
}
