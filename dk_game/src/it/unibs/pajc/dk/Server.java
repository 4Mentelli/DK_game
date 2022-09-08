package it.unibs.pajc.dk;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Server {

    private int port = 2222;
    ServerSocket server = null;
    Socket client = null;

    DataInputStream in;
    DataOutputStream out;

    public Socket waitConnection(JLabel connection_label) {

        try {
            connection_label.setText("[0] - Analizziamo il server...");
            connection_label.setHorizontalAlignment(SwingConstants.CENTER);
            System.out.println("[0] - Analizziamo il server...");
            server = new ServerSocket(port); //inizializziamo il servizio

            connection_label.setText("[1] - Server pronto in ascolto sulla porta " + port);
            System.out.println();
            client = server.accept(); //mi metto in ascolto sulla porta che ho aperto
            connection_label.setText("[2] - Connesione stabilita con un client");
            System.out.println();

            server.close(); //evitiamo connesioni multiple

            in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return client;
    }
}



