package CrossyRoad.Controller.Menu;

import CrossyRoad.command.QuitCommand;
import CrossyRoad.command.StartCommand;
import CrossyRoad.model.menu.GameOver;
import CrossyRoad.state.StateManager;


public class GameOverController extends MenusController<GameOver> {
    public GameOverController(GameOver gameOver) {
        super(gameOver);
    }

    @Override
    protected void setupCommands(StateManager stateManager){
        commands.put(0, new StartCommand(stateManager));
        commands.put(1, new QuitCommand(stateManager));
    }
}
