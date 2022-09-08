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

<<<<<<< HEAD
=======
    public void message() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("[2] - Messaggio da inviare al server: ");
            String message = reader.readLine();
            System.out.println("[3] - invio: "+ message);
            out.writeBytes(message + "\n");
            System.out.println("[4] - in attesa di una risposta");
            String recived = in.readLine();
            System.out.println("risposta del server: "+ recived);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
>>>>>>> 6805c77fa58bffd12a6bbf269c5f0ff181c5af4e

}
