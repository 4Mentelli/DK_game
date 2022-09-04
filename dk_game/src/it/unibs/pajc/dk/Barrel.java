package it.unibs.pajc.dk;

import javax.swing.*;
import java.awt.*;

public class Barrel extends DKObject{

    int vec;

    public Barrel() {
        this.position = new int[]{220,150};
        this.movement = new int[] {1, 5};
        this.vec = 1;
        this.height = 30;
        this.width = 30;
        Image im = new ImageIcon("dk_game/src/it/unibs/pajc/dk/images/barrel.png").getImage();
        Image i = im.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        this.image = new ImageIcon(i).getImage();
    }

    /**
     * Manage the movement of the barrel
     *
     */
    public void barrelMovement(){

        this.setX(position[0] += (movement[0] * vec));
        if (this.position[0] >= 10 && this.position[0] <= 780 ) {
            position[0] += movement[0] * vec;
        }
        else if (this.position[0] < 10) {
            this.setX(13);
            this.vec = 1;
        }
        else {
            this.setX(776);
            this.vec = -1;
        }

    }

    public void rotation(int rotation) {

    }

}
