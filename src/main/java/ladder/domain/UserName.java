package ladder.domain;

import java.util.Objects;

public class UserName {
    private static final int MAX_LENGTH = 5;

    private static final String LENGTH_OVER_ERROR = "아름의 길이는 1이상 5이하여야 합니다.";

    private final String name;

    public UserName(String name) {
        validateLength(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if (name.length() > MAX_LENGTH || name.isEmpty()) {
            throw new IllegalArgumentException(LENGTH_OVER_ERROR);
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        UserName userName = (UserName) object;
        return Objects.equals(name, userName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public String getName() {
        return name;
    }
}
