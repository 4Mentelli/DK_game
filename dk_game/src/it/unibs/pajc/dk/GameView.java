package it.unibs.pajc.dk;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GameView extends JPanel implements KeyListener {

    protected ArrayList<DKObject> objects = new ArrayList();
    protected Beam b;
    private GameView world;


    final int PANEL_WIDTH = 500;
    Image donkey;
    final int PANEL_HEIGHT = 500;

    //Image backgroundImage;
    Timer timer;
    int xVelocity = 1;
    int yVelocity = 1;
    int x = 0;
    int y = 0;

    GameView(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        this.setBackground(Color.black);
        donkey = new ImageIcon("dk_game/src/it/unibs/pajc/dk/donkey.png").getImage();
        //backgroundImage = new ImageIcon("space.png").getImage();
        //timer = new Timer(10, (ActionListener) this);
        //timer.start();
    }

    public void paint(Graphics g) {

        super.paint(g); // paint background

        Graphics2D g2D = (Graphics2D) g;

        //g2D.drawImage(backgroundImage, 0, 0, null);
        g2D.drawImage(donkey, x, y, null);
    }




    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
