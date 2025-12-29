package CrossyRoad.Controller.Menu;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Game;
import CrossyRoad.command.Command;
import CrossyRoad.command.ReturnToMenuCommand;
import CrossyRoad.command.StartCommand;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.menu.Help;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HelpController extends MenusController<Help> {
    public HelpController(Help help) {
        super(help);
    }

    @Override
    protected void setupCommands(Game game) {
        commands.put(0, new StartCommand(game));
        commands.put(1, new ReturnToMenuCommand(game));
    }
}
