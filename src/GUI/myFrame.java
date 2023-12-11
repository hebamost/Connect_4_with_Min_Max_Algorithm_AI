package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class myFrame implements ActionListener {
	public int depth;
	public int algo;
	Game game;
	
	JFrame frame = new JFrame();
	JButton sButton = new JButton("Start");
	JLabel Alabel = new JLabel();
	JLabel Dlabel = new JLabel();
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panelbox1 = new JPanel();
	JPanel panelbox2 = new JPanel();
	JCheckBox box1 = new JCheckBox();
	JCheckBox box2 = new JCheckBox();
	JTextField text = new JTextField();

	myFrame() {
		labels();
		checkBoxes();
		buttons();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setTitle("Connect4");
		frame.setSize(450, 450);
		frame.setLayout(null);
		frame.setVisible(true);

	}

	void labels() {
		Alabel.setText("Select Algorithm");
		Alabel.setFont(new Font("Blackadder ITC", Font.BOLD, 28));
		Alabel.setForeground(Color.BLACK);
		panel1.setBounds(120, 100, 190, 35);
		panel1.setBackground(Color.lightGray);
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));
		panel1.add(Box.createHorizontalGlue());
		panel1.add(Alabel);
		panel1.add(Box.createHorizontalGlue());
		frame.add(panel1);

		Dlabel.setText("Enter max depth:");
		Dlabel.setFont(new Font("Blackadder ITC", Font.BOLD, 28));
		Dlabel.setForeground(Color.BLACK);
		panel2.setBounds(90, 220, 190, 35);
		panel2.setBackground(Color.lightGray);
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
		panel2.add(Box.createHorizontalGlue());
		panel2.add(Dlabel);
		panel2.add(Box.createHorizontalGlue());
		frame.add(panel2);

		text.setBounds(290, 220, 50, 35);
		frame.add(text);
	}

	void checkBoxes() {
		box1.setText("MiniMax");
		box1.setFont(new Font("Blackadder ITC", Font.BOLD, 20));
		box1.setForeground(Color.white);
		box1.setBackground(Color.DARK_GRAY);
		box1.setFocusable(false);
		box1.addActionListener(this);
		panelbox1.setBounds(120, 140, 190, 35);
		panelbox1.setBackground(Color.darkGray);
		panelbox1.setLayout(new BoxLayout(panelbox1, BoxLayout.X_AXIS));
		panelbox1.add(Box.createHorizontalGlue());
		panelbox1.add(box1);
		panelbox1.add(Box.createHorizontalGlue());
		frame.add(panelbox1);

		box2.setText("Alpha-Beta");
		box2.setFont(new Font("Blackadder ITC", Font.BOLD, 20));
		box2.setForeground(Color.white);
		box2.setBackground(Color.DARK_GRAY);
		box2.setFocusable(false);
		box2.addActionListener(this);
		panelbox2.setBounds(120, 170, 190, 35);
		panelbox2.setBackground(Color.darkGray);
		panelbox2.setLayout(new BoxLayout(panelbox2, BoxLayout.X_AXIS));
		panelbox2.add(Box.createHorizontalGlue());
		panelbox2.add(box2);
		panelbox2.add(Box.createHorizontalGlue());
		frame.add(panelbox2);
	}

	void buttons() {
		sButton.setBounds(160, 265, 100, 35);
		sButton.setFocusable(false);
		sButton.addActionListener(this);
		frame.add(sButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (box1.isSelected()) {
			//setAlgo(1);
			algo = 1;
			System.out.println("box1");
			System.out.println("algo now equal: " + algo);
		}
		if (box2.isSelected()) {
			//setAlgo(2);
			algo = 2;
			System.out.println("box2");
			System.out.println("algo now equal: " + algo);
		}
		if (e.getSource() == sButton) {
			frame.dispose();
			depth = Integer.parseInt(text.getText());
			System.out.println(depth);
			new Game();
		}

	}
}
