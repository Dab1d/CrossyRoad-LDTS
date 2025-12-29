package CrossyRoad.state;

import java.io.IOException;

public interface StateFactory {
    State createMenuState() throws IOException;
    State createGameState(int level) throws IOException;
    State createPauseState() throws IOException;
    State createWinState() throws IOException;
    State createGameOverState() throws IOException;
    State createHelpState() throws IOException;
}