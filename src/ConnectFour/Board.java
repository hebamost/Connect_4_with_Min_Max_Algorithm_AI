package ConnectFour;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {
	private int rows = 6;
	private int cols = 7;

	/**
	 * initialize the board with zeros
	 * 
	 * @param board: 2D array for the board of the game
	 */
	public void initBoard(char[][] board) {
		for (char[] row : board)
			Arrays.fill(row, '0');
	}

	/**
	 * get the index of the first empty row for specific column
	 * 
	 * @param board: 2D array for the board of the game
	 * @param col:   index of column to play in
	 * @return the index of the first empty row for specific column
	 */
	public int rowIndex(char[][] board, int col) {
		for (int i = rows - 1; i > -1; i--)
			if (board[i][col] == '0') // the position is empty
				return i;

		return -1; // the column is full
	}

	/**
	 * check if the first position of a column is empty so that it is a valid column
	 * to play in
	 * 
	 * @param board: 2D array for the board of the game
	 * @return ArrayList of the indices of valid columns
	 */
	public ArrayList<Integer> validCols(char[][] board) {
		ArrayList<Integer> vCols = new ArrayList<>();
		for (int c = 0; c < cols; c++) {
			if (board[0][c] == '0')
				vCols.add(c);
		}
		return vCols;
	}

	/**
	 * check if the game ended
	 * 
	 * @param state: the current board
	 * @return true if the board has been filled and false otherwise
	 */
	public boolean endGame(State state) {
		return validCols(state.board).size() == 0;
	}

	public char[][] copyBoard(char[][] board) {
		char[][] copiedBoard = new char[6][7];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				copiedBoard[i][j] = board[i][j];
			}
		}
		return copiedBoard;
	}

	public void turn(char[][] board, int col, char player) {
		int row = rowIndex(board, col);
		board[row][col] = player; // put piece of Player player in the board
	}

	public void printBoard(char[][] board) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * store the children of state and add those children to the state
	 * 
	 * @param state:  the current state
	 * @param player: the player that has the turn (human --> 'h' , agent --> 'a')
	 */
	public void children(State state, char player) {
		ArrayList<Integer> valid_cols = validCols(state.board);
		for (int i = 0; i < valid_cols.size(); i++) {
			// temporary board to store a next valid state in
			State temp = new State(copyBoard(state.board));
			// get index of column and row of the first valid position
			int col = valid_cols.get(i);
			int row = rowIndex(temp.board, col);
			temp.board[row][col] = player;

			state.addChild(temp);

			if (state.getCol() == -1)
				temp.setCol(col);
			else
				temp.setCol(state.getCol());
		}
	}

}
