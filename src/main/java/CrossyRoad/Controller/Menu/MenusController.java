package CrossyRoad.Controller.Menu;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Game;
import CrossyRoad.command.Command;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.menu.NavigableMenu;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class MenusController<T extends NavigableMenu> extends Controller<T> {
    protected Map<Integer, Command> commands = new HashMap<>();

    public MenusController(T model) {
        super(model);
    }

    protected abstract void setupCommands(Game game);

    @Override
    public void step(Game game, GUI.ACTION action, long startTime) throws IOException {
        if(commands.isEmpty()) setupCommands(game);

        switch (action) {
            case LEFT:
            case UP:
                getModel().previousEntry();
                break;
            case RIGHT:
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                int currentOption = getModel().getCurrentEntry();
                if (commands.containsKey(currentOption)) {
                    commands.get(currentOption).execute();
                }
                break;
        }
    };
}
