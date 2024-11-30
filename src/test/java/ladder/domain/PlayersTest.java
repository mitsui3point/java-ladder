package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {

    public static final Players PLAYERS1 = new Players("pobi,crong,honux,jk");

    private Players players;
    private PlayerName playerName1;
    private PlayerName playerName2;
    private PlayerName playerName3;
    private PlayerName playerName4;

    private Point firstPoint;
    private Point next1Point;
    private Point next2Point;
    private Point lastPoint;

    @BeforeEach
    void setUp() {
        playerName1 = new PlayerName("pobi");
        playerName2 = new PlayerName("crong");
        playerName3 = new PlayerName("honux");
        playerName4 = new PlayerName("jk");

        firstPoint = Point.first(true);
        next1Point = firstPoint.next(false);
        next2Point = next1Point.next(true);
        lastPoint = next2Point.last();

        players = new Players("pobi,crong,honux,jk");
    }

    @Test
    @DisplayName("플레이어 목록을 생성한다")
    void create() {
        Players expected = new Players(List.of(playerName1, playerName2, playerName3, playerName4), new Vertical());

        assertThat(players).isEqualTo(expected);
    }

    @Test
    @DisplayName("플레이어 목록의 size 를 출력한다")
    void size() {
        int actual = players.size();
        assertThat(actual).isEqualTo(4);
    }

    @Test
    @DisplayName("플레이어 목록의 이름을 출력한다")
    void names() {
        List<PlayerName> actual = players.names();
        List<PlayerName> expected = List.of(
                new PlayerName("pobi"),
                new PlayerName("crong"),
                new PlayerName("honux"),
                new PlayerName("jk")
        );

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void verticalPosition() {
        players = new Players(List.of(new PlayerName("pobi"), new PlayerName("crong"), new PlayerName("honux"), new PlayerName("jk")), new Vertical(1));

        Vertical actual = players.vertical();
        Vertical expected = new Vertical(1);

        assertThat(actual).isEqualTo(expected);
    }
}