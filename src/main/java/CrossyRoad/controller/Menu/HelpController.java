package CrossyRoad.controller.Menu;


import CrossyRoad.command.ReturnToMenuCommand;
import CrossyRoad.command.StartCommand;

import CrossyRoad.model.menu.Help;
import CrossyRoad.state.StateManager;



public class HelpController extends MenusController<Help> {
    public HelpController(Help help) {
        super(help);
    }

    @Override
    protected void setupCommands(StateManager stateManager) {
        commands.put(0, new StartCommand(stateManager));
        commands.put(1, new ReturnToMenuCommand(stateManager));
    }
}
