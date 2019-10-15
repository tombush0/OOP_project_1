package agh.cs.lab2;

public enum MapDirection {
    NORTH, SOUTH, WEST, EAST;

    @Override
    public String toString() {
        switch (this) {
            case NORTH:
                return "Północ";
            case SOUTH:
                return "Południe";
            case WEST:
                return "Zachód";
            case EAST:
                return "Wschód";
        }
        return null;
    }

    public MapDirection next() {
        switch (this) {
            case NORTH:
                return EAST;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
            case EAST:
                return SOUTH;
        }
        return null;
    }

    public MapDirection previous() {
        switch (this) {
            case NORTH:
                return WEST;
            case SOUTH:
                return EAST;
            case WEST:
                return SOUTH;
            case EAST:
                return NORTH;
        }
        return null;
    }

    public Vector2d toUnitVector() {
        int x = 0, y = 0;
        switch (this) {
            case NORTH:
                x = 0;
                y = 1;
            case SOUTH:
                x = 0;
                y = -1;
            case WEST:
                x = -1;
                y = 0;
            case EAST:
                x = 1;
                y = 0;
        }
        Vector2d u = new Vector2d(x, y);
        return u;
    }
}
