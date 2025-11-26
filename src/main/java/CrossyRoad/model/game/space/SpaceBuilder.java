package CrossyRoad.model.game.space;

import CrossyRoad.model.game.elements.Bush;
import CrossyRoad.model.game.elements.Chicken;
import CrossyRoad.model.game.elements.Wall;

import java.util.List;

/** pode nao ser necessário implementar se nao fizemos niveis */
public abstract class SpaceBuilder {
    public Space createSpace() {
        Space space = new Space(getWidth(), getHeight());
        space.setBushes(creatBushes());
        space.setChicken(createChicken());
        space.setWalls(createWalls());
        return space;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Bush> creatBushes();

    protected abstract List<Wall> createWalls();

    protected abstract Chicken createChicken();
}
