package Tris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;


public class TicTacToe extends JFrame implements ActionListener{

    Random random = new Random();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;



    public TicTacToe() throws HeadlessException{

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800,800);
        getContentPane().setBackground(new Color(50,50,50));
        setLayout(new BorderLayout());
        setVisible(true);
        setLocationRelativeTo(null);



        textfield.setBackground(new Color(45, 56, 101));
        textfield.setForeground(new Color(173, 168, 168));
        textfield.setFont(new Font("Helvetica", Font.PLAIN,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150,150,150));



        for(int i=0;i<9;i++) {

            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setBackground(new Color(23,23,23));
            buttons[i].setFont(new Font("Roboto",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);

        }

        title_panel.add(textfield);
        add(title_panel,BorderLayout.NORTH);
        add(button_panel);

        firstTurn();

    }



    @Override

    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<9;i++) {

            if(e.getSource()==buttons[i]) {

                if(player1_turn) {

                    if(Objects.equals(buttons[i].getText(), "")) {
                        buttons[i].setForeground(new Color(124, 54, 204));
                        buttons[i].setText("X");
                        player1_turn=false;
                        textfield.setBackground(new Color(248, 207, 53));
                        textfield.setText("O turn");
                        check();

                    }

                }

                else {

                    if(Objects.equals(buttons[i].getText(), "")) {
                        buttons[i].setForeground(new Color(248, 207, 53));
                        buttons[i].setText("O");
                        player1_turn=true;
                        textfield.setBackground(new Color(124, 54, 204));
                        textfield.setText("X turn");
                        check();

                    }

                }

            }

        }

    }



    public void firstTurn() {



        try {

            Thread.sleep(2000);

        } catch (InterruptedException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        }



        if(random.nextInt(2)==0) {
            player1_turn=true;
            textfield.setText("X turn");
        }

        else {
            player1_turn=false;
            textfield.setText("O turn");
        }

    }



    public void check() {

        //check X win conditions

        if((Objects.equals(buttons[0].getText(), "X")) && (Objects.equals(buttons[1].getText(), "X")) && (Objects.equals(buttons[2].getText(), "X"))) {

            xWins(0,1,2);

        }

        if((Objects.equals(buttons[3].getText(), "X")) && (buttons[4].getText()=="X") && (Objects.equals(buttons[5].getText(), "X"))) {

            xWins(3,4,5);

        }

        if((buttons[6].getText()=="X") && (Objects.equals(buttons[7].getText(), "X")) && (Objects.equals(buttons[8].getText(), "X"))) {

            xWins(6,7,8);

        }

        if((buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X")) {

            xWins(0,3,6);
        }

        if((buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X")) {

            xWins(1,4,7);
        }

        if((buttons[2].getText()=="X") && (buttons[5].getText()=="X") && (buttons[8].getText()=="X")) {

            xWins(2,5,8);
        }

        if((buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X")) {

            xWins(0,4,8);
        }

        if((buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X")) {

            xWins(2,4,6);
        }

        //check O win conditions

        if((buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O")) {

            oWins(0,1,2);
        }

        if((buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O")
        ) {

            oWins(3,4,5);
        }

        if((buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O")) {

            oWins(6,7,8);
        }

        if((buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O")) {

            oWins(0,3,6);
        }

        if((buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O")) {

            oWins(1,4,7);
        }

        if((buttons[2].getText()=="O") && (buttons[5].getText()=="O") && (buttons[8].getText()=="O")) {
            oWins(2,5,8);

        }

        if((buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O")) {

            oWins(0,4,8);
        }

        if((buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O")) {

            oWins(2,4,6);
        }

    }



    public void xWins(int a,int b,int c) {

        buttons[a].setBackground(Color.GREEN);

        buttons[b].setBackground(Color.GREEN);

        buttons[c].setBackground(Color.GREEN);



        for(int i=0;i<9;i++) {

            buttons[i].setEnabled(false);

        }

        textfield.setText("X wins");

    }

    public void oWins(int a,int b,int c) {

        buttons[a].setBackground(Color.GREEN);

        buttons[b].setBackground(Color.GREEN);

        buttons[c].setBackground(Color.GREEN);



        for(int i=0;i<9;i++) {

            buttons[i].setEnabled(false);

        }

        textfield.setText("O wins");

    }

}