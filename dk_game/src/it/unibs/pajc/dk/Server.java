package it.unibs.pajc.dk;
import javax.swing.*;
import java.net.*;
import java.io.*;

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
            System.out.println("[1] - Server pronto in ascolto sulla porta " + port);
            client = server.accept(); //mi metto in ascolto sulla porta che ho aperto
            connection_label.setText("[2] - Connesione stabilita con un client");
            System.out.println("[2] - Connesione stabilita con un client");

            server.close(); //evitiamo connesioni multiple

            in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return client;
    }

    public void message(String user, JLabel connection_label) {
        try {
            out.writeBytes(user+"\n");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            connection_label.setText("[3] - In attesa dell'username del client...");
            System.out.println("[3] - In attesa dell'username del client...");
            String opponent = reader.readLine();

            connection_label.setText("[4] - Username del client: " + opponent);
            System.out.println("[4] - Username del client: " + opponent);

            connection_label.setText("[5] - Mando al client l'Username del server: " + user);
            System.out.println("[5] - Mando al client l'Username del server: " + user);

            //client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}



