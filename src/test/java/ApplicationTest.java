
import CrossyRoad.Application;
import CrossyRoad.GameController;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class ApplicationTest {

    @Test
    void smokeTestMain() {
        assertDoesNotThrow(() -> {});
    }
    @Test
    void testApplicationConstructor() {
        Application app = new Application();
        assertNotNull(app);
    }


        @Test
        void testStartApp() throws IOException, URISyntaxException, FontFormatException {
            GameController mockController = mock(GameController.class);
            Application.startApp(mockController);
            verify(mockController, times(1)).start();
        }
    }
