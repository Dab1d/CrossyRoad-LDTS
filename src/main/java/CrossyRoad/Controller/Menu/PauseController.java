package CrossyRoad.Controller.Menu;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Game;
import CrossyRoad.command.Command;
import CrossyRoad.command.QuitCommand;
import CrossyRoad.command.ResumeCommand;
import CrossyRoad.command.ReturnToMenuCommand;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.menu.Pause;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PauseController extends MenusController<Pause> {
    public PauseController(Pause pause){
        super(pause);
    }

    @Override
    protected void setupCommands(Game game){
        commands.put(0, new ResumeCommand(game));
        commands.put(1, new ReturnToMenuCommand(game));
        commands.put(2, new QuitCommand(game));
    }
}
