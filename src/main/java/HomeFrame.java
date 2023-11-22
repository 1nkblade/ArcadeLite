import Pong.PongFrame;
import Snake.GUISnake.SnakeFrame;
import Tris.TicTacToe;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class HomeFrame extends JFrame implements ActionListener {

    static final int HEIGHT = 700;
    static final int WIDTH = 700;
    JPanel panel;
    JButton snakebtn;
    JButton trisbtn;
    JButton pongbtn;
    JLabel label1  = new JLabel("SELECT A GAME");
    JLabel Title = new JLabel();
    ImageIcon image = new ImageIcon("images/AL.jpeg");
    ImageIcon pongimg = new ImageIcon("images/pongrez.png");
    ImageIcon snakeimg = new ImageIcon("images/snakerez.png");
    ImageIcon trisimg = new ImageIcon("images/xorez.png");


    BufferedImage myPicture = ImageIO.read(new File("images/ALrez290.png"));


    public HomeFrame() throws HeadlessException, IOException {

        panel  = new JPanel();
        panel.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        panel.setBackground(new Color(210, 210, 255));
        panel.setLayout(null);




        snakebtn = new JButton("SNAKE");
        trisbtn = new JButton(" TRIS  ");
        pongbtn = new JButton("PONG");

        snakebtn.setFont(new Font("Arial",Font.PLAIN,24));
        trisbtn.setFont(new Font("Arial",Font.PLAIN,24));
        pongbtn.setFont(new Font("Arial",Font.PLAIN,24));

        snakebtn.setFocusable(false);
        trisbtn.setFocusable(false);
        pongbtn.setFocusable(false);

        snakebtn.setBounds(200,250,300,100);
        trisbtn.setBounds(200,400,300,100);
        pongbtn.setBounds(200,550,300,100);

        snakebtn.addActionListener(this);
        trisbtn.addActionListener(this);
        pongbtn.addActionListener(this);

        snakebtn.setBackground(new Color(117, 133, 176));
        trisbtn.setBackground(new Color(117, 133, 176));
        pongbtn.setBackground(new Color(117, 133, 176));

        snakebtn.setForeground(new Color(255, 255, 255));
        trisbtn.setForeground(new Color(255, 255, 255));
        pongbtn.setForeground(new Color(255, 255, 255));

        snakebtn.setFont(new Font("Serif",Font.PLAIN,30));
        trisbtn.setFont(new Font("Serif",Font.PLAIN,30));
        pongbtn.setFont(new Font("Serif",Font.PLAIN,30));

        snakebtn.setIcon(snakeimg);
        trisbtn.setIcon(trisimg);
        pongbtn.setIcon(pongimg);

        snakebtn.setIconTextGap(30);
        pongbtn.setIconTextGap(30);
        trisbtn.setIconTextGap(30);



        label1.setForeground(new Color(2,2,2));
        label1.setFont(new Font("Serif",Font.PLAIN,30));
        label1.setBounds(235,150,300,100);


        //Title.setForeground(new Color(151, 31, 232));
        //Title.setFont(new Font("Arial",Font.PLAIN,50));
        Title.setBounds(210,20,550,100);
        Title.setIcon(new ImageIcon(myPicture));
        Title.setHorizontalTextPosition(JLabel.RIGHT);

        panel.add(Title);
        panel.add(label1);
        panel.add(snakebtn);
        panel.add(trisbtn);
        panel.add(pongbtn);

        setTitle("Arcade Lite");
        setIconImage(image.getImage());
        setContentPane(panel);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == snakebtn ){
            new SnakeFrame();
        }

        if (e.getSource() == trisbtn ){
            new TicTacToe();
        }

        if (e.getSource() == pongbtn ){
            new PongFrame();
        }
    }
}
