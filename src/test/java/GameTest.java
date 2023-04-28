import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netologe.tournament.Game;
import ru.netologe.tournament.NotRegisteredException;
import ru.netologe.tournament.Player;

public class GameTest {
    @Test
    public void ifFirstPlayerWin() {
        Player nikita = new Player(1, "Никита", 200);
        Player anya = new Player(2, "Аня", 300);
        Game game = new Game();

        game.register(nikita);
        game.register(anya);
        int actual = game.round("Аня", "Никита");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ifSecondPlayerWin() {
        Player nikita = new Player(1, "Никита", 200);
        Player anya = new Player(2, "Аня", 300);
        Game game = new Game();

        game.register(nikita);
        game.register(anya);
        int actual = game.round("Никита", "Аня");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ifPlayersHaveTheSameStrength() {
        Player nikita = new Player(1, "Никита", 300);
        Player anya = new Player(2, "Аня", 300);
        Game game = new Game();

        game.register(nikita);
        game.register(anya);
        int actual = game.round("Никита", "Аня");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeExeptionIfPlayer1IsNotRegistered() {
        Player nikita = new Player(1, "Никита", 300);
        Player anya = new Player(2, "Аня", 300);
        Game game = new Game();

        game.register(anya);
        game.register(nikita);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Лена", "Аня"));
    }

    @Test
    public void shouldBeExeptionIfPlayer2IsNotRegistered() {
        Player nikita = new Player(1, "Никита", 300);
        Player anya = new Player(2, "Аня", 300);
        Game game = new Game();

        game.register(nikita);
        game.register(anya);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Никита", "Коля"));
    }
}
