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
    protected int n_jump;


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

    public int getN_jump() { return n_jump; }

    public void setN_jump(int n_jump) { this.n_jump = n_jump; }

    public void moveX(int m) {
        if (this.position[0] >= 10 && this.position[0] <= 780 )
            position[0] += movement[0] * m;
        else if (this.position[0] < 10) this.setX(13);
        else this.setX(776);
    }

    public void moveY(int m) {
        position[1] += movement[1] * m;
    }

    /**
     *
     * @param object1
     * @param object2
     * @return true/false
     */
    public boolean collisionDetector(DKObject object1, DKObject object2) {
        if (object2.position[0] > object1.position[0] && object2.position[0] < object1.position[0] + object1.width) {
            if (object2.position[1] > object1.position[0] && object2.position[1] < object1.position[1] + object1.width) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check the position of the object and return true if there is a ladder in the same place
     *
     * @param ladders
     * @return true/false
     */
    public boolean ladderIsThere(ArrayList<Ladder> ladders, int var) {  //var is used to separate the gravity case and the climbing case, differentiating the ladder/mario range
        for (Ladder l : ladders) {
            if (this.position[0] > l.position[0] - 15 && this.position[0] < l.position[0] + 5)
                for (int i = l.position[1]; i <= l.position[1] + l.height + var; i++)
                    if (this.position[1] + this.height == i )
                        return true;
        }
        return false;
    }

    /**
     * Fix the position of an object when it climb the ladder
     *
     * @return
     */
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

    /**
     * Check the position of an object and return if it is on a beam or not
     *
     * @param ladders
     * @return true/false
     */
    public boolean onBeam(ArrayList<Ladder> ladders, int var) {

        if(this.position[1] == 675 || (this.position[1] == 45 && this.position[0] > 300))
            return true;
        for (int i = 150; i < 600; i += 105) {

            if (this.position[1] == i) {
                if (i % 2 == 0) {
                    if (this.position[0] > 695)
                        return false;
                    else return true;
                }
                else if (i % 2 == 1) {
                    if (this.position[0] < 95)
                        return false;
                    else return true;
                }
            }
        }

        if (ladderIsThere(ladders, var) && this.n_jump != 0)
            return true;
        return false;
    }

    /**
     * Introduce the gravity that take an object down to a beam
     *
     * @param ladders
     */
    public void gravity(ArrayList<Ladder> ladders, int var) {

        if (!onBeam(ladders, var)) this.setY(this.position[1] + this.movement[1]);
    }
}
