package it.unibs.pajc.dk;

import javax.swing.*;
import java.awt.*;

public class Peach extends DKObject{

    public Peach() {
        this.position = new int[]{495,42};
        Image im = new ImageIcon("dk_game/src/it/unibs/pajc/dk/images/peach.png").getImage();
        Image i = im.getScaledInstance(80, 43, Image.SCALE_SMOOTH);
        this.image = new ImageIcon(i).getImage();
    }
}
