package it.unibs.pajc.dk;

import javax.swing.*;
import java.awt.*;

public class Mario extends DKObject {

    public Mario() {

        this.x = 114;
        this.y = 444;
        Image im = new ImageIcon("dk_game/src/it/unibs/pajc/dk/images/marioStand.png").getImage();
        Image i = im.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        this.image = new ImageIcon(i).getImage();
    }
}
