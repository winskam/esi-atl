package Model;

import java.util.Stack;

/**
 * Class that creates the game board which is square. The game board contains
 * empty squares or squares containing a multiple of 2.
 *
 * @author Marika Winska 55047
 */
public class Board {

    private Cell[][] board;

    /**
     * Constructor of the board.
     *
     * @param size of the square, the board.
     */
    public Board(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Invalid argument.");
        }
        this.board = new Cell[size][size];
    }

    /**
     * @return the size of the game board.
     */
    public int getSize() {
        return board.length;
    }

    /**
     * Getter for the board.
     *
     * @return the board.
     */
    public Cell[][] getBoard() {
        return board;
    }

    /**
     * Clones the game board.
     *
     * @return a copy of the game board.
     */
    public Cell[][] getCopyBoard() {
        Cell[][] copyBoard = new Cell[getSize()][getSize()];
        for (int row = 0; row < getSize(); row++) {
            for (int column = 0; column < getSize(); column++) {
                copyBoard[row][column] = board[row][column];
            }
        }

        return copyBoard;
    }

    /**
     * Setter of board.
     *
     * @param board the new board.
     */
    void setBoard(Cell[][] board) {
        this.board = board;
    }

    /**
     * Adds the number 2 or 4 to a random place in one of the squares on the
     * game board.
     */
    void addCell() {
        int x = (int) (Math.random() * getSize());
        int y = (int) (Math.random() * getSize());
        while (hasCell(new Position(x, y))) {
            x = (int) (Math.random() * getSize());
            y = (int) (Math.random() * getSize());
        }
        if (Math.random() < 0.9) {
            board[x][y] = new Cell(2);
        } else {
            board[x][y] = new Cell(4);
        }
    }

    /**
     * Checks if there is a number at the given position or if it is empty.
     *
     * @param position given.
     * @return true if the position is occupied, false otherwise.
     */
    public boolean hasCell(Position position) {
        if (position == null || position.getRow() > getSize()
                || position.getColumn() > getSize()) {
            throw new IllegalArgumentException("Invalid argument.");
        }
        return board[position.getRow()][position.getColumn()] != null;
    }

    /**
     * Moves the numbers on the game board upwards until they can.
     */
    void move(Direction direction) {
        int row = 0;
        int column = 0;
        for (int i = 0; i < getSize(); i++) {
            Stack<Cell> stackColumn = new Stack<>();
            for (int j = getSize() - 1; j >= 0; j--) {
                switch (direction) {
                    case UP:
                        column = i;
                        row = j;
                        break;

                    case DOWN:
                        column = i;
                        row = getSize() - 1 - j;
                        break;

                    case LEFT:
                        column = j;
                        row = i;
                        break;

                    default:
                        column = getSize() - 1 - j;
                        row = i;
                }

                if (hasCell(new Position(row, column))) {
                    stackColumn.push(board[row][column]);
                    board[row][column] = null;
                }
            }
            int firstFree = (direction == Direction.DOWN
                    || direction == Direction.RIGHT) ? getSize() - 1 : 0;
            while (stackColumn.size() >= 2) {
                Cell firstCase = stackColumn.pop();
                Cell secondCase = stackColumn.peek();
                if (firstCase.getNumber() == secondCase.getNumber()) {
                    if (direction == Direction.UP || direction == Direction.DOWN) {
                        board[firstFree][column] = new Cell(firstCase.getNumber() * 2);
                    } else {
                        board[row][firstFree] = new Cell(firstCase.getNumber() * 2);
                    }
                    stackColumn.pop();
                } else {
                    if (direction == Direction.UP || direction == Direction.DOWN) {
                        board[firstFree][column] = firstCase;
                    } else {
                        board[row][firstFree] = firstCase;
                    }
                }
                if (direction == Direction.DOWN || direction == Direction.RIGHT) {
                    firstFree--;
                } else {
                    firstFree++;
                }
            }
            if (stackColumn.size() == 1) {
                if (direction == Direction.UP || direction == Direction.DOWN) {
                    board[firstFree][column] = stackColumn.pop();

                } else {
                    board[row][firstFree] = stackColumn.pop();
                }
            }
        }
    }

    /**
     * Checks if the game board is full, i.e. there is no more cell to add a new
     * number.
     *
     * @return true if the game board is full, false otherwise.
     */
    boolean isCompleted() {
        boolean isCompleted = true;
        for (int row = 0; row < getSize(); row++) {
            for (int column = 0; column < getSize(); column++) {
                if (board[row][column] == null) {
                    isCompleted = false;
                }
            }
        }
        return isCompleted;
    }

}
