package CrossyRoad.command;

import CrossyRoad.Game;

import java.io.IOException;

public class PauseCommand implements Command {
    private final Game game;

    public PauseCommand(Game game) {
        this.game = game;
    }

    public void execute() throws IOException {
        game.pauseGame();
    }
}
