package it.unibs.pajc.dk;

import java.awt.*;
import java.awt.geom.Area;

public class Beam extends DKObject {
    public Beam() {

        this.position[2] = 1.5707964F;
        this.shape = new Area(new Rectangle(700, 10));
        this.color = Color.RED;
    }

}
