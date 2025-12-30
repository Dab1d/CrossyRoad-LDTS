package state;

import CrossyRoad.controller.Menu.WinController;
import CrossyRoad.model.menu.Win;
import CrossyRoad.state.WinState;
import CrossyRoad.view.menu.WinViewer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class WinStateTest {

    @Test
    public void testWinStateInitialization() {
        Win winModel = mock(Win.class);
        WinController winController = mock(WinController.class);
        WinViewer winViewer = mock(WinViewer.class);
        WinState winState = new WinState(winModel, winController, winViewer);

        assertEquals(winModel, winState.getModel(), "O modelo retornado deve ser o mesmo injetado");
        assertEquals(winViewer, winState.getViewer(), "O viewer retornado deve ser o mesmo injetado");
        assertEquals(winController, winState.getController(), "O controller retornado deve ser o mesmo injetado");
    }
}