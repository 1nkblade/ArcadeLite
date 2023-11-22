package Pong;

import javax.swing.*;
import java.awt.*;

public class PongFrame extends JFrame {

    PongPanel panel;

    public PongFrame() throws HeadlessException{

        panel = new PongPanel();
        this.setContentPane(panel);
        this.setTitle("Pong");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }


}