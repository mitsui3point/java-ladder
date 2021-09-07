package ladder.domain.ladder;

import static java.util.Objects.isNull;

import java.util.Objects;
import ladder.strategy.LineGenerateStrategy;

public class Point {

    private static final boolean DISCONNECT_POINT = false;
    private static final int START_POINT_INDEX = 0;
    private static final int VALUE_TO_NEXT_INDEX = 1;

    private static final String NULL_BEFORE_POINT_ERROR_MESSAGE = "이전 위치한 Point가 제공되어야 한다.";

    private final int position;

    private final boolean connected;

    public Point(int position, boolean connected) {
        this.position = position;
        this.connected = connected;
    }

    public static Point createFirst(LineGenerateStrategy lineGenerateStrategy) {
        return new Point(START_POINT_INDEX, lineGenerateStrategy.generateLine());
    }

    public static Point createLast(Point before) {
        checkBeforePointIsNull(before);

        return new Point(before.getNextPosition(), DISCONNECT_POINT);
    }

    public static Point createNextByBeforePoint(Point before, LineGenerateStrategy lineGenerateStrategy) {
        checkBeforePointIsNull(before);

        return new Point(before.getNextPosition(), createNextConnect(before, lineGenerateStrategy));
    }

    private static void checkBeforePointIsNull(Point before) {
        if (isNull(before)) {
            throw new IllegalArgumentException(NULL_BEFORE_POINT_ERROR_MESSAGE);
        }
    }

    private static boolean createNextConnect(Point before, LineGenerateStrategy lineGenerateStrategy) {
        return !before.connected && lineGenerateStrategy.generateLine();
    }

    private int getNextPosition() {
        return position + VALUE_TO_NEXT_INDEX;
    }

    public boolean isConnected() {
        return connected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return position == point.position && connected == point.connected;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, connected);
    }
}