package it.unibs.pajc.dk;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;

public class Beam extends DKObject {

    public Beam(int x, int y) {

        this.position = new int[] {x, y};
        Image im = new ImageIcon("dk_game/src/it/unibs/pajc/dk/images/beam.png").getImage();
        Image i = im.getScaledInstance(300, 20, Image.SCALE_SMOOTH);
        this.image = new ImageIcon(i).getImage();
    }
}
