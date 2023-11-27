package ladder.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class NameTest {

    @Test
    void 다섯글자_초과_이름_입력_시_에러() {
        assertThatThrownBy(() -> new Name("aaaaaa")).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("이름은 5자 이하만 입력가능합니다.");
    }
}