package Model;

import designpattern.Observer;
import java.util.ArrayList;
import java.util.List;

/**
 * The Game class is used to build the game and implement the Model interface.
 *
 * @author Marika Winska 55047
 */
public class Game implements Model {

    private Board board;
    private final List<Observer> observers;

    /**
     * Initializes the game board with the first cell.
     */
    public Game() {
        this.observers = new ArrayList<>();
        initGame(2);
    }

    /**
     * Initializes the game with a chosen number of cells at the beginning of
     * the game.
     *
     * @param numberCell number of cells when the game starts.
     */
    @Override
    public final void initGame(int numberCell) {
        this.board = new Board(4);
        for (int i = 0; i < numberCell; i++) {
            this.board.addCell();
        }
        notifyObservers("Nouvelle partie créée ! ");
    }

    /**
     * Getter of the board.
     *
     * @return the board.
     */
    @Override
    public Board getBoard() {
        return board;
    }

    /**
     * Setter of the board.
     *
     * @param board the new board.
     */
    void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Performs movement in the given direction.
     *
     * @param direction given.
     */
    @Override
    public void move(Direction direction) {
        if (direction == null) {
            throw new IllegalArgumentException("Invalid argument.");
        }
        if (!isWon()) {
            Cell[][] boardBeforeMove = board.getCopyBoard();
            board.move(direction);
            if (isWon()) {
                notifyObservers("Félicitations vous avez gagné ! ");
            } else if (!canMove()) {
                notifyObservers("Vous avez perdu ! ");
            } else if (!wasMoveMade(boardBeforeMove)) {
                notifyObservers("Mouvement impossible ! ");
            } else {
                this.board.addCell();
                notifyObservers();
            }
        }
    }

    /**
     * Checks whether the user can still perform a movement.
     *
     * @return true if there is at least one movement of possible, false
     * otherwise.
     */
    @Override
    public boolean canMove() {
        if (!board.isCompleted()) {
            return true;
        }
        for (int row = 0; row < board.getSize(); row++) {
            for (int column = 0; column < board.getSize(); column++) {
                Cell caseChecked = board.getCopyBoard()[row][column];
                if (((row < board.getSize() - 1)
                        && (caseChecked.getNumber()
                        == board.getCopyBoard()[row + 1][column].getNumber()))
                        || ((column < board.getSize() - 1)
                        && (caseChecked.getNumber()
                        == board.getCopyBoard()[row][column + 1].getNumber()))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if the game is won.The game is won when there is the number 2048
     * in the game board.
     *
     * @return true if the game is won, false otherwise.
     */
    @Override
    public boolean isWon() {
        if (board == null) {
            throw new IllegalArgumentException("Invalid argument.");
        }
        boolean isWon = false;
        for (int row = 0; row < board.getSize(); row++) {
            for (int column = 0; column < board.getSize(); column++) {
                if (board.getBoard()[row][column] != null) {
                    isWon = isWon
                            || board.getBoard()[row][column].getNumber() == 2048;
                }
            }
        }
        return isWon;
    }

    /**
     * Checks if a move was made.
     *
     * @param boardBeforeMove
     * @return true, if a movement was made, false otherwise.
     */
    private boolean wasMoveMade(Cell[][] boardBeforeMove) {
        for (int row = 0; row < board.getSize(); row++) {
            for (int column = 0; column < board.getSize(); column++) {
                if ((board.hasCell(new Position(row, column))
                        && boardBeforeMove[row][column] == null)
                        || (!board.hasCell(new Position(row, column))
                        && boardBeforeMove[row][column] != null)
                        || (board.hasCell(new Position(row, column))
                        && boardBeforeMove[row][column] != null
                        && board.getBoard()[row][column]
                        != boardBeforeMove[row][column])) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Getter of value for specified cell.
     *
     * @param row of the cell.
     * @param column of the cell.
     * @return the value of a cell.
     */
    @Override
    public int getCellValue(int row, int column) {
        if (board.hasCell(new Position(row, column))) {
            return board.getBoard()[row][column].getNumber();
        } else {
            return 0;
        }
    }

    @Override
    public void addObserver(Observer obs) {
        observers.add(obs);
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        notifyObservers(null);
    }

    @Override
    public void notifyObservers(Object arg) {
        observers.forEach((observer) -> {
            observer.update(this, arg);
        });
    }

}
