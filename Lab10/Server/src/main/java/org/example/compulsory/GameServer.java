package org.example.compulsory;

import org.example.compulsory.homework.Game;

import java.net.*;
import java.io.*;
import java.util.HashSet;
import java.util.Set;


public class GameServer {
    // Define the port on which the server is listening
    public static final int PORT = 42069;

    public Set<Game> games;

    public GameServer() {
        games = new HashSet<>();
    }

    public void run(){
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                // Execute the client's request in a new thread
                new ClientThread(socket, this).start();
                System.out.println("Player joined.");
            }
        } catch (IOException e) {
            System.err.println("Ooops... " + e);
        }
    }


}