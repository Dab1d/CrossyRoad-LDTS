package CrossyRoad.state;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class StateManager {
    private final StateFactory stateFactory;
    private State state;
    private State previousState;
    private int level;
    private int score;
    private static final int FINAL_LEVEL = 5;


    public StateManager(StateFactory stateFactory) throws IOException, URISyntaxException, FontFormatException {
        this.stateFactory = stateFactory;
        resetLevel();
        resetScore();
        this.state = stateFactory.createMenuState();
    }

    public void initGame() throws IOException {
        resetScore();
        resetLevel();
        this.setState(stateFactory.createGameState(getLevel()));
    }

    public void quitGame() {
        this.setState(null);
    }

    public void pauseGame() throws IOException {
        setPrevious(state);
        setState(stateFactory.createPauseState());
    }

    public void resumeGame() {
        setState(this.getPrevious());
    }

    public void returnToMenu() throws IOException {
        resetLevel();
        resetScore();
        setState(stateFactory.createMenuState());
    }

    public void goToHelp() throws IOException {
        setState(stateFactory.createHelpState());
    }

    public void winGame() throws IOException {
        setState(stateFactory.createWinState());
    }

    public void advanceLevel() throws IOException {
        if(this.level < FINAL_LEVEL) {
            this.level++;
            this.setState(stateFactory.createGameState(getLevel()));
        } else {
            this.finishGame();
        }
    }

    public void finishGame() throws IOException {
        winGame();
    }

    public void loseGame() throws IOException {
        resetLevel();
        resetScore();
        setState(stateFactory.createGameOverState());
    }


    public void setState(State state) { this.state = state; }
    public State getState() { return this.state; }
    public void setPrevious(State state) { this.previousState = state; }
    public State getPrevious() { return this.previousState; }
    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }
    public int getScore() { return score; }
    public void addScore() { score++; }
    public void resetScore() { this.score = 0;}
    public void resetLevel() { this.level =1;}
}