package it.unibs.pajc.dk;
import java.net.*;
import java.io.*;

public class Client {

    private int port = 2222;
    Socket client = null;

    DataInputStream in;
    DataOutputStream out;

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

}
