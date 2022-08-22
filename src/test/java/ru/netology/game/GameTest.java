package ru.netology.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Player;
import ru.netology.exception.AlreadyExistsException;
import ru.netology.exception.NotRegisteredException;


public class GameTest {
    Game game = new Game();

    Player player1 = new Player(1, "Daria", 12);
    Player player2 = new Player(2, "Lida", 10);
    Player player3 = new Player(3, "Rita", 12);
    Player player4 = new Player(4, "Svetlana", 5);

    @BeforeEach
    public void setup() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
    }

    @Test
    public void shouldRegister() {
        game.register(player4);

        boolean expected = true;

        Assertions.assertEquals(expected, game.players.contains(player4));
    }

    @Test
    public void shouldPlayerAlreadyRegistered() {
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            game.register(player3);
        });
    }

    @Test
    public void shouldRoundDeadHeat() {
        int expected = 0;

        Assertions.assertEquals(expected, game.round(player1.getName(), player3.getName()));
    }

    @Test
    public void shouldRoundWinnerFirstPlayer() {
        int expected = 1;

        Assertions.assertEquals(expected, game.round(player1.getName(), player2.getName()));
    }

    @Test
    public void shouldRoundWinnerSecondPlayer() {
        int expected = 2;

        Assertions.assertEquals(expected, game.round(player2.getName(), player1.getName()));
    }

    @Test
    public void shouldRoundNotRegistered() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player1.getName(), player4.getName());
        });
    }

    @Test
    public void shouldRoundNotRegistered2() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round(player4.getName(), player1.getName());
        });
    }

}
