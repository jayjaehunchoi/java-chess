package chess.domain.game;

import chess.domain.board.Board;
import chess.domain.board.Position;
import chess.domain.move.MoveStrategy;
import chess.domain.piece.Piece;
import java.util.Map;

public class ChessGame {

    private final Board board;
    private final GameSwitch gameSwitch;
    private final Turn turn;

    public ChessGame(final Board board) {
        this.board = board;
        this.gameSwitch = new GameSwitch();
        this.turn = new Turn();
    }

    public void move(final String rawSource, final String rawTarget) {
        final Piece targetPiece = movePiece(Position.valueOf(rawSource), Position.valueOf(rawTarget));
        turnOffWhenKingDie(targetPiece);
        turn.nextTurn();
    }

    private Piece movePiece(final Position source, final Position target) {
        Piece sourcePiece = board.getPiece(source);
        validateTurn(turn, sourcePiece);
        MoveStrategy moveStrategy = sourcePiece.getMoveStrategy();
        validateMove(source, target, moveStrategy);
        return board.movePiece(source, target);
    }

    private void validateTurn(final Turn turn, final Piece sourcePiece) {
        if (!turn.isRightTurn(sourcePiece.getColor())) {
            throw new IllegalStateException("[ERROR] 당신의 차례가 아닙니다.");
        }
    }

    private void validateMove(final Position source, final Position target, final MoveStrategy moveStrategy) {
        if (!moveStrategy.isMovable(board, source, target)) {
            throw new IllegalStateException("[ERROR] 이동할 수 없습니다.");
        }
    }

    //TODO
    private void turnOffWhenKingDie(final Piece targetPiece) {
        if (targetPiece.isKing()) {
            gameSwitch.turnOff();
        }
    }

    public Score calculateScore() {
        return new Score(getCurrentBoard());
    }

    public boolean isOn() {
        return gameSwitch.isOn();
    }

    public void turnOff() {
        gameSwitch.turnOff();
    }

    public Map<Position, Piece> getCurrentBoard() {
        return board.getBoard();
    }
}
