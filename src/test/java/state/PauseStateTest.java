package state;

import CrossyRoad.controller.Controller;
import CrossyRoad.controller.Menu.PauseController;
import CrossyRoad.model.menu.Pause;
import CrossyRoad.state.PauseState;
import CrossyRoad.view.menu.PauseViewer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class PauseStateTest {
    @Test
    public void testPauseStateInitialization() {
        Pause model = new Pause();
        Controller<Pause> controllerMock = mock(PauseController.class);
        PauseViewer viewerMock = mock(PauseViewer.class);

        PauseState pauseState = new PauseState(model, controllerMock, viewerMock);

        assertSame(model, pauseState.getModel(), "O modelo deve ser a mesma instância");
        assertSame(controllerMock, pauseState.getController(), "O controller deve ser a mesma instância");
        assertSame(viewerMock, pauseState.getViewer(), "O viewer retornado deve ser exatamente o objeto injetado");
    }
}