package CrossyRoad.command;

import CrossyRoad.state.StateManager;
import java.io.IOException;

public class WinCommand implements Command {
    private final StateManager stateManager;

    public WinCommand(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    public void execute() throws IOException {
        stateManager.winGame();
    }
}
