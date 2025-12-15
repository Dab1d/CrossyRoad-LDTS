package CrossyRoad.Controller.Game;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.model.menu.Menu;
import CrossyRoad.state.MenuState;

public class ScoreController extends Controller<Space> {

    public ScoreController(Space space) {
        super(space);
    }

    public void addPoints(int points) {
        getModel().getScore().addPoints(points);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.QUIT)  getModel().getScore().reset();
    }

}

