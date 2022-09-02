package it.unibs.pajc.dk;

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
            if (this.position[0] > l.position[0] - 10 && this.position[0] < l.position[0] + 10)
                for (int i = l.position[1]; i <= l.position[1] + l.height; i++)
                    if (this.position[1] + this.height == i )
                        return true;
        }
        return false;
    }
}
