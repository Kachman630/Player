package ru.netology;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    public void shouldThrowExceptionIfFirstPlayerNotRegistered() {
        Game game = new Game();
        game.register(new Player(1, "P2", 10));

        // Первый игрок не найден -> Ветка if (p1 == null) сработала как true
        assertThrows(NotRegisteredException.class, () -> game.round("P1", "P2"));
    }

    @Test
    public void shouldThrowExceptionIfSecondPlayerNotRegistered() {
        Game game = new Game();
        game.register(new Player(1, "P1", 10));

        // Второй игрок не найден -> Ветка if (p2 == null) сработала как true
        assertThrows(NotRegisteredException.class, () -> game.round("P1", "P2"));
    }

    @Test
    public void shouldReturnOneIfFirstPlayerWins() {
        Game game = new Game();
        game.register(new Player(1, "P1", 20));
        game.register(new Player(2, "P2", 10));

        // Сила P1 > Силы P2 -> Ветка return 1
        assertEquals(1, game.round("P1", "P2"));
    }

    @Test
    public void shouldReturnTwoIfSecondPlayerWins() {
        Game game = new Game();
        game.register(new Player(1, "P1", 10));
        game.register(new Player(2, "P2", 20));

        // Сила P1 < Силы P2 -> Ветка return 2
        assertEquals(2, game.round("P1", "P2"));
    }

    @Test
    public void shouldReturnZeroIfDraw() {
        Game game = new Game();
        game.register(new Player(1, "P1", 15));
        game.register(new Player(2, "P2", 15));

        // Силы равны -> Ветка return 0
        assertEquals(0, game.round("P1", "P2"));
    }
}