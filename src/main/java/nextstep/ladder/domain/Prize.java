package nextstep.ladder.domain;

public class Prize {
    private final String prize;

    public Prize(String prize) {
        this.prize = prize;
    }

    public String getValue() {
        return prize;
    }
}
