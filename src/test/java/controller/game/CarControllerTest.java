package controller.game;

import CrossyRoad.controller.Game.CarController;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.game.elements.Car;
import CrossyRoad.model.game.space.Space;
import CrossyRoad.state.StateManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.mockito.Mockito.*;

class CarControllerTest {
    private CarController controller;
    private Space space;
    private Car car;

    @BeforeEach
    void setUp() {
        space = mock(Space.class);
        car = mock(Car.class);
        when(space.getCars()).thenReturn(Collections.singletonList(car));
        when(space.getWidth()).thenReturn(20);
        controller = new CarController(space);
    }

    @Test
    void step_DoesNotMoveBeforeThreshold() {
        controller.step(mock(StateManager.class), GUI.ACTION.NONE, 99);
        verify(car, never()).updatePosition(anyInt());
    }

    @Test
    void step_MovesAtThreshold() {
        controller.step(mock(StateManager.class), GUI.ACTION.NONE, 100);
        verify(car, times(1)).updatePosition(20);
    }

    @Test
    void step_UpdatesLastMoveTime() {
        controller.step(mock(StateManager.class), GUI.ACTION.NONE, 100);
        verify(car, times(1)).updatePosition(anyInt());

        controller.step(mock(StateManager.class), GUI.ACTION.NONE, 150);

        verify(car, times(1)).updatePosition(anyInt());

        controller.step(mock(StateManager.class), GUI.ACTION.NONE, 200);
        verify(car, times(2)).updatePosition(anyInt());
    }
}