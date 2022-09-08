package it.unibs.pajc.dk;
import java.net.*;
import java.io.*;

public class Client {

    private int port = 2222;
    Socket client = null;

    DataInputStream in;
    DataOutputStream out;
    BufferedReader reader = null;

    public Socket connect() {
        try {
            System.out.println("[0] - Provo a connettermi al server...");
            Socket client = new Socket(InetAddress.getLocalHost(), port);

            System.out.println("[1] - Connesso al server");
            in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());
        } catch (UnknownHostException e) {
            System.err.println("Host sconosciuto");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Connessione fallita");
        }
        return client;
    }

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

}
