package it.unibs.pajc.dk;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DKObject {

    protected Image image;
    protected int [] position = {0, 0};
    protected int [] movement = {0, 0};
    protected int height;
    protected int width;


    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int [] getPosition() {
        return position;
    }

    public void setX(int x) { this.position[0] = x; }
    public void setY(int y) { this.position[1] = y; }

    public void moveX(int m) {
        position[0] += movement[0] * m;
    }

    public void moveY(int m) {
        position[1] += movement[1] * m;
    }

    public void jump() {

    }

    public boolean collisionDetector(DKObject object1, DKObject object2) {
        if (object2.position[0] > object1.position[0] && object2.position[0] < object1.position[0] + object1.width) {
            if (object2.position[1] > object1.position[0] && object2.position[1] < object1.position[1] + object1.width) {
                return true;
            }
        }
        return false;
    }

    public boolean ladderIsThere(ArrayList<Ladder> ladders) {
        for (Ladder l : ladders) {
            if (this.position[0] > l.position[0] - 15 && this.position[0] < l.position[0] + 5)
                for (int i = l.position[1]; i <= l.position[1] + l.height; i++)
                    if (this.position[1] + this.height == i )
                        return true;
        }
        return false;
    }

    public boolean fixPosition() {
        for (int i = 45; i < 700; i += 105)
            if (this.position[1] > i - 8 && this.position[1] < i + 8) {
                this.setY(i);
                Image image = new ImageIcon("dk_game/src/it/unibs/pajc/dk/images/marioStandRight.png").getImage();
                Image scaled_image = image.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
                this.setImage(new ImageIcon(scaled_image).getImage());
                return true;
            }
        return false;
    }
}
