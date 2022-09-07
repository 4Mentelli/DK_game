package it.unibs.pajc.dk;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DonkeyKong extends DKObject {

    public DonkeyKong() {
        this.position = new int[] {114, 108};
        this.width = 118;
        this.height = 92;
        Image im = new ImageIcon("dk_game/src/it/unibs/pajc/dk/images/donkeyRight.png").getImage();
        Image i = im.getScaledInstance(118, 92, Image.SCALE_SMOOTH);
        this.image = new ImageIcon(i).getImage();
    }

    public void setReleasingImage() {
        Image im = new ImageIcon("dk_game/src/it/unibs/pajc/dk/images/donkeyRight.png").getImage();
        Image i = im.getScaledInstance(118, 92, Image.SCALE_SMOOTH);
        this.image = new ImageIcon(i).getImage();
    }

    public void resetStandingImage(ArrayList<Barrel> barrels) {
        Image im = new ImageIcon("dk_game/src/it/unibs/pajc/dk/images/donkey.png").getImage();
        Image i = im.getScaledInstance(118, 92, Image.SCALE_SMOOTH);
        if (barrels.get(barrels.size() - 1).position[0] > 280 && barrels.get(barrels.size() - 1).position[0] < 285 && barrels.get(barrels.size() - 1).position[1] == 160)
            this.image = new ImageIcon(i).getImage();
    }
}
