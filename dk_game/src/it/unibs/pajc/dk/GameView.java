package it.unibs.pajc.dk;


import javax.print.attribute.standard.Media;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.awt.Font;
import javax.sound.sampled.*;


public class GameView extends JPanel implements ActionListener, KeyListener {

    final int PANEL_WIDTH = 826;
    final int PANEL_HEIGHT = 760;
    DonkeyKong kong = new DonkeyKong();
    Mario mario = new Mario();
    Peach peach = new Peach();
    ArrayList<Ladder> ladders = new ArrayList<>();
    ArrayList<Beam> beams = new ArrayList<>();
    ArrayList<Barrel> barrels = new ArrayList<>();
    private boolean left = false;
    private boolean up = false;
    private boolean down = false;
    private boolean right = false;
    private boolean space = false;

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

        //Create the barrels
        Barrel barrel = new Barrel();
        barrels.add(barrel);

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

        //Graphics of barrel group
        Image barrelGroup = new ImageIcon("dk_game/src/it/unibs/pajc/dk/images/barrelGroup.png").getImage();
        Image i = barrelGroup.getScaledInstance(50, 77, Image.SCALE_SMOOTH);
        barrelGroup = new ImageIcon(i).getImage();

        Image lifes = new ImageIcon("dk_game/src/it/unibs/pajc/dk/images/marioRight.png").getImage();
        Image li = lifes.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        lifes = new ImageIcon(li).getImage();


        //Paint the object
        g2D.drawImage(kong.getImage(), kong.getPosition()[0], kong.getPosition()[1], null); //Donkey Kong
        for (Beam b : beams)
            g2D.drawImage(b.getImage(), b.getPosition()[0], b.getPosition()[1], null); //Beams
        for (Ladder l : ladders)
            g2D.drawImage(l.getImage(), l.getPosition()[0], l.getPosition()[1], null); //Ladders
        for (Barrel ba : barrels)
            g2D.drawImage(ba.getImage(), ba.getPosition()[0], ba.getPosition()[1], null); //Barrel
        g2D.drawImage(mario.getImage(), mario.getPosition()[0], mario.getPosition()[1], null); //Mario
        g2D.drawImage(peach.getImage(), peach.getPosition()[0], peach.getPosition()[1], null); //Peach
        g2D.drawImage(barrelGroup, 50, 113, null); //BarrelGroup
        for (int j = 0; j < mario.getLifes() - 1; j++)
            g2D.drawImage(lifes, j * 40 +10, 10, null);

        if (mario.getLifes() == 0) {
            g2D.setColor(Color.WHITE);
            g2D.setFont(new Font("dialoginput", Font.BOLD, 100));
            g2D.drawString("Hai perso", PANEL_WIDTH / 2 - 300, PANEL_HEIGHT / 2);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (mario.isAlive()) {
            thread.run();
            barrel_thread.run();
            repaint();

            mario.gravity(ladders, 10);
            kong.resetStandingImage(barrels);


            if (mario.getN_jump() > 0) {

                mario.setY(mario.position[1] - 2 * mario.movement[1]);
                mario.setN_jump(mario.getN_jump() - 1);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT: { left = true; break; }
            case KeyEvent.VK_RIGHT: { right = true; break; }
            case KeyEvent.VK_UP: { up = true; break; }
            case KeyEvent.VK_DOWN: { down = true; break; }
            case KeyEvent.VK_SPACE: { space = true; break; }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT: { if (mario.fixPosition()) mario.stand(-1); left = false; break; }
            case KeyEvent.VK_RIGHT: { if (mario.fixPosition()) mario.stand(1); right = false; break; }
            case KeyEvent.VK_UP: { mario.fixPosition(); up = false; break; }
            case KeyEvent.VK_DOWN: { mario.fixPosition(); down = false; break; }
            case KeyEvent.VK_SPACE:{ space = false; break; }
        }
    }

    public Thread thread = new Thread(() -> {
        try {
            while (true) {
                if (left && space) {
                    mario.moveX(-1);
                    mario.jump();
                    break;

                } else if (right && space) {
                    mario.moveX(1);
                    mario.jump();
                    break;

                } else if (down && space) {
                    break;

                } else if (left) {
                    if (mario.fixPosition()) {
                        mario.moveX(-1);
                        if (!mario.onBeam(ladders, 0))
                            left = false;
                    }
                    break;

                } else if (right) {
                    if (mario.fixPosition()) {
                        mario.moveX(1);
                        if (!mario.onBeam(ladders, 0))
                            right = false;
                    }
                    break;

                } else if (up) {
                    mario.setFalling(false);
                    if (mario.ladderIsThere(ladders, 0))
                        mario.moveY(-1);
                    break;

                } else if (down) {
                    if (mario.onBeam(ladders, 0))
                        mario.setFalling(false);
                    if (mario.ladderIsThere(ladders, 0))
                        mario.moveY(1);
                    break;

                } else if (space) {
                    mario.setFalling(true);
                    mario.jump();
                    break;

                } else break;
            }
            Thread.sleep(10);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(0);
        }
    });

    public Thread barrel_thread = new Thread(() -> {
        try {
            for (int i = 0; i < barrels.size(); i++) {
                barrels.get(i).barrelMovement();
                barrels.get(i).gravity(ladders, 0);
                if (mario.checkCollision(barrels.get(i))) {
                    Thread.sleep(2000);
                    mario.resetWorld(barrels);
                }


                if (barrels.get(i).position[0] > 300 && barrels.get(i).position[0] < 305 && barrels.get(i).position[1] == 370) {
                    Barrel new_b = new Barrel();
                    barrels.add(new_b);
                    kong.setReleasingImage();
                }
                if (barrels.get(i).position[0] > 300 && barrels.get(i).position[0] < 305 && barrels.get(i).position[1] == 580 && barrels.size() == 1) {
                    Barrel new_b = new Barrel();
                    barrels.add(new_b);
                    kong.setReleasingImage();
                }
                if (!barrels.get(i).isAlive()) {
                    barrels.remove(barrels.get(i));
                    if (barrels.size() == 0) {
                        Barrel new_barrel = new Barrel();
                        barrels.add(new_barrel);
                        kong.setReleasingImage();
                    }
                }
            }
            Thread.sleep(10);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(0);
        }
    });

    public Thread thread_sound = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                playSound("dk_game/src/it/unibs/pajc/dk/sounds/bacmusic.wav");

            }catch (Exception ex) {
                ex.printStackTrace();
                System.exit(0);
            }
        }
    });

    public void playSound(String sound) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        File file = new File(sound);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();

    }

}


