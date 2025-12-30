package state;

import CrossyRoad.controller.Game.SpaceController;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.state.GameState;
import CrossyRoad.view.Viewer;
import CrossyRoad.view.game.GameViewer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class GameStateTest {
    @Test
    public void gameStateInitializationTest() {
        Space spaceMock = mock(Space.class);
        GameViewer viewerMock = mock(GameViewer.class);
        SpaceController controllerMock = mock(SpaceController.class);

        GameState state = new GameState(spaceMock, controllerMock, viewerMock);

        assertNotNull(state.getModel());
        assertSame(spaceMock, state.getModel());
        assertNotNull(state.getController());
        assertSame(controllerMock, state.getController());
        Viewer<Space> viewer = state.getViewer();
        assertNotNull(viewer);
        assertSame(viewerMock, viewer, "O viewer retornado deve ser a mesma instância injetada");
    }
}