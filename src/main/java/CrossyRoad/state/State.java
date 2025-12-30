package CrossyRoad.state;

import CrossyRoad.controller.Controller;
import CrossyRoad.gui.GUI;
import CrossyRoad.view.Viewer;

import java.io.IOException;

public abstract class State<T> {
    private T model;

    public State(T model) {
        this.model = model;
    }

    // for mock testing
    public State(T model, Viewer<T> viewer, Controller<T> controller) {
        this.model = model;
    }

    public abstract Viewer<T> getViewer();

    public abstract Controller<T> getController();

    public T getModel() {
        return model;
    }

    public void step(StateManager game, GUI gui, long startTime) throws IOException {
        GUI.ACTION action = gui.getNextAction();
        getController().step(game, action, startTime);

        gui.clear();
        getViewer().draw(gui);

    }
}