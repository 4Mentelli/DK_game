package it.unibs.pajc.dk;
import javax.swing.*;
import java.net.*;
import java.io.*;

public class Client {

    private int port = 2222;
    Socket client = null;

    DataInputStream in;
    DataOutputStream out;

    BufferedReader reader;

    public Socket connect(JLabel connection_label) {


        try {

            connection_label.setText("[0] - Provo a connettermi al server...");
            connection_label.setHorizontalAlignment(SwingConstants.CENTER);
            Socket client = new Socket(InetAddress.getLocalHost(), port);

            connection_label.setText("[1] - Connesso al server");
            in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());

        } catch (UnknownHostException e) {
            connection_label.setText("Host sconosciuto");
            e.printStackTrace();
        } catch (Exception e) {
            connection_label.setText("Connessione fallita");
        }
        return client;
    }


}
