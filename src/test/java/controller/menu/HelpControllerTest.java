package controller.menu;


import CrossyRoad.Controller.Menu.HelpController;
import CrossyRoad.state.StateManager;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.menu.Help;
import CrossyRoad.state.GameState;
import CrossyRoad.state.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class HelpControllerTest {
    private HelpController controller;
<<<<<<< HEAD

    @Mock
    private Help helpMock;

    @Mock
    private StateManager gameMock;
=======
    @Mock private Help helpMock;
    @Mock private Game gameMock;
>>>>>>> 7801c4d4e6a6a8f61d8ca0cd1716e2159a9b9160

    @BeforeEach
    void setUp() { controller = new HelpController(helpMock); }

    @Test
    void stepSelect_Start() throws Exception {
        when(helpMock.getCurrentEntry()).thenReturn(0);
        controller.step(gameMock, GUI.ACTION.SELECT, 0);
        verify(gameMock).initGame();
    }

    @Test
    void stepSelect_Return() throws Exception {
        when(helpMock.getCurrentEntry()).thenReturn(1);
        controller.step(gameMock, GUI.ACTION.SELECT, 0);
        verify(gameMock).returnToMenu();
    }
}