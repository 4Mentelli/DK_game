package it.unibs.pajc.dk;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;

public class Beam extends DKObject {

    private Image image;
    private int x;
    private int y;

    public Beam() {
        image = new ImageIcon("dk_game/src/it/unibs/pajc/dk/beam.png").getImage();
        x = 200;
        y = 200;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
