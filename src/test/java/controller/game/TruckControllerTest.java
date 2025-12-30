package controller.game;

import CrossyRoad.controller.Game.TruckController;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.elements.Truck;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.state.StateManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.mockito.Mockito.*;

class TruckControllerTest {
    private TruckController controller;
    private Space space;
    private Truck truck;

    @BeforeEach
    void setUp() {
        space = mock(Space.class);
        truck = mock(Truck.class);
        when(space.getTruck()).thenReturn(Collections.singletonList(truck));
        when(space.getWidth()).thenReturn(20);
        controller = new TruckController(space);
    }

    @Test
    void step_MovesAtCorrectInterval() {
        // Tenta mover antes de 350ms (349ms)
        controller.step(mock(StateManager.class), GUI.ACTION.NONE, 349);
        verify(truck, never()).updatePosition(anyInt());

        // Tenta mover aos 350ms
        controller.step(mock(StateManager.class), GUI.ACTION.NONE, 350);
        verify(truck, times(1)).updatePosition(20);
    }

    @Test
    void step_MathMutationKiller() {
        // 1. Move aos 350ms (lastMoveTime = 350)
        controller.step(mock(StateManager.class), GUI.ACTION.NONE, 350);

        // 2. Tenta mover aos 400ms.
        // Correto: 400 - 350 = 50 (Falso)
        controller.step(mock(StateManager.class), GUI.ACTION.NONE, 400);
        verify(truck, times(1)).updatePosition(anyInt());
    }
}