package nextstep.ladder.domain;

import java.util.Objects;

public class Winner {
    private final Person person;
    private final String result;

    public Winner(final Person person, final String result) {
        this.person = person;
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public String getName() {
        return person.name();
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Winner winner = (Winner) o;
        return Objects.equals(person, winner.person) && Objects.equals(result, winner.result);
    }
}
