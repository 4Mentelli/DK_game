package it.unibs.pajc.dk;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Menu extends JFrame {
    private JFrame frame;
    private JPanel panel;
    private JTextField player_name;
    private JButton single_player_button;
    private JButton join_game_button;
    private JButton host_game_button;
    private JLabel connection_label = null;
    private String player = null;

    public Menu() {
        single_player_button.addActionListener(e -> initialize());
        host_game_button.addActionListener(e -> initializeHostGame());
        join_game_button.addActionListener(e -> initializeClientGame());
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
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

        });

    }

    private void initialize() {

        GameView view = new GameView();

        this.frame = new JFrame();
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.add(view);
        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
    }

    public void initializeHostGame() {
        String user = player_name.getText();
        Server server = new Server();
        server.waitConnection(connection_label);
        server.message(user, connection_label);

        GameView view = new GameView();
        view.setServer(true);
        this.frame = new JFrame();
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.add(view);
        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);



    }

    public void initializeClientGame() {
        String user = player_name.getText();
        Client client = new Client();
        client.connect(connection_label);
        client.message(user, connection_label);

        GameView view = new GameView();
        view.setClient(true);
        this.frame = new JFrame();
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.add(view);
        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
    }
}

