package controller.game;

import CrossyRoad.controller.Game.RiverController;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.elements.River;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.state.StateManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.mockito.Mockito.*;

class RiverControllerTest {
    private RiverController controller;
    private Space space;
    private River river;

    @BeforeEach
    void setUp() {
        space = mock(Space.class);
        river = mock(River.class);
        when(space.getRiver()).thenReturn(Collections.singletonList(river));
        when(space.getWidth()).thenReturn(20);
        controller = new RiverController(space);
    }

    @Test
    void step_FlowsAtCorrectInterval() {
        // 199ms -> Não flui
        controller.step(mock(StateManager.class), GUI.ACTION.NONE, 199);
        verify(river, never()).updateRiver(anyInt());

        // 200ms -> Flui
        controller.step(mock(StateManager.class), GUI.ACTION.NONE, 200);
        verify(river, times(1)).updateRiver(20);
    }

    @Test
    void step_AccumulatesTimeCorrectly() {
        // Move 1: 200ms
        controller.step(mock(StateManager.class), GUI.ACTION.NONE, 200);
        // Move 2: 400ms (Delta = 200)
        controller.step(mock(StateManager.class), GUI.ACTION.NONE, 400);

        verify(river, times(2)).updateRiver(anyInt());
    }
    @Test
    void step_MathMutationKiller() {
        controller.step(mock(StateManager.class), GUI.ACTION.NONE, 200);
        verify(river, times(1)).updateRiver(anyInt());
        controller.step(mock(StateManager.class), GUI.ACTION.NONE, 250);
        verify(river, times(1)).updateRiver(anyInt());
    }
}