package it.unibs.pajc.dk;

import javax.swing.*;
import java.awt.*;

public class DonkeyKong extends DKObject {

    public DonkeyKong() {
        this.x = 114;
        this.y = 30;
        Image im = new ImageIcon("dk_game/src/it/unibs/pajc/dk/donkey.png").getImage();
        Image i = im.getScaledInstance(94, 74, Image.SCALE_SMOOTH);
        this.image = new ImageIcon(i).getImage();
    }
}
