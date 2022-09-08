package it.unibs.pajc.dk;
import java.net.*;
import java.io.*;

public class Client {

    public static void main(String[] args) throws IOException{

        Socket s = new Socket("localHost", 4999);
    }
}
