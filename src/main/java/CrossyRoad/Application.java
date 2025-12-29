package CrossyRoad;

import CrossyRoad.state.StateManager;
import CrossyRoad.state.StateFactory;
import CrossyRoad.gui.LanternaGUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Application {
    public static void main(String[] args) {
        try {
            LanternaGUI gui = new LanternaGUI(20, 32);
            GameController controller = new GameController(new StateManager(new StateFactory()), gui);

            controller.start();

        } catch (IOException | URISyntaxException | FontFormatException e) {
            e.printStackTrace();
        }
    }
}