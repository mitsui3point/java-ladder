package ladder.domain;

import ladder.exception.InvalidNameException;

import java.util.Objects;

public class Name {
    public static final String NOT_ALLOW_EMPTY_NAME_MESSAGE = "이름에 공백이 들어갈 수 없습니다.";
    public static final String NOT_ALLOW_EXCEED_MAX_NAME_LENGTH_MESSAGE = "이름을 5글자를 초과할수 없습니다.";
    public static final int NAME_MAX_LENGTH = 5;
    public static final String NAME_EMPTY_STRING = "";

    private final String name;

    public Name(String name) {
        if (name == null || name.equals(NAME_EMPTY_STRING)) {
            throw new InvalidNameException(NOT_ALLOW_EMPTY_NAME_MESSAGE);
        }
        if (name.length() > NAME_MAX_LENGTH) {
            throw new InvalidNameException(NOT_ALLOW_EXCEED_MAX_NAME_LENGTH_MESSAGE);
        }

        this.name = name;
    }

    public int length() {
        return name.length();
    }

    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
