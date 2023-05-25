package org.example.compulsory;

import java.net.*;
import java.io.*;


public class ClientThread extends Thread {
    private Socket socket = null;
    private GameServer server=null;

    public ClientThread(Socket socket,GameServer server) {
        this.socket = socket;
        this.server=server;
    }

    public void run() {

        String cerere, raspuns;
        try {

            BufferedReader in = new BufferedReader(new
                    InputStreamReader(
                    socket.getInputStream()));
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream());

            cerere = in.readLine();

            raspuns = " Hello " + cerere + " ! ";
            out.println(raspuns);
            out.flush();
        } catch (IOException e) {
            System.err.println(" Error (IO) \n " + e);
        } finally {

            try {
                socket.close();
            } catch (IOException e) {
                System.err.println(" Socketul nu poate fi inchis \n " + e);
            }
        }
    }
}
