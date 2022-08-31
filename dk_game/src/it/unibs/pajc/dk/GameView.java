package it.unibs.pajc.dk;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GameView extends JPanel implements ActionListener {

    protected ArrayList<DKObject> objects = new ArrayList();
    protected Beam b;
    private GameView world;


    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;
    Image donkey;
    Beam beam = new Beam();

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
        timer = new Timer(10, this);
        timer.start();
    }

    public void paint(Graphics g) {

        super.paint(g); // paint background

        Graphics2D g2D = (Graphics2D) g;

        //g2D.drawImage(backgroundImage, 0, 0, null);
        g2D.drawImage(donkey, x, y, null);
        g2D.drawImage(beam.getImage(), beam.getX(), beam.getY(), null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(x>=PANEL_WIDTH-donkey.getWidth(null) || x<0) { xVelocity = xVelocity * -1; }
        x = x + xVelocity;

        repaint();
    }
}
