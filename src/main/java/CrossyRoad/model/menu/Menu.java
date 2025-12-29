package CrossyRoad.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu extends NavigableMenu {
    private final List<String> background;

    public Menu(List<String> background) {
        super(Arrays.asList("Start", "Help", "Exit"));
        this.background = background;
    }

    public List<String> getBackground() {
        return background;
    }
}