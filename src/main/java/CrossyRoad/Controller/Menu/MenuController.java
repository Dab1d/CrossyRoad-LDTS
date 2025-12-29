package CrossyRoad.Controller.Menu;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Game;
import CrossyRoad.command.Command;
import CrossyRoad.command.HelpCommand;
import CrossyRoad.command.QuitCommand;
import CrossyRoad.command.StartCommand;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.menu.Menu;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MenuController extends MenusController<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }

    @Override
    protected void setupCommands(Game game) {
        commands.put(0, new StartCommand(game));
        commands.put(1, new HelpCommand(game));
        commands.put(2, new QuitCommand(game));
    }
}
