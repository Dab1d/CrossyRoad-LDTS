package controller.menu;

import CrossyRoad.Controller.Menu.WinController;
import CrossyRoad.Game;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.menu.Win;
import CrossyRoad.state.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WinControllerTest {
    private WinController controller;
    @Mock private Win winMock;
    @Mock private Game gameMock;

    @BeforeEach
    void setUp() { controller = new WinController(winMock); }

    @Test
    void stepSelect_Restart() throws Exception {
        when(winMock.getCurrentEntry()).thenReturn(0);
        controller.step(gameMock, GUI.ACTION.SELECT, 0);
        verify(gameMock).initGame();
    }

    @Test
    void stepSelect_Quit() throws Exception {
        when(winMock.getCurrentEntry()).thenReturn(1);
        controller.step(gameMock, GUI.ACTION.SELECT, 0);
        verify(gameMock).quitGame();
    }
}
