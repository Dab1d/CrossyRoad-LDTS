package state;

import CrossyRoad.controller.Menu.GameOverController;
import CrossyRoad.model.menu.GameOver;
import CrossyRoad.state.GameOverState;
import CrossyRoad.view.menu.GameOverView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class GameOverStateTest {
    @Test
    public void gameOverStateInitializationTest() {
        GameOver modelMock = mock(GameOver.class);
        GameOverController controllerMock = mock(GameOverController.class);
        GameOverView viewerMock = mock(GameOverView.class);

        GameOverState state = new GameOverState(modelMock, controllerMock, viewerMock);

        assertNotNull(state.getModel());
        assertEquals(modelMock, state.getModel());
        assertNotNull(state.getController());
        assertEquals(controllerMock, state.getController());
        assertNotNull(state.getViewer());
        assertSame(viewerMock, state.getViewer(), "O viewer retornado deve ser o mesmo injetado no construtor");
    }
}