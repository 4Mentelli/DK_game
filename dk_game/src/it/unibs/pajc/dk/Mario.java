package it.unibs.pajc.dk;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Mario extends DKObject {



    public Mario() {

        //Mario all'inizio del gioco
        this.position = new int[] {160, 675};
        this.movement = new int[] {7, 5};
        this.height = 40;
        this.width = 40;
        this.n_jump = 0;
        Image im = new ImageIcon("dk_game/src/it/unibs/pajc/dk/images/marioStandRight.png").getImage();
        Image i = im.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        this.image = new ImageIcon(i).getImage();
    }

    /**
     * Manage the movement on the x-axis of Mario
     *
     * @param m
     */
    @Override
    public void moveX(int m) {
        if (m < 0) {
            //ANIMATION: Mario runs right
            if (this.position[0] % 2 == 0) {
                Image image = new ImageIcon("dk_game/src/it/unibs/pajc/dk/images/marioRun1.png").getImage();
                Image scaled_image = image.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                this.setImage(new ImageIcon(scaled_image).getImage());
            }
            else {
                Image image = new ImageIcon("dk_game/src/it/unibs/pajc/dk/images/marioRun2.png").getImage();
                Image scaled_image = image.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                this.setImage(new ImageIcon(scaled_image).getImage());
            }
        }
        else {
            //ANIMATION: Mario runs left
            if (this.position[0] % 2 == 0) {
                Image image = new ImageIcon("dk_game/src/it/unibs/pajc/dk/images/marioRun3.png").getImage();
                Image scaled_image = image.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                this.setImage(new ImageIcon(scaled_image).getImage());
            }
            else {
                Image image = new ImageIcon("dk_game/src/it/unibs/pajc/dk/images/marioRun4.png").getImage();
                Image scaled_image = image.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                this.setImage(new ImageIcon(scaled_image).getImage());
            }
        }
        super.moveX(m);
    }


    /**
     * Manage the movement on the y-axis of Mario
     *
     * @param m
     */
    public void moveY(int m) {
        //ANIMATION: Mario climbs
        if (this.position[1] % 2 == 0) {
            Image image = new ImageIcon("dk_game/src/it/unibs/pajc/dk/images/climbingMario.png").getImage();
            Image scaled_image = image.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            this.setImage(new ImageIcon(scaled_image).getImage());
        }
        else {
            Image image = new ImageIcon("dk_game/src/it/unibs/pajc/dk/images/climbingMario2.png").getImage();
            Image scaled_image = image.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            this.setImage(new ImageIcon(scaled_image).getImage());
        }
        super.moveY(m);
    }

    /**
     * Manage Mario when he stops
     *
     * @param m
     */
    public void stand(int m) {
        //ANIMATION: Mario stands
        if (m > 0) {
            Image image = new ImageIcon("dk_game/src/it/unibs/pajc/dk/images/marioStandRight.png").getImage();
            Image scaled_image = image.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            this.setImage(new ImageIcon(scaled_image).getImage());
        } else {
            Image image = new ImageIcon("dk_game/src/it/unibs/pajc/dk/images/marioStandLeft.png").getImage();
            Image scaled_image = image.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            this.setImage(new ImageIcon(scaled_image).getImage());
        }
    }

    public void jump() {
        ArrayList<Ladder> ladders = new ArrayList<>();
        if (this.onBeam(ladders, 0))
            this.setN_jump(8);
    }
}
