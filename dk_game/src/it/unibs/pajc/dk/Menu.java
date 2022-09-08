package it.unibs.pajc.dk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private JFrame frame;
    private JPanel panel;
    private JTextField player_name;
    private JButton single_player_button;
    private JButton mutliplayer_button;

    public Menu() {
        single_player_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initialize();
            }
        });
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Menu menu = new Menu();
                    menu.setContentPane(menu.panel);
                    menu.setTitle("MENU");
                    menu.setBounds(600, 200, 400, 400);
                    menu.setVisible(true);
                    menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                } catch (Exception var2) {
                    var2.printStackTrace();
                }

            }
        });

    }

    private void initialize() {

        GameView view = new GameView();

        this.frame = new JFrame();
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.add(view);
        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
    }


}

