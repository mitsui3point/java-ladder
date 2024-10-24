package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Line {
    private final List<Boolean> points = new ArrayList<>();

    public Line(final List<Boolean> points) {
        if (hasConsecutiveTrues(points)) {
            throw new IllegalArgumentException("Consecutive true points are not allowed");
        }
        this.points.addAll(points);
    }

    private boolean hasConsecutiveTrues(final List<Boolean> points) {
        return IntStream.range(1, points.size())
                .anyMatch(index -> points.get(index) && points.get(index - 1));
    }

    public int size() {
        return points.size();
    }

    public boolean isPointTrue(int index) {
        return points.get(index);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(points, line.points);
    }
}
