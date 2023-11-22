package Snake.GUISnake;

import javax.swing.*;
import java.awt.*;

public class SnakeFrame extends JFrame{


    public SnakeFrame() throws HeadlessException {
        JPanel Snake = new SnakePanel();
        setContentPane(Snake);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Snake");
        setResizable(false);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);

    }


}
