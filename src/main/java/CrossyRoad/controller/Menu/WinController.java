package CrossyRoad.controller.Menu;


import CrossyRoad.command.QuitCommand;
import CrossyRoad.command.StartCommand;
import CrossyRoad.model.menu.Win;
import CrossyRoad.state.StateManager;


public class WinController extends MenusController<Win> {
    public WinController(Win win){
        super(win);
    }

    @Override
    protected void setupCommands(StateManager stateManager) {
        commands.put(0, new StartCommand(stateManager));
        commands.put(1, new QuitCommand(stateManager));
    }
}
