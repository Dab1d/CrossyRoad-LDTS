package CrossyRoad;

import CrossyRoad.gui.GUI;
import CrossyRoad.gui.LanternaGUI;
import CrossyRoad.model.game.space.LoaderSpaceBuilder;
import CrossyRoad.model.loader.Loader;
import CrossyRoad.model.loader.ScreenType;
import CrossyRoad.model.menu.*;
import CrossyRoad.model.menu.Menu;
import CrossyRoad.state.*;
import CrossyRoad.view.menu.HUDView;


import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private State state;
    private State previousState;
    private int level;
    private int score;
    private HUDView hud;
    private StateFactory stateFactory;
    private static final int FINAL_LEVEL = 5;

    public Game() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI(20, 32);
        this.stateFactory = new StateFactory(this);
        this.state = this.stateFactory.createMenuState();
        this.level = 1;
        this.score = 0;
        this.hud = new HUDView();
    }

    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        new Game().start();
    }

    public void setPrevious(State state) {
        this.previousState = state;
    }

    public State getPrevious() {
        return this.previousState;
    }

    public State getState() {
        return this.state;
    }

    public int getLevel() {
        return level;
    }

    public void addScore() {
        score++;
    }

    public int getScore() {
        return score;
    }

    public HUDView getHUD() {
        return hud;
    }

    public void resetScore() {
        this.score = 0;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void initGame() throws IOException {
        this.score = 0;
        this.level = 1;
        this.setState(stateFactory.createGameState());
    }

    public void quitGame() {
        this.setState(null);
    }

    public void pauseGame() throws IOException {
        this.previousState = this.state;
        this.setState(this.stateFactory.createPauseState());
    }

    public void resumeGame() {
        this.setState(this.getPrevious());
    }

    public void returnToMenu() throws IOException {
        this.level = 1;
        this.score = 0;
        this.setState(this.stateFactory.createMenuState());
    }

    public void goToHelp() throws IOException {
        this.setState(this.stateFactory.createHelpState());
    }

    public void winGame() throws IOException {
        this.setState(this.stateFactory.createWinState());
    }


    public void advanceLevel() throws IOException {
        if(this.level < FINAL_LEVEL) {
            this.level++;
            this.setState(this.stateFactory.createGameState());
        } else {
            this.winGame();
        }
    }

    public void loseGame() throws IOException {
        this.level = 1;
        this.score = 0;
        Loader loader = new Loader(ScreenType.LOSE.getFile());
        GameOver gameOver = new GameOver(loader.getLines());
        this.setState(this.stateFactory.createGameOverState());
    }


    public void start() throws IOException {
        int FPS = 60;
        int frameTime = 1000 / FPS;
        while (state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);
            hud.draw(gui, this.getScore(),this.getLevel());

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;
            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        gui.close();
    }

    public GUI getGUI() {
        return gui;
    }
}
