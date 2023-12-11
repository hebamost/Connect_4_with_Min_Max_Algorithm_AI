package GUI;

import javax.swing.*;
import java.awt.*;

public class Finally {
    JFrame frame = new JFrame();
    JPanel panel=new JPanel();
    JLabel label= new JLabel("GAME OVER!!");
    JPanel Wpanel=new JPanel();
    JLabel Wlabel= new JLabel();
    Finally(int Pscore, int Cscore){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setTitle("Connect4");
        frame.setSize(400,300);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        Flabel();
        winner(Pscore, Cscore);

    }
    void Flabel(){
        label.setFont(new Font("times new roman",Font.BOLD,30));
        label.setForeground(Color.GREEN);
        panel.setBounds(70,55,250,50);
        panel.setBackground(Color.darkGray);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS ));
        panel.add(Box.createHorizontalGlue());
        panel.add(label);
        panel.add(Box.createHorizontalGlue());
        frame.add(panel);
    }
    void winner(int pScore, int cScore){
        if(pScore>cScore){
            Wlabel.setText("**You are the winner**");
            Wlabel.setFont(new Font("times new roman",Font.BOLD,28));
            Wlabel.setForeground(Color.white);
            Wpanel.setBounds(40,105,300,50);
            Wpanel.setBackground(Color.darkGray);
            Wpanel.setLayout(new BoxLayout(Wpanel, BoxLayout.X_AXIS ));
            Wpanel.add(Box.createHorizontalGlue());
            Wpanel.add(Wlabel);
            Wpanel.add(Box.createHorizontalGlue());
            frame.add(Wpanel);
        }
        if(pScore<cScore){
            Wlabel.setText("**computer is the winner**");
            Wlabel.setFont(new Font("times new roman",Font.BOLD,28));
            Wlabel.setForeground(Color.white);
            Wpanel.setBounds(0,105,400,50);
            Wpanel.setBackground(Color.darkGray);
            Wpanel.setLayout(new BoxLayout(Wpanel, BoxLayout.X_AXIS ));
            Wpanel.add(Box.createHorizontalGlue());
            Wpanel.add(Wlabel);
            Wpanel.add(Box.createHorizontalGlue());
            frame.add(Wpanel);
        }
    }

}

