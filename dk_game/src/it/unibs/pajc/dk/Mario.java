package it.unibs.pajc.dk;

import javax.swing.*;
import java.awt.*;

public class Mario extends DKObject {

    public Mario() {

        this.position = new int[] {160, 675};
        this.movement = new int[] {8, 5};
        Image im = new ImageIcon("dk_game/src/it/unibs/pajc/dk/images/marioStandLeft.png").getImage();
        Image i = im.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        this.image = new ImageIcon(i).getImage();
    }

    @Override
    public void moveX(int m) {
        if (m < 0) {
            Image image = new ImageIcon("dk_game/src/it/unibs/pajc/dk/images/marioStand.png").getImage();
            Image scaled_image = image.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            this.setImage(new ImageIcon(scaled_image).getImage());
        }
        else {
            Image image = new ImageIcon("dk_game/src/it/unibs/pajc/dk/images/marioStandLeft.png").getImage();
            Image scaled_image = image.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            this.setImage(new ImageIcon(scaled_image).getImage());
        }
        super.moveX(m);
    }
}
