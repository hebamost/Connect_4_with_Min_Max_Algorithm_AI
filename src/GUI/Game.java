package GUI;

import javax.swing.*;

import ConnectFour.Board;
import ConnectFour.Heuristic;
import ConnectFour.MinMax;
import ConnectFour.MinMaxPruning;
import ConnectFour.State;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Game implements ActionListener {
	myFrame myF = Main.myframe;
	//myFrame myF = new myFrame();
	Board b = new Board();
	Heuristic h = new Heuristic();
	static int hScore = 0;
	static int aScore = 0;
	MinMax MM = new MinMax();
	MinMaxPruning MP = new MinMaxPruning();

	public char[][] board = new char[6][7];
	char human = 'h';
	char agent = 'a';

	char[][] initializeBoard() {
		for (char[] row : board)
			Arrays.fill(row, '0');
		return board;
	}

	JFrame frame = new JFrame();
	JPanel[] vPanels = new JPanel[7];
	JPanel[][] mPanels = new JPanel[6][7];
	JLabel c4Label = new JLabel();
	JPanel c4Panel = new JPanel();
	JLabel pLabel = new JLabel();
	JPanel pPanel = new JPanel();
	JLabel pLabelScore = new JLabel();
	JPanel pPanelScore = new JPanel();
	JLabel cLabel = new JLabel();
	JPanel cPanel = new JPanel();
	JLabel cLabelScore = new JLabel();
	JPanel cPanelScore = new JPanel();
	JButton[] buttons = new JButton[7];

	public static class Circles extends JPanel {
		static JPanel[][] circles = new JPanel[6][7];

		public void paint(Graphics g) {
			Graphics2D g2D = (Graphics2D) g;
			g2D.setColor(new Color(255, 255, 255));
			g2D.fillOval(0, 0, 100, 100);

		}
	}

	public class Rcircles extends JPanel {
		public void paint(Graphics g) {
			Graphics2D g2D = (Graphics2D) g;
			g2D.setColor(new Color(120, 1, 1));
			g2D.fillOval(0, 0, 100, 100);
		}
	}

	public class Ycircles extends JPanel {
		public void paint(Graphics g) {
			Graphics2D g2D = (Graphics2D) g;
			g2D.setColor(new Color(212, 143, 12));
			g2D.fillOval(0, 0, 100, 100);
		}
	}

	public Game() {
		initializeBoard();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Connect4");
		frame.setLayout(null);
		frame.setVisible(true);
		cScore();
		writeCscore(aScore);
		frame.getContentPane().setBackground(new Color(5, 50, 90));
		matrixPanels();
		frame.setVisible(true);
		pScore();
		writePscore(hScore);
		Buttons();
	}

	void Buttons() {
		int x = 0;
		for (int i = 0; i < 7; i++) {
			buttons[i] = new JButton(String.valueOf(i + 1));
			buttons[i].setFont(new Font("times new roman", Font.BOLD, 25));
			buttons[i].setForeground(new Color(5, 50, 90));
			buttons[i].setBackground(Color.lightGray);
			buttons[i].setBounds(55 + x, 90, 50, 50);
			buttons[i].addActionListener(this);
			frame.add(buttons[i]);
			x = x + 103;
		}
	}

	void matrixPanels() {
		int x = 0;
		int y = 0;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				Circles.circles[i][j] = new Circles();
				// Circles.circles[i][j].setBackground(new Color(255, 255, 255));
				Circles.circles[i][j].setBounds(30 + x, 150 + y, 100, 100);
				frame.add(Circles.circles[i][j]);
				x = x + 103;
			}
			y = y + 102;
			x = 0;
		}
	}

	void pScore() {
		pLabel.setText("Player score :");
		pLabel.setFont(new Font("Blackadder ITC", Font.BOLD, 35));
		pLabel.setForeground(Color.white);
		pPanel.setBounds(35, 20, 200, 50);
		pPanel.setBackground(Color.darkGray);
		pPanel.setLayout(new BoxLayout(pPanel, BoxLayout.X_AXIS));
		pPanel.add(Box.createHorizontalGlue());
		pPanel.add(pLabel);
		pPanel.add(Box.createHorizontalGlue());
		pPanelScore.setBounds(235, 20, 70, 50);
		pPanelScore.setBackground(Color.darkGray);
		frame.add(pPanelScore);
		frame.add(pPanel);
	}

	void writePscore(int score) {
		pLabelScore.setText(String.valueOf(score));
		pLabelScore.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 35));
		pLabelScore.setForeground(new Color(150, 1, 1));
		pPanelScore.setLayout(new BoxLayout(pPanelScore, BoxLayout.X_AXIS));
		pPanelScore.add(Box.createHorizontalGlue());
		pPanelScore.add(pLabelScore);
		pPanelScore.add(Box.createHorizontalGlue());
		frame.add(pPanelScore);
	}

	void cScore() {
		cLabel.setText("Computer score :");
		cLabel.setFont(new Font("Blackadder ITC", Font.BOLD, 35));
		cLabel.setForeground(Color.white);
		cPanel.setBounds(450, 20, 220, 50);
		cPanel.setBackground(Color.darkGray);
		cPanel.setLayout(new BoxLayout(cPanel, BoxLayout.X_AXIS));
		cPanel.add(Box.createHorizontalGlue());
		cPanel.add(cLabel);
		cPanel.add(Box.createHorizontalGlue());
		cPanelScore.setBounds(670, 20, 70, 50);
		cPanelScore.setBackground(Color.DARK_GRAY);
		frame.add(cPanelScore);
		frame.add(cPanel);
	}

	void writeCscore(int score) {
		cLabelScore.setText(String.valueOf(score));
		cLabelScore.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 35));
		cLabelScore.setForeground(new Color(212, 143, 12));
		cPanelScore.setLayout(new BoxLayout(cPanelScore, BoxLayout.X_AXIS));
		cPanelScore.add(Box.createHorizontalGlue());
		cPanelScore.add(cLabelScore);
		cPanelScore.add(Box.createHorizontalGlue());
		frame.add(cPanelScore);
	}

	void removePscore() {
		pPanelScore.remove(pLabelScore);
	}

	void removeCscore() {
		cPanelScore.remove(cLabelScore);
	}

	private static void print_score() {
		System.out.println("Player 1 Score: " + hScore);
		System.out.println("AI Score: " + aScore);
	}

	void play(int algo) {
		
		System.out.println("d5lt fl play with algo " + algo);  
		System.out.println("l board elly htt7t fl state " ); 
		b.printBoard(board);
		
		State state = new State(board); // put board from GUI
		if (algo == 1) {
			System.out.println("d5l fl if " );      
			System.out.println("l depth: " + myF.depth );      
			state.setState(MM.maximize(agent, myF.depth, state));
			state.printTree();
			System.out.println("Nodes expanded " + MM.nodes);
			MM.nodes = 0;
		} else {
			System.out.println("d5l fl ielse " );            
			System.out.println("l depth: " + myF.depth );        
			state.setState(MP.maximize(agent, myF.depth, state, Double.MIN_VALUE, Double.MAX_VALUE));
			state.printTree();
			System.out.println("Nodes expanded " + MP.nodes);
			MP.nodes = 0;
		}
		int col = state.getCol(); 
		System.out.println("el column bta3 l comp: "  + col); 
		b.turn(board, col, agent);
		b.printBoard(board);
		print_score();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int row;
		for (int col = 0; col < 7; col++) {
			if (e.getSource() == buttons[col]) {
				String num = buttons[col].getText();
				System.out.println(num);

				for (row = 5; row > -1; row--) {
					if (board[row][col] == '0') {
						board[row][col] = 'h';
						break;
					}
				}
				if (row == -1) {
					System.out.println("the column is filled...");
				} else {
					JPanel Rcirc = new Rcircles();
					frame.remove(Circles.circles[row][col]);
					Rcirc.setBounds(30 + (col * 103), 150 + (row * 102), 100, 100);
					frame.add(Rcirc);
					frame.repaint();
					frame.validate();

					hScore = h.getHumanSore(board);
					//System.out.println("haa b2aaaaaa"  + myF.algo);
					play(myF.algo);
					aScore = h.getAgentScore(board); 

					for (int r = 0; r < 6; r++) {
						for (int c = 0; c < 7; c++) {
							if (board[r][c] == 'a') {
								JPanel Ycirc = new Ycircles();
								frame.remove(Circles.circles[r][c]);
								Ycirc.setBounds(30 + (c * 103), 150 + (r * 102), 100, 100);
								frame.add(Ycirc);
								frame.repaint();
								frame.validate();
							}
						}
					}
					removeCscore();
					writePscore(hScore);
				    writeCscore(aScore);
				}

			}
		}
		int count = 0;
		for (int s = 0; s < 7; s++) {
			if (board[0][s] != '0') {
				count++;
			}
		}
		if (count == 7) {
			System.out.println("Game Over!!");
			Finally Final = new Finally(h.getHumanSore(board), h.getAgentScore(board)); // the 2 scores from back
		}

	}

}
