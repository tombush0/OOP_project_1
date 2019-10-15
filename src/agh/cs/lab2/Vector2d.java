package agh.cs.lab2;

public class Vector2d {
    public int x;
    public int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)", x, y);
    }

    boolean precedes(Vector2d other) {
        return (this.x >= other.x && this.y >= other.y);
    }

    boolean follows(Vector2d other) {
        return (this.x <= other.x && this.y <= other.y);
    }

    Vector2d upperRight(Vector2d other) {
        Vector2d Ur = new Vector2d(Math.max(this.x, other.x), Math.max(this.y, other.y));
        return Ur;
    }

    Vector2d lowerLeft(Vector2d other) {
        Vector2d Ll = new Vector2d(Math.min(this.x, other.x), Math.min(this.y, other.y));
        return Ll;
    }

    Vector2d add(Vector2d other) {
        Vector2d sum = new Vector2d(this.x + other.x, this.y + other.y);
        return sum;
    }

    Vector2d substract(Vector2d other) {
        Vector2d diff = new Vector2d(this.x - other.x, this.y - other.y);
        return diff;
    }

    Vector2d opposite() {
        Vector2d o = new Vector2d(-this.x, -this.y);
        return o;
    }

    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;
        return this.x == that.x && this.y == that.y;
    }
}

