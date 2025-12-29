package CrossyRoad.command;

import CrossyRoad.state.StateManager;
import java.io.IOException;

public class LoseCommand implements Command {
    private final StateManager stateManager;

    public LoseCommand(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    public void execute() throws IOException {
        stateManager.loseGame();
    }
}
