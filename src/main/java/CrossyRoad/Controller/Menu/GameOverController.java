package CrossyRoad.Controller.Menu;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Game;
import CrossyRoad.command.Command;
import CrossyRoad.command.QuitCommand;
import CrossyRoad.command.StartCommand;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.menu.GameOver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GameOverController extends MenusController<GameOver> {
    public GameOverController(GameOver gameOver) {
        super(gameOver);
    }

    @Override
    protected void setupCommands(Game game){
        commands.put(0, new StartCommand(game));
        commands.put(1, new QuitCommand(game));
    }
}
