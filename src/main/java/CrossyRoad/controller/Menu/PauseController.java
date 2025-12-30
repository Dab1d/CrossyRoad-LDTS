package CrossyRoad.controller.Menu;


import CrossyRoad.command.QuitCommand;
import CrossyRoad.command.ResumeCommand;
import CrossyRoad.command.ReturnToMenuCommand;
import CrossyRoad.model.menu.Pause;
import CrossyRoad.state.StateManager;


public class PauseController extends MenusController<Pause> {
    public PauseController(Pause pause){
        super(pause);
    }

    @Override
    protected void setupCommands(StateManager stateManager){
        commands.put(0, new ResumeCommand(stateManager));
        commands.put(1, new ReturnToMenuCommand(stateManager));
        commands.put(2, new QuitCommand(stateManager));
    }
}
