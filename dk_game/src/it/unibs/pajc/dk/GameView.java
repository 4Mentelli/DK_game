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


    final int PANEL_WIDTH = 736;
    final int PANEL_HEIGHT = 500;
    DonkeyKong kong = new DonkeyKong();
    ArrayList<Beam> beams = new ArrayList<>();


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
        //backgroundImage = new ImageIcon("space.png").getImage();
        timer = new Timer(10, this);
        timer.start();
    }

    public void paint(Graphics g) {

        super.paint(g); // paint background

        Graphics2D g2D = (Graphics2D) g;

        //g2D.drawImage(backgroundImage, 0, 0, null);
        g2D.drawImage(kong.getImage(), kong.getX(), kong.getY(), null);
        for (Beam b : beams) {
            g2D.drawImage(b.getImage(), b.getX(), b.getY(), null);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(x>=PANEL_WIDTH-kong.getImage().getWidth(null) || x<0) { xVelocity = xVelocity * -1; }
        x = x + xVelocity;

        repaint();
    }



}


