package it.unibs.pajc.dk;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Ladder extends DKObject {

    public Ladder(int x, int y) {

        this.position = new int[] {x, y};
        this.width = 26;
        this.height = 105;
        Image im = new ImageIcon("dk_game/src/it/unibs/pajc/dk/images/ladder.png").getImage();
        Image i = im.getScaledInstance(26, 105, Image.SCALE_SMOOTH);
        this.image = new ImageIcon(i).getImage();
    }
}
