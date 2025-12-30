package state;

import CrossyRoad.controller.Menu.HelpController;
import CrossyRoad.model.menu.Help;
import CrossyRoad.state.HelpState;
import CrossyRoad.view.menu.HelpView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class HelpStateTest {
    @Test
    public void testHelpStateInitialization() {
        Help model = new Help();
        HelpView viewerMock = mock(HelpView.class);
        HelpController controllerMock = mock(HelpController.class);

        HelpState helpState = new HelpState(model, controllerMock, viewerMock);

        assertEquals(model, helpState.getModel());
        assertSame(viewerMock, helpState.getViewer());
        assertSame(controllerMock, helpState.getController());
    }
}