package CrossyRoad.state;

import CrossyRoad.controller.Controller;
import CrossyRoad.controller.Menu.WinController;
import CrossyRoad.model.loader.Loader;
import CrossyRoad.model.loader.ScreenType;
import CrossyRoad.model.menu.Win;
import CrossyRoad.view.Viewer;
import CrossyRoad.view.menu.WinViewer;

import java.io.IOException;

public class WinState extends State<Win> {
    private final Controller<Win> controller;
    private final Viewer<Win> viewer;

    public WinState(Win model,Controller<Win> controller, Viewer<Win> viewer)  {
        super(model);
        this.controller = controller;
        this.viewer = viewer;
    }

    @Override
    public Viewer<Win> getViewer() {
        return viewer;
    }

    @Override
    public Controller<Win> getController() {
        return controller;
    }
}
