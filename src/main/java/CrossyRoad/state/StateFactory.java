package CrossyRoad.state;

import CrossyRoad.model.game.space.LoaderSpaceBuilder;
import CrossyRoad.model.game.space.Space;

import java.io.IOException;

public class StateFactory {


    public State createMenuState() throws IOException {
        return new MenuState();
    }

    public State createGameState(int level) throws IOException {
        Space space = new LoaderSpaceBuilder(level).createSpace();
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