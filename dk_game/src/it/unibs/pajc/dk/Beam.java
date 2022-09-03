package it.unibs.pajc.dk;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;

public class Beam extends DKObject {

    public Beam(int x, int y) {

        this.position = new int[] {x, y};
        this.width = 375;
        this.height = 25;
        Image im = new ImageIcon("dk_game/src/it/unibs/pajc/dk/images/beam.png").getImage();
        Image i = im.getScaledInstance(375, 25, Image.SCALE_SMOOTH);
        this.image = new ImageIcon(i).getImage();
    }
}
