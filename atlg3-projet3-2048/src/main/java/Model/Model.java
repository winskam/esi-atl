package Model;

import designpattern.Observable;
import designpattern.Observer;

/**
 * Interface with the all different operations on the game.
 *
 * @author Marika Winska 55047
 */
public interface Model extends Observable {

    /**
     * Getter of the board.
     *
     * @return the board.
     */
    Board getBoard();

    /**
     * Performs movement in the given direction.
     *
     * @param direction given.
     */
    void move(Direction direction);

    /**
     * Checks whether the user can still perform a movement.
     *
     * @return true if there is at least one movement of possible, false
     * otherwise.
     */
    boolean canMove();

    /**
     * Checks if the game is won.The game is won when there is the number 2048
     * in the game board.
     *
     * @return true if the game is won, false otherwise.
     */
    boolean isWon();

    /**
     * Getter of value for specified cell.
     *
     * @param row of the cell.
     * @param column of the cell.
     * @return the value of a cell.
     */
    int getCellValue(int row, int column);

    /**
     * Initializes the game with a chosen number of cells at the beginning of
     * the game.
     *
     * @param numberCell number of cells when the game starts.
     */
    void initGame(int numberCell);

    /**
     * Adds a class that will observe this class.
     *
     * @param obs the class to add as observer.
     */
    @Override
    public void addObserver(Observer obs);

    /**
     * Notifies the observes that the asked computations are done.
     */
    @Override
    public void notifyObservers();

    /**
     * Notifies the observes that the asked computations are done.
     *
     * @param arg the finished computations.
     */
    @Override
    public void notifyObservers(Object arg);

}
