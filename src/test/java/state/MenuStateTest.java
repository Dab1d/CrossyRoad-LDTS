package state;

import CrossyRoad.controller.Menu.MenuController;
import CrossyRoad.model.menu.Menu;
import CrossyRoad.state.MenuState;
import CrossyRoad.view.menu.MenuView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class MenuStateTest {
    @Test
    public void testMenuStateInitialization() {
        Menu modelMock = mock(Menu.class);
        MenuView viewerMock = mock(MenuView.class);
        MenuController controllerMock = mock(MenuController.class);

        MenuState menuState = new MenuState(modelMock, controllerMock, viewerMock);

        assertNotNull(menuState.getModel());
        assertSame(modelMock, menuState.getModel());
        assertNotNull(menuState.getViewer());
        assertSame(viewerMock, menuState.getViewer());
        assertNotNull(menuState.getController());
        assertSame(controllerMock, menuState.getController());
    }
}