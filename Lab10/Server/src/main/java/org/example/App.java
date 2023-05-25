package org.example;

import org.example.compulsory.GameServer;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        GameServer server = new GameServer();
        server.run();
    }
}
