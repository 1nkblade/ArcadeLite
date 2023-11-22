package Snake.GUISnake;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class SnakePanel extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
    static final int DELAY = 100;
    final int[] x = new int[GAME_UNITS];
    final int[] y = new int[GAME_UNITS];
    int bodyParts = 3;
    int bananasEaten;
    int bananaX;
    int bananaY;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;
    JButton restart;



    public SnakePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new SnakeKeyAdapter());

        restart = new JButton();
        restart.setText("Restart");
        restart.setSize(100,50);
        restart.setLocation(SnakePanel.SCREEN_WIDTH/2-restart.getWidth()/2,400);
        restart.addActionListener(this);

        startSnake();
    }

    public void startSnake(){
        newBanana();
        running = true;
        timer = new Timer(DELAY,this);
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        if(running) {

            g.setColor(Color.yellow);
            g.fillOval(bananaX, bananaY, UNIT_SIZE, UNIT_SIZE);


            for (int i = 0; i < bodyParts; i++) {
                if (i == 0) {
                    g.setColor(new Color(156, 35, 243)); // colore testa
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                } else {
                    g.setColor(new Color(156, 35, 243)); //colore corpo
                   // g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
                    g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                }


            }
            g.setColor(new Color(255,255,255));
            g.setFont(new Font("Helvetica",Font.BOLD, 35));
            FontMetrics score = getFontMetrics(g.getFont());
            g.drawString("Score: "+bananasEaten,(SCREEN_WIDTH - score.stringWidth("Score: "+bananasEaten)),g.getFont().getSize());
        }
        else{
            gameOver(g);
        }
    }

    public void move() {
        for (int i = bodyParts;i > 0;i--){
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        switch (direction) {
            case 'U' -> y[0] = y[0] - UNIT_SIZE;
            case 'D' -> y[0] = y[0] + UNIT_SIZE;
            case 'L' -> x[0] = x[0] - UNIT_SIZE;
            case 'R' -> x[0] = x[0] + UNIT_SIZE;
        }

    }

    public void newBanana(){
        bananaX = random.nextInt(SCREEN_WIDTH/UNIT_SIZE)*UNIT_SIZE;
        bananaY = random.nextInt(SCREEN_HEIGHT/UNIT_SIZE)*UNIT_SIZE;

    }

    public void checkBanana(){
        if((x[0] == bananaX)&&(y[0] == bananaY)){
            bodyParts++;
            bananasEaten++;
            newBanana();
        }

    }


    public void checkCollisions(){

        //controlla se la testa collide con il corpo
        for (int i = bodyParts;i > 0;i--){
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
                break;
            }
        }
        //testa tocca bordo sx
        if (x[0] < 0) {
            running = false;
        }
        //testa tocca bordo dx
        if (x[0] > SCREEN_WIDTH-UNIT_SIZE) {
            running = false;
        }
        // testa tocca bordo inferiore
        if (y[0] < 0) {
            running = false;
        }

        // testa tocca bordo superiore
        if (y[0] > SCREEN_HEIGHT-UNIT_SIZE) {
            running = false;
        }

        if (!running){
            timer.stop();
        }



    }

    public void gameOver(Graphics g){
        g.setColor(Color.red);
        g.setFont(new Font("Helvetica",Font.BOLD, 75));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Game Over!",(SCREEN_WIDTH -metrics.stringWidth("Game Over!"))/2,SCREEN_HEIGHT/2);

        g.setColor(Color.red);
        g.setFont(new Font("Helvetica",Font.BOLD, 35));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Score: "+bananasEaten,(SCREEN_WIDTH -metrics2.stringWidth("Score: "+bananasEaten))/2,g.getFont().getSize());

        this.add(restart);



    }

    public void restartGame() {
        setVisible(false);
        new SnakeFrame();
    }
    public void dispose() {
        JFrame parent = (JFrame) this.getTopLevelAncestor();
        parent.dispose();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (running){
            move();
            checkBanana();
            checkCollisions();
        }
        repaint();

        if (e.getSource() == restart){
          restartGame();
          dispose();
        }

    }



    public  class SnakeKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){
            switch (e.getKeyCode()){

                case KeyEvent.VK_LEFT:
                    if(direction != 'R') {
                        direction = 'L';
                    }
                    break;

                case KeyEvent.VK_RIGHT:
                    if(direction != 'L') {
                        direction = 'R';
                    }
                    break;

                case KeyEvent.VK_UP:
                    if(direction != 'D') {
                        direction = 'U';
                    }
                    break;

                case KeyEvent.VK_DOWN:
                    if(direction != 'U') {
                        direction = 'D';
                    }
                    break;

            }

        }
    }

}

