package CrossyRoad.model.menu;

import java.util.Arrays;
import java.util.List;

public class Win extends NavigableMenu {
    private final List<String> background;

    public Win(List<String> entries) {
        super(Arrays.asList("Restart", "Exit"));
        this.background = entries;
    }

    public List<String> getBackground() {
        return background;
    }

}
