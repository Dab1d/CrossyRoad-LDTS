package CrossyRoad.Controller.Game;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.game.space.LoaderSpaceBuilder;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.model.game.elements.EndLine;
import CrossyRoad.model.loader.Loader;
import CrossyRoad.model.loader.ScreenType;
import CrossyRoad.model.menu.Win;
import CrossyRoad.state.GameState;
import CrossyRoad.state.WinState;

import java.io.IOException;

public class EndLineController extends Controller<Space> {
    private static final int FINAL_LEVEL = 5;

    public EndLineController(Space space) {
        super(space);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        Position chickenPos = getModel().getChicken().getPosition();
        for (EndLine endline : getModel().getEndlines()) {
            if (chickenPos.equals(endline.getPosition())) {

                if (game.getLevel() < FINAL_LEVEL) {
                    game.setLevel(game.getLevel() + 1);
                    game.setState(new GameState(new LoaderSpaceBuilder(game.getLevel()).createSpace()));
                }
                else {
                    Loader loader = new Loader(ScreenType.WIN.getFile());
                    Win winMenu = new Win(loader.getLines());
                    game.setState(new WinState(winMenu));
                }
                return;
            }
        }
    }
}