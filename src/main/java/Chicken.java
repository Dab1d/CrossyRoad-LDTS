
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

public class Chicken extends Element {
    //constructor
    public Chicken(int x, int y) {
        super(x, y);
    }

    public Position moveUp() {
        return new Position(position.getX(), position.getY() - 1);
    }

    public Position moveDown() {
        return new Position(position.getX(), position.getY() + 1);
    }

    public Position moveLeft() {
        return new Position(position.getX() - 1, position.getY());
    }

    public Position moveRight() {
        return new Position(position.getX() + 1, position.getY());
    }

    @Override// Element draw();
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FF00FF"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "><");
    }
}


