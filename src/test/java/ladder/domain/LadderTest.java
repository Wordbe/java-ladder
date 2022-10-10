package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    void create() {
        Line line = new Line(List.of(true, false, true));
        Ladder ladder = new Ladder(4, 2, playerCount -> line);

        assertThat(ladder).isEqualTo(new Ladder(List.of(line, line)));
    }

    @Test
    void goDown() {
        Players players = new Players(List.of(
                new Player("a", 0),
                new Player("b", 1),
                new Player("c", 2),
                new Player("d", 3),
                new Player("e", 4)));
        List<Boolean> bridges = List.of(true, false, false, true);
        Line line = new Line(bridges);
        Ladder ladder = new Ladder(players.count(), 3, playerCount -> line);

        Players expected = new Players(List.of(
                new Player("a", 1),
                new Player("b", 0),
                new Player("c", 2),
                new Player("d", 4),
                new Player("e", 3)));
        assertThat(ladder.goDown(players)).isEqualTo(expected);
    }
}
