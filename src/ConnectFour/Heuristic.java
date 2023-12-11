package ConnectFour;

public class Heuristic {
	final int rows = 6;
	final int cols = 7;

	/**
	 * evaluate the heuristic
	 * human -->h , agent --> a
	 * @param board: 2D array for the board of the game
	 * @return the calculated heuristic
	 */
	public int calcHeuristic(char[][] board) {
		int heu = 0;
		heu += (NumOfConnect_4(board, 'a')) * 100000;
		heu -= (NumOfConnect_4(board, 'h')) * 100000;
		heu += (NumOfConnect_3(board, 'a')) * 100;
		heu -= (NumOfConnect_3(board, 'h')) * 100;
		heu += (NumOfConnect_2(board, 'a')) * 10;
		heu -= (NumOfConnect_2(board, 'h')) * 10;

		return heu;
	}

	public int getHumanSore(char[][] board) {
		return NumOfConnect_4(board, 'h');
	}

	public int getAgentScore(char[][] board) {
		return NumOfConnect_4(board, 'a');
	}

	private int NumOfConnect_4(char[][] board, char player) {
		int num = 0;
		char piece = player;

		// horizontally
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols - 3; j++)
				if (board[i][j] == piece && board[i][j + 1] == piece && board[i][j + 2] == piece
						&& board[i][j + 3] == piece)
					num++;

		// vertically
		for (int j = 0; j < cols; j++)
			for (int i = 0; i < rows - 3; i++)
				if (board[i][j] == piece && board[i + 1][j] == piece && board[i + 2][j] == piece
						&& board[i + 3][j] == piece)
					num++;

		// diagonally --> /
		for (int i = rows - 3; i < rows; i++)
			for (int j = 0; j < cols - 3; j++)
				if (board[i][j] == piece && board[i - 1][j + 1] == piece && board[i - 2][j + 2] == piece
						&& board[i - 3][j + 3] == piece)
					num++;

		// diagonally --> \
		for (int i = 0; i < rows - 3; i++)
			for (int j = 0; j < cols - 3; j++)
				if (board[i][j] == piece && board[i + 1][j + 1] == piece && board[i + 2][j + 2] == piece
						&& board[i + 3][j + 3] == piece)
					num++;

