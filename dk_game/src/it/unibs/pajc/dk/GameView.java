package it.unibs.pajc.dk;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GameView extends JPanel implements KeyListener{

    protected ArrayList<DKObject> objects = new ArrayList();
    protected Beam b;
    private GameView world;


    final int PANEL_WIDTH = 736;
    final int PANEL_HEIGHT = 500;
    DonkeyKong kong = new DonkeyKong();
    Mario mario = new Mario();
    ArrayList<Beam> beams = new ArrayList<>();
    int move = 2;


    //Image backgroundImage;
    Timer timer;
    int xVelocity = 1;
    int yVelocity = 1;
    int x = 0;
    int y = 0;

    GameView(){
        Beam beam = new Beam(19, 475);
        beams.add(beam);
        for (int i = 1; i < 7; i++) {
            beam = new Beam(20 + ((i+1) % 2 * 100), 75 * i + 25);
            beams.add(beam);
            beam = new Beam(316 + ((i+1) % 2 * 100), 75 * i + 25);
            beams.add(beam);
        }


        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        this.setBackground(Color.black);

        Timer timer = new Timer(10, (e) -> {
            repaint();
        });

        timer.start();

        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(this);
    }

    public void paint(Graphics g) {

        super.paint(g); // paint background

        Graphics2D g2D = (Graphics2D) g;

        //g2D.drawImage(backgroundImage, 0, 0, null);
        g2D.drawImage(kong.getImage(), kong.getX(), kong.getY(), null);
        g2D.drawImage(mario.getImage(), mario.getX(), mario.getY(), null);
        for (Beam b : beams) {
            g2D.drawImage(b.getImage(), b.getX(), b.getY(), null);
        }

    }

    /*@Override
    public void actionPerformed(ActionEvent e) {

        repaint();
    }*/

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT: { mario.moveX(-1); break; }
            case KeyEvent.VK_RIGHT: { mario.moveX(1); break; }
            case KeyEvent.VK_UP: { mario.moveY(); break; }
            case KeyEvent.VK_DOWN: { mario.moveY(); break; }
            case KeyEvent.VK_SPACE: { mario.jump(); break; }
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}


