package nextstep.ladder;

import nextstep.ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LineTest {

    @Test
    @DisplayName("참여자의 수에 맞는 사다리 라인 생성")
    void create() {
        assertThat(new Line(5).size()).isEqualTo(5);
    }

    @Test
    @DisplayName("이전에 가로 줄이 있으면 현재 가로 줄은 없어야 한다.")
    void checkPreviousPoint() {
        Line point = new Line();
        assertThat(point.checkPreviousPoint(true)).isFalse();
    }
}