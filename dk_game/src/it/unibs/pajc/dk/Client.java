package it.unibs.pajc.dk;
import javax.swing.*;
import java.net.*;
import java.io.*;

public class Client {

    private int port = 2222;
    Socket client = null;

    DataInputStream in;
    DataOutputStream out;
    BufferedReader reader = null;


    public Socket connect(JLabel connection_label) {


        try {

            connection_label.setText("[0] - Provo a connettermi al server...");
            System.out.println("[0] - Provo a connettermi al server...");
            connection_label.setHorizontalAlignment(SwingConstants.CENTER);
            Socket client = new Socket(InetAddress.getLocalHost(), port);

            connection_label.setText("[1] - Connesso al server");
            System.out.println("[1] - Connesso al server");
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

    public void message(String user, JLabel connection_label) {
        try {

            connection_label.setText("[2] - Username del client da inviare al server: " + user);
            System.out.println("[2] - Username del client da inviare al server: " + user);
            out.writeBytes(user+ "\n");

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            connection_label.setText("[3] - In attesa dell'username del server");
            System.out.println("[3] - In attesa dell'username del server");
            String opponent = reader.readLine();
            connection_label.setText("[4] - Username del server: "+ opponent);
            System.out.println("[4] - Username del server: "+ opponent);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