		return num;
	}
	
	 private int NumOfConnect_3(char[][] board, char player) {
	        int num = 0;
	        char piece = player;

	        // horizontally
	        for (int i = 0; i < rows; i++)
	            for (int j = 0; j < cols - 3; j++) {
	                if (board[i][j] == '0' && board[i][j + 1] == piece && board[i][j + 2] == piece
	                        && board[i][j + 3] == piece)
	                    num++;
	                if (board[i][j] == piece && board[i][j + 1] == '0' && board[i][j + 2] == piece
	                        && board[i][j + 3] == piece)
	                    num++;
	                if (board[i][j] == piece && board[i][j + 1] == piece && board[i][j + 2] == '0'
	                        && board[i][j + 3] == piece)
	                    num++;
	                if (board[i][j] == piece && board[i][j + 1] == piece && board[i][j + 2] == piece
	                        && board[i][j + 3] == '0')
	                    num++;

	            }

	        // vertically
	        for (int j = 0; j < cols; j++)
	            for (int i = 0; i < rows - 3; i++) {
	                if (board[i][j] == '0' && board[i + 1][j] == piece && board[i + 2][j] == piece
	                        && board[i + 3][j] == piece)
	                    num++;
	                if (board[i][j] == piece && board[i + 1][j] == '0' && board[i + 2][j] == piece
	                        && board[i + 3][j] == piece)
	                    num++;
	                if (board[i][j] == piece && board[i + 1][j] == piece && board[i + 2][j] == '0'
	                        && board[i + 3][j] == piece)
	                    num++;
	                if (board[i][j] == piece && board[i + 1][j] == piece && board[i + 2][j] == piece
	                        && board[i + 3][j] == '0')
	                    num++;

	            }

	        // diagonally --> /
	        for (int i = 3; i < rows; i++)
	            for (int j = 0; j < cols - 3; j++) {
	                if (board[i][j] == '0' && board[i - 1][j + 1] == piece && board[i - 2][j + 2] == piece
	                        && board[i - 3][j + 3] == piece)
	                    num++;
	                if (board[i][j] == piece && board[i - 1][j + 1] == '0' && board[i - 2][j + 2] == piece
	                        && board[i - 3][j + 3] == piece)
	                    num++;
	                if (board[i][j] == piece && board[i - 1][j + 1] == piece && board[i - 2][j + 2] == '0'
	                        && board[i - 3][j + 3] == piece)
	                    num++;
	                if (board[i][j] == piece && board[i - 1][j + 1] == piece && board[i - 2][j + 2] == piece
	                        && board[i - 3][j + 3] == '0')
	                    num++;

	            }

	        // diagonally --> \
	        for (int i = 0; i < rows - 3; i++)
	            for (int j = 0; j < cols - 3; j++) {
	                if (board[i][j] == '0' && board[i + 1][j + 1] == piece && board[i + 2][j + 2] == piece
	                        && board[i + 3][j + 3] == piece)
	                    num++;
	                if (board[i][j] == piece && board[i + 1][j + 1] == '0' && board[i + 2][j + 2] == piece
	                        && board[i + 3][j + 3] == piece)
	                    num++;
	                if (board[i][j] == piece && board[i + 1][j + 1] == piece && board[i + 2][j + 2] == '0'
	                        && board[i + 3][j + 3] == piece)
	                    num++;
	                if (board[i][j] == piece && board[i + 1][j + 1] == piece && board[i + 2][j + 2] == piece
	                        && board[i + 3][j + 3] == '0')
	                    num++;
	            }

	        return num;
	    }

	    private int NumOfConnect_2(char[][] board, char player) {
	        int num = 0;
	        char piece = player;

	        // horizontally
	        for (int i = 0; i < rows; i++)
	            for (int j = 0; j < cols - 3; j++) {
	                if (board[i][j] == '0' && board[i][j + 1] == '0' && board[i][j + 2] == piece
	                        && board[i][j + 3] == piece)
	                    num++;
	                if (board[i][j] == '0' && board[i][j + 1] == piece && board[i][j + 2] == '0'
	                        && board[i][j + 3] == piece)
	                    num++;
	                if (board[i][j] == '0' && board[i][j + 1] == piece && board[i][j + 2] == piece
	                        && board[i][j + 3] == '0')
	                    num++;
	                if (board[i][j] == piece && board[i][j + 1] == '0' && board[i][j + 2] == piece
	                        && board[i][j + 3] == '_')
	                    num++;
	                if (board[i][j] == piece && board[i][j + 1] == '0' && board[i][j + 2] == '0'
	                        && board[i][j + 3] == piece)
	                    num++;
	                if (board[i][j] == piece && board[i][j + 1] == piece && board[i][j + 2] == '0'
	                        && board[i][j + 3] == '0')
	                    num++;

	            }

	        // vertically
	        for (int j = 0; j < cols; j++)
	            for (int i = 0; i < rows - 3; i++) {
	                if (board[i][j] == '0' && board[i + 1][j] == '0' && board[i + 2][j] == piece
	                        && board[i + 3][j] == piece)
	                    num++;
	                if (board[i][j] == '0' && board[i + 1][j] == piece && board[i + 2][j] == '0'
	                        && board[i + 3][j] == piece)
	                    num++;
	                if (board[i][j] == '0' && board[i + 1][j] == piece && board[i + 2][j] == piece
	                        && board[i + 3][j] == '0')
	                    num++;
	                if (board[i][j] == piece && board[i + 1][j] == '0' && board[i + 2][j] == piece
	                        && board[i + 3][j] == '0')
	                    num++;
	                if (board[i][j] == piece && board[i + 1][j] == '0' && board[i + 2][j] == '0'
	                        && board[i + 3][j] == piece)
	                    num++;
	                if (board[i][j] == piece && board[i + 1][j] == piece && board[i + 2][j] == '0'
	                        && board[i + 3][j] == '0')
	                    num++;

	            }

	        // diagonally --> /
	        for (int i = 3; i < rows; i++)
	            for (int j = 0; j < cols - 3; j++) {
	                if (board[i][j] == '0' && board[i - 1][j + 1] == '0' && board[i - 2][j + 2] == piece
	                        && board[i - 3][j + 3] == piece)
	                    num++;
	                if (board[i][j] == '0' && board[i - 1][j + 1] == piece && board[i - 2][j + 2] == '0'
	                        && board[i - 3][j + 3] == piece)
	                    num++;
	                if (board[i][j] == '0' && board[i - 1][j + 1] == piece && board[i - 2][j + 2] == piece
	                        && board[i - 3][j + 3] == '0')
	                    num++;
	                if (board[i][j] == piece && board[i - 1][j + 1] == '0' && board[i - 2][j + 2] == piece
	                        && board[i - 3][j + 3] == '0')
	                    num++;
	                if (board[i][j] == piece && board[i - 1][j + 1] == '0' && board[i - 2][j + 2] == '0'
	                        && board[i - 3][j + 3] == piece)
	                    num++;
	                if (board[i][j] == piece && board[i - 1][j + 1] == piece && board[i - 2][j + 2] == '0'
	                        && board[i - 3][j + 3] == '0')
	                    num++;

	            }

	        // diagonally --> \
	        for (int i = 0; i < rows - 3; i++)
	            for (int j = 0; j < cols - 3; j++) {
	                if (board[i][j] == '0' && board[i + 1][j + 1] == '0' && board[i + 2][j + 2] == piece
	                        && board[i + 3][j + 3] == piece)
	                    num++;
	                if (board[i][j] == '0' && board[i + 1][j + 1] == piece && board[i + 2][j + 2] == '0'
	                        && board[i + 3][j + 3] == piece)
	                    num++;
	                if (board[i][j] == '0' && board[i + 1][j + 1] == piece && board[i + 2][j + 2] == piece
	                        && board[i + 3][j + 3] == '0')
	                    num++;
	                if (board[i][j] == piece && board[i + 1][j + 1] == '0' && board[i + 2][j + 2] == piece
	                        && board[i + 3][j + 3] == '0')
	                    num++;
	                if (board[i][j] == piece && board[i + 1][j + 1] == '0' && board[i + 2][j + 2] == '0'
	                        && board[i + 3][j + 3] == piece)
	                    num++;
	                if (board[i][j] == piece && board[i + 1][j + 1] == piece && board[i + 2][j + 2] == '0'
	                        && board[i + 3][j + 3] == '0')
	                    num++;

	            }
	        return num;
	    }

}
