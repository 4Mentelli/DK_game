package it.unibs.pajc.dk;

import javax.swing.*;
import java.awt.*;

public class Ladder extends DKObject {

    public Ladder(int x, int y) {

        this.position = new int[] {x, y};
        Image im = new ImageIcon("dk_game/src/it/unibs/pajc/dk/images/ladder.png").getImage();
        Image i = im.getScaledInstance(24, 75, Image.SCALE_SMOOTH);
        this.image = new ImageIcon(i).getImage();
    }
}
