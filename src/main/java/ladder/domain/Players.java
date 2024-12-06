package ladder.domain;

import ladder.exception.PlayersCountException;
import ladder.exception.PlayersException;

import java.util.*;
import java.util.stream.Collectors;

public class Players {

    public static final String DELIMITER = ",";
    public static final int MINIMAL_PLAYERS_SIZE = 1;
    public static final String NOT_ENOUGH_PLAYERS_SIZE_MESSAGE = "플레이어는 최소 1명 이상이어야 합니다";
    private final List<PlayerName> playerNames;
    private final Vertical vertical;

    public Players(List<PlayerName> playerNames, Vertical vertical) {
        if (playerNames.size() < MINIMAL_PLAYERS_SIZE) {
            throw new PlayersException(NOT_ENOUGH_PLAYERS_SIZE_MESSAGE);
        }
        this.playerNames = playerNames;
        this.vertical = vertical;
    }

    public Players(String playerNames) {
        this(toNames(playerNames), new Vertical());
    }

    public int size() {
        return playerNames.size();
    }

    private static List<PlayerName> toNames(String names) {
        return Arrays.stream(names.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList())
                .stream()
                .map(PlayerName::new)
                .collect(Collectors.toList());
    }

    public List<PlayerName> names() {
        return Collections.unmodifiableList(playerNames);
    }

    public Vertical vertical() {
        return vertical;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players players = (Players) o;
        return Objects.equals(playerNames, players.playerNames) && Objects.equals(vertical, players.vertical);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerNames, vertical);
    }

    @Override
    public String toString() {
        return "Players{" +
                "names=" + playerNames +
                ", vertical=" + vertical +
                '}';
    }
}