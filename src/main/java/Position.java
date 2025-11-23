public class Position {
    private int x_;
    private int y_;

    public Position(int x, int y) {
        this.x_ = x;
        this.y_ = y;
    }

    public int getX() {
        return x_;
    }
    public int getY() {
        return y_;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null) return false;

        if (getClass() != o.getClass()) return false;

        Position p = (Position) o;
        return x_ == p.getX() && y_ == p.getY();
    }
}