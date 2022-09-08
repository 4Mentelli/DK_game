package it.unibs.pajc.dk;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.Locale;
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

    public void message() {
        try {
            System.out.println("[3] - In attesa di un messaggio...");
            String score = in.readLine();
            System.out.println("[4] - Ricevuto il messaggio: " + score);
            String recived_message = score.toUpperCase(Locale.ROOT);
            System.out.println("[5] - Risposta del server: " + recived_message);
            out.writeBytes(recived_message + "\n");
            //client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



