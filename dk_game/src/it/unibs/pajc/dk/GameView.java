package it.unibs.pajc.dk;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GameView extends JPanel implements ActionListener, KeyListener {

    final int PANEL_WIDTH = 826;
    final int PANEL_HEIGHT = 760;
    DonkeyKong kong = new DonkeyKong();
    Mario mario = new Mario();
    ArrayList<Ladder> ladders = new ArrayList<>();
    //Ladder ladder = new Ladder(658, 610);
    //Ladder ladder2= new Ladder(144,505);
    ArrayList<Beam> beams = new ArrayList<>();

    GameView(){

        Beam beam = new Beam(17, 715);
        beams.add(beam);
        for (int i = 1; i < 7; i++) {
            beam = new Beam(20 + ((i+1) % 2 * 100), 105 * i + 85);
            beams.add(beam);
            beam = new Beam(332 + ((i+1) % 2 * 100), 105 * i + 85);
            beams.add(beam);
        }

        for (int i = 0; i < 5; i++) {
            Ladder ladder = new Ladder(144 + ((i+1) % 2 * 514), (i * 105) + 190);
            ladders.add(ladder);
        }



        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        this.setBackground(Color.black);

        Timer timer = new Timer(5, this);

        timer.start();
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.setFocusTraversalKeysEnabled(false);
        this.addKeyListener(this);

    }

    public void paint(Graphics g) {

        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(kong.getImage(), kong.getPosition()[0], kong.getPosition()[1], null);
        for (Beam b : beams)
            g2D.drawImage(b.getImage(), b.getPosition()[0], b.getPosition()[1], null);
        for (Ladder l : ladders)
            g2D.drawImage(l.getImage(), l.getPosition()[0], l.getPosition()[1], null);
        //g2D.drawImage(ladder.getImage(), ladder.getPosition()[0], ladder.getPosition()[1], null);
        //g2D.drawImage(ladder2.getImage(), ladder2.getPosition()[0], ladder2.getPosition()[1], null);
        g2D.drawImage(mario.getImage(), mario.getPosition()[0], mario.getPosition()[1], null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT: { mario.moveX(-1); break; }
            case KeyEvent.VK_RIGHT: { mario.moveX(1); break; }
            case KeyEvent.VK_UP: { mario.moveY(); break; }
            case KeyEvent.VK_DOWN: { mario.moveY(); break; }
            case KeyEvent.VK_SPACE: { mario.jump(); break; }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}


