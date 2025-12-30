package CrossyRoad;

import CrossyRoad.state.GeneralStateFactory;
import CrossyRoad.state.StateManager;
import CrossyRoad.gui.LanternaGUI;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Application {
    public static void main(String[] args) {
        try {
            LanternaGUI gui = new LanternaGUI(20, 32);
            GameController controller = new GameController(new StateManager(new GeneralStateFactory()), gui);
            startApp(controller);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void startApp(GameController controller) throws IOException, URISyntaxException, FontFormatException {
        controller.start();
    }
}

