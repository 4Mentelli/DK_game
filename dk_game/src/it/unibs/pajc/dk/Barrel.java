package it.unibs.pajc.dk;

import javax.swing.*;
import java.awt.*;

public class Barrel extends DKObject{

    public Barrel() {
        this.position = new int[] {50, 113};
        this.width = 50;
        this.height = 77;
        Image im = new ImageIcon("dk_game/src/it/unibs/pajc/dk/images/barrel2.png").getImage();
        Image i = im.getScaledInstance(50, 77, Image.SCALE_SMOOTH);
        this.image = new ImageIcon(i).getImage();
    }
}
