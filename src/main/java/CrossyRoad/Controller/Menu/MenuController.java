package CrossyRoad.Controller.Menu;


import CrossyRoad.command.HelpCommand;
import CrossyRoad.command.QuitCommand;
import CrossyRoad.command.StartCommand;
import CrossyRoad.model.menu.Menu;
import CrossyRoad.state.StateManager;


public class MenuController extends MenusController<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }

    @Override
    protected void setupCommands(StateManager stateManager) {
        commands.put(0, new StartCommand(stateManager));
        commands.put(1, new HelpCommand(stateManager));
        commands.put(2, new QuitCommand(stateManager));
    }
}
