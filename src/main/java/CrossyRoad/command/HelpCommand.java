package CrossyRoad.command;

import CrossyRoad.state.StateManager;

import java.io.IOException;


public class HelpCommand implements Command {
    private final StateManager stateManager;

    public HelpCommand(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    public void execute() throws IOException {
        stateManager.goToHelp();
    }
}
