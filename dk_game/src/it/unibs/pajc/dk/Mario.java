package it.unibs.pajc.dk;

import javax.swing.*;
import java.awt.*;

public class Mario extends DKObject {

    public Mario() {

        this.position = new int[] {160, 675};
        this.movement = new int[] {7, 5};
        Image im = new ImageIcon("dk_game/src/it/unibs/pajc/dk/images/marioStandRight.png").getImage();
        Image i = im.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        this.image = new ImageIcon(i).getImage();
    }

    @Override
    public void moveX(int m) {
        if (m < 0) {
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

    public void stand(int m) {
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
}
