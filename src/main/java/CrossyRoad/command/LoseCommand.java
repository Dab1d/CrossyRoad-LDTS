package CrossyRoad.command;

import CrossyRoad.Game;

import java.io.IOException;

public class LoseCommand implements Command {
    private final Game game;

    public LoseCommand(Game game) {
        this.game = game;
    }

    public void execute() throws IOException {
        game.loseGame();
    }
}
