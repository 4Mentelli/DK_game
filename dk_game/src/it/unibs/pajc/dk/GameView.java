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
    Peach peach = new Peach();
    Barrel barrelGroup = new Barrel();
    ArrayList<Ladder> ladders = new ArrayList<>();
    ArrayList<Beam> beams = new ArrayList<>();

    GameView(){

        //Create the beams
        Beam beam = new Beam(17, 715); //First beam
        beams.add(beam);
        beam = new Beam(332,85); //Peach beam
        beams.add(beam);
        for (int i = 1; i < 7; i++) {
            beam = new Beam(20 + ((i+1) % 2 * 100), 105 * i + 85);
            beams.add(beam);
            beam = new Beam(332 + ((i+1) % 2 * 100), 105 * i + 85);
            beams.add(beam);
        }

        //Create the ladders
        Ladder ladder = new Ladder(355 ,85); //Peach ladder
        ladders.add(ladder);
        for (int i = 0; i < 5; i++) {
            ladder = new Ladder(144 + ((i+1) % 2 * 514), (i * 105) + 190);
            ladders.add(ladder);
        }

        //Set the size of the panel
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

        super.paint(g); //paint background
        Graphics2D g2D = (Graphics2D) g;

        //Paint the object
        g2D.drawImage(kong.getImage(), kong.getPosition()[0], kong.getPosition()[1], null); //Donkey Kong
        for (Beam b : beams)
            g2D.drawImage(b.getImage(), b.getPosition()[0], b.getPosition()[1], null); //Beams
        for (Ladder l : ladders)
            g2D.drawImage(l.getImage(), l.getPosition()[0], l.getPosition()[1], null); //Ladders
        g2D.drawImage(mario.getImage(), mario.getPosition()[0], mario.getPosition()[1], null); //Mario
        g2D.drawImage(peach.getImage(), peach.getPosition()[0], peach.getPosition()[1], null); //Peach
        g2D.drawImage(barrelGroup.getImage(), barrelGroup.getPosition()[0], barrelGroup.getPosition()[1], null); //BarrelGroup
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        mario.gravity(ladders);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT: {
                if (mario.fixPosition())
                    mario.moveX(-1);
                break;
            }
            case KeyEvent.VK_RIGHT: {
                if (mario.fixPosition())
                    mario.moveX(1);
                break;
            }
            case KeyEvent.VK_UP: { if (mario.ladderIsThere(ladders)) mario.moveY(-1); break; }
            case KeyEvent.VK_DOWN: { if (mario.ladderIsThere(ladders)) mario.moveY(1); break; }
            case KeyEvent.VK_SPACE: { mario.jump(); break; }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT: { if (mario.fixPosition()) mario.stand(-1); break; }
            case KeyEvent.VK_RIGHT: { if (mario.fixPosition()) mario.stand(1); break; }
            case KeyEvent.VK_UP: { mario.fixPosition(); break; }
            case KeyEvent.VK_DOWN: { mario.fixPosition(); break; }
        }
    }
}


