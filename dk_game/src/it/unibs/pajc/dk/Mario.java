package it.unibs.pajc.dk;

import javax.swing.*;
import java.awt.*;

public class Mario extends DKObject {

    public Mario() {

        this.position = new int[] {114, 444};
        this.movement = new int[] {5, 2};
        Image im = new ImageIcon("dk_game/src/it/unibs/pajc/dk/images/marioStand.png").getImage();
        Image i = im.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        this.image = new ImageIcon(i).getImage();
    }

}
