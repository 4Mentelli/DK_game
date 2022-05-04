package it.unibs.pajc.dk;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;

public class GameView extends JPanel implements KeyListener {

    protected ArrayList<DKObject> objects = new ArrayList();
    protected Beam b;
    private GameView world;


    public GameView() {

        Timer t = new Timer(10, (e) -> {
            this.repaint();
        });
        t.start();
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(this);

    }


    protected void paintComponent(Graphics g) {



        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        double s = (double)Math.min(this.getWidth(), this.getHeight()) / 1000.0;
        g2.scale(s, -s);
        g2.translate(500, -500);
        g2.setColor(Color.BLACK);
        g2.fillRect(-500, -500, 1000, 1000);


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
