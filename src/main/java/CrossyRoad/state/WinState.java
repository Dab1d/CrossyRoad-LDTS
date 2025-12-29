package CrossyRoad.state;

import CrossyRoad.Controller.Controller;
import CrossyRoad.Controller.Game.SpaceController;
import CrossyRoad.Controller.Menu.WinController;
import CrossyRoad.Game;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.model.loader.Loader;
import CrossyRoad.model.loader.ScreenType;
import CrossyRoad.model.menu.Win;
import CrossyRoad.view.Viewer;
import CrossyRoad.view.game.GameViewer;
import CrossyRoad.view.menu.WinViewer;

import java.io.IOException;

public class WinState extends State<Win> {
    public WinState() throws IOException {
        super(new Win(new Loader(ScreenType.WIN.getFile()).getLines()));
    }

    @Override
    public Viewer<Win> getViewer() {
        return new WinViewer(getModel());
    }


    @Override
    public Controller<Win> getController() {
        return new WinController(getModel());
    }
}
