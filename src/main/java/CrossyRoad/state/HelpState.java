package CrossyRoad.state;

import CrossyRoad.controller.Controller;
import CrossyRoad.controller.Menu.HelpController;
import CrossyRoad.model.menu.Help;
import CrossyRoad.model.menu.Win;
import CrossyRoad.view.Viewer;
import CrossyRoad.view.menu.HelpView;

public class HelpState extends State<Help> {
    private final Controller<Help> controller;
    private final Viewer<Help> viewer;

    public HelpState(Help model, Controller<Help> controller, Viewer<Help> viewer) {
        super(model);
        this.controller = controller;
        this.viewer = viewer;
    }

    @Override
    public Viewer<Help> getViewer() {
        return new HelpView(getModel());
    }

    @Override
    public Controller<Help> getController() {
        return controller;
    }
}
