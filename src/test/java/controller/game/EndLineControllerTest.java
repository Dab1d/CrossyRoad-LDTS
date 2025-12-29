package controller.game;

import CrossyRoad.controller.Game.EndLineController;
import CrossyRoad.state.StateManager;
import CrossyRoad.model.game.elements.Chicken;
import CrossyRoad.model.game.elements.EndLine;
import CrossyRoad.model.game.space.Space;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

class EndLineControllerTest {

    private Space space;
    private EndLineController controller;
    private StateManager game;

    @BeforeEach
    void setUp() {
        space = new Space(5, 5);

        space.setBushes(new ArrayList<>());
        space.setCars(new ArrayList<>());
        space.setTrucks(new ArrayList<>());
        space.setLogs(new ArrayList<>());
        space.setRiver(new ArrayList<>());
        space.setEndLines(new ArrayList<>());
        space.setWalls(new ArrayList<>());
        space.setCoins(new ArrayList<>());

        Chicken chicken = new Chicken(2,2);
        space.setChicken(chicken);

        controller = new EndLineController(space);
        game = mock(StateManager.class);
    }

    @Test
    void step_callsAdvanceLevel_WhenChickenIsOnEndLine() throws IOException {
        EndLine endLine = new EndLine(2,2);
        space.getEndlines().add(endLine);
        controller.step(game, null, 0);

        verify(game, times(1)).advanceLevel();
    }

    @Test
    void step_doesNothing_WhenChickenIsNotOnEndLine() throws IOException {
        EndLine endLine = new EndLine(1,1);
        space.getEndlines().add(endLine);
        controller.step(game, null, 0);

        verify(game, never()).advanceLevel();
    }
}