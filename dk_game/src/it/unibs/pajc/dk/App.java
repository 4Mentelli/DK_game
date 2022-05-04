package it.unibs.pajc.dk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class App{
    private JFrame frame;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    App window = new App();
                    window.frame.setVisible(true);
                } catch (Exception var2) {
                    var2.printStackTrace();
                }

            }
        });
    }

    public App() {
        initialize();
    }

    private void initialize() {
        this.frame = new JFrame();
        this.frame.setBounds(100, 100, 872, 900);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameView view = new GameView();
        this.frame.getContentPane().add(view, "Center");
    }
}
