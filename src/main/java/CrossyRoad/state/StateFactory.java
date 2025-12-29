package CrossyRoad.state;

import CrossyRoad.Game;
import CrossyRoad.model.game.space.LoaderSpaceBuilder;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.model.loader.Loader;
import CrossyRoad.model.loader.ScreenType;
import CrossyRoad.model.menu.Pause;
import CrossyRoad.model.menu.Win;

import java.io.IOException;
import java.util.List;

public class StateFactory {
    private final Game game;

    public StateFactory(Game game) {
        this.game = game;
    }

    public State createMenuState() throws IOException {
        return new MenuState();
    }

    public State createGameState() throws IOException {
        Space space = new LoaderSpaceBuilder(game.getLevel()).createSpace();
        return new GameState(space);
    }

    public State createPauseState() throws IOException {
        return new PauseState();
    }

    public State createWinState() throws IOException {
        return new WinState();
    }

    public State createGameOverState() throws IOException {
        return new GameOverState();
    }

    public State createHelpState() throws IOException {
        return new HelpState();
    }
}
