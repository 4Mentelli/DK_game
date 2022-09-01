package it.unibs.pajc.dk;

import java.awt.*;

public class DKObject {

    protected Image image;
    protected int [] position = {0, 0};
    protected int [] movement = {0, 0};

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

    public void moveY() {

    }

    public void jump() {

    }
}
