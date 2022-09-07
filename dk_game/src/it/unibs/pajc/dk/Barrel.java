package it.unibs.pajc.dk;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Barrel extends DKObject{

    protected int vec;
    protected int rotation;

    public Barrel() {
        this.position = new int[]{220,160};
        this.movement = new int[] {4, 5};
        this.vec = 1;
        this.rotation = -1;
        this.height = 30;
        this.width = 30;
        this.alive = true;
        Image im = new ImageIcon("dk_game/src/it/unibs/pajc/dk/images/barrel.png").getImage();
        Image i = im.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        this.image = new ImageIcon(i).getImage();
    }

    /**
     * Manage the movement of the barrel
     *
     */
    public void barrelMovement() {

        this.setX(position[0] += (movement[0] * vec));
        if (this.position[0] >= 10 && this.position[0] <= 780 ) {
            position[0] += movement[0] * vec;
            if (this.rotation < 0) {
                Image im = new ImageIcon("dk_game/src/it/unibs/pajc/dk/images/barrel2.png").getImage();
                Image i = im.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
                this.setImage(new ImageIcon(i).getImage());
            } else {
                Image im = new ImageIcon("dk_game/src/it/unibs/pajc/dk/images/barrel.png").getImage();
                Image i = im.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
                this.setImage(new ImageIcon(i).getImage());
            }
            this.rotation = rotation * -1;
        }
        else if (this.position[0] < 10) {
            if (this.position[1] == 685)
                this.setAlive(false);
            int random = ThreadLocalRandom.current().nextInt();
            if (random % 8 == 0)
                this.setAlive(false);
            this.setX(13);
            this.vec = 1;
        }
        else {
            int random = ThreadLocalRandom.current().nextInt();
            if (random % 4 == 0)
                this.setAlive(false);
            this.setX(776);
            this.vec = -1;
        }

    }
}
