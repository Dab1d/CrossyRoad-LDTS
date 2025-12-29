package CrossyRoad.controller.Menu;

import CrossyRoad.controller.Controller;
import CrossyRoad.command.Command;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.menu.NavigableMenu;
import CrossyRoad.state.StateManager;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class MenusController<T extends NavigableMenu> extends Controller<T> {
    protected Map<Integer, Command> commands = new HashMap<>();

    public MenusController(T model) {
        super(model);
    }

    protected abstract void setupCommands(StateManager stateManager);

    @Override
    public void step(StateManager stateManager, GUI.ACTION action, long startTime) throws IOException {
        if(commands.isEmpty()) setupCommands(stateManager);

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
