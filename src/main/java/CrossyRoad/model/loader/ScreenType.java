package CrossyRoad.model.loader;

public enum ScreenType {
    WIN("GameScreenWin"),
    LOSE("GameOverScreen"),
    MENU("loadscreen");

    private final String file;

    ScreenType(String file) {
        this.file = file;
    }

    public String getFile() {
        return file;
    }
}
