package ConnectFour;

import java.util.*;

public class State {

	public char[][] board;
	public int colNum;
	public int util;
	public ArrayList<State> children;

	public State(char[][] board) {
		this.board = board;
		this.colNum = -1;
		this.children = new ArrayList<>();
	}

	public void setState(State state) {
		this.util = state.getUtil();
		this.colNum = state.getCol();
	}

	public ArrayList<State> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<State> children) {
		this.children = children;
	}

	public void addChild(State s) {
		children.add(s);
	}

	public int getCol() {
		return colNum;
	}

	public void setCol(int col) {
		this.colNum = col;
	}

	public char[][] getBoard() {
		return board;
	}

	public void setBoard(char[][] board) {
		this.board = board;
	}

	public int getUtil() {
		return util;
	}

	public void setUtil(int util) {
		this.util = util;
	}

	public String toString() {
		StringBuilder st = new StringBuilder(100);
		print(st, "", "", 1);
		return st.toString();
	}

	public void print(StringBuilder st, String curr, String children_curr, int level) {

		st.append(curr);

		// if the level is odd ==> level for agent
		if (level % 2 == 1) {
			st.append("Level " + level + ":" + " turn: agent ==> Value : " + this.util);
			st.append('\n');
		}
		// if the level is even ==> level for human
		else {
			st.append("Level " + level + ":" + " turn: human ==> Value : " + this.util);
			st.append('\n');
		}

		Iterator<State> it = children.iterator();
		while (it.hasNext()) {
			State next = it.next();

			if (it.hasNext()) {
				next.print(st, children_curr + "├── ", children_curr + "│   ", level + 1);
			} else {
				next.print(st, children_curr + "└── ", children_curr + "    ", level + 1);
			}
		}
	}

	public void printTree() {
		System.out.println(this.toString());
	}

}
