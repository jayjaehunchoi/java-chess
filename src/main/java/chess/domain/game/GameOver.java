package chess.domain.game;

import java.util.Objects;

public class GameOver {

    private boolean gameOver;

    public GameOver() {
        gameOver = false;
    }

    public GameOver(final boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void changeGameOver() {
        gameOver = !gameOver;
    }

}
