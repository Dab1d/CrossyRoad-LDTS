package CrossyRoad.state;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Controller.Menu.GameOverController;
import CrossyRoad.model.loader.Loader;
import CrossyRoad.model.loader.ScreenType;
import CrossyRoad.model.menu.GameOver;
import CrossyRoad.view.Viewer;
import CrossyRoad.view.menu.GameOverView;

import java.io.IOException;

public class GameOverState extends State<GameOver> {
    public GameOverState() throws IOException {
        super(new GameOver(new Loader(ScreenType.LOSE.getFile()).getLines()));
    }

    @Override
    public Viewer<GameOver> getViewer() {
        return new GameOverView(getModel());
    }

    @Override
    public Controller<GameOver> getController() {
        return new GameOverController(getModel());
    }
}
