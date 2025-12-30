package CrossyRoad.controller.Game;

import CrossyRoad.controller.Controller;
import CrossyRoad.session.GameSession;
import CrossyRoad.state.StateManager;
import CrossyRoad.gui.GUI;
import CrossyRoad.model.Position;
import CrossyRoad.model.game.elements.Coin;
import CrossyRoad.model.game.space.Space;

import java.util.Iterator;

public class CoinController extends Controller<Space> {

    public CoinController(Space space) {
        super(space);
    }

    @Override
    public void step(StateManager stateManager, GUI.ACTION action, long time) {
        Position chickenPos = getModel().getChicken().getPosition();

        Iterator<Coin> it = getModel().getCoins().iterator();

        while (it.hasNext()) {
            Coin coin = it.next();
            if (coin.getPosition().equals(chickenPos)) {
                GameSession session = stateManager.getGameSession();
                session.addScore();
                it.remove();
            }
        }
    }
}