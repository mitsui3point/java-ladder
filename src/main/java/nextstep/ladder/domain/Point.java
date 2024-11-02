package nextstep.ladder.domain;

import java.util.Objects;

public class Point {

    private static final int LEFT = -1;
    private static final int RIGHT = 1;
    private static final int DOWN = 0;

    private boolean left;
    private boolean right;

    public Point(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public Point() {
        this(false, false);
    }

    public boolean isRightConnected() {
        return right;
    }

    public int getDirection() {
        if (left) {
            return LEFT;
        }
        if (right) {
            return RIGHT;
        }
        return DOWN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return left == point.left && right == point.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }
}
