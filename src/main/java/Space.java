import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Space {

    private int width;
    private int height;
    private  int min_x;
    private  int max_x;

    public Space(int width, int height) {
        this.width = width;
        this.height = height;
        this.min_x = 1;
        this.max_x = width - 2;
    }

    public void draw(TextGraphics graphics) {
        /** background */
        graphics.setBackgroundColor(TextColor.Factory.fromString("#100091"));
        graphics.fillRectangle(new TerminalPosition(0,0), new TerminalSize(width, height), ' ');

        graphics.putString(5,5, "*_*"); // teste provisório
    }
    /** setters */
    public void setWidth(int width) {
        this.width = width;

    }
    public void setHeight(int height) {
        this.height = height;
    }

    /** getters */
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getMin_x() {
        return min_x;
    }
    public int getMax_x() {
        return max_x;
    }
}
