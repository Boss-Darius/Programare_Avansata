package org.example.compulsory;

import java.net.*;
import java.io.*;


public class GameClient {
    public static void main(String[] args) throws IOException {
// Adresa IP a serverului
        String adresaServer = "127.0.0.1";
// Portul la care serverul ofera serviciul
        int PORT = 42069;
        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        String cerere, raspuns;
        try {
            socket = new Socket(adresaServer, PORT);

            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
// Trimitem o cerere la server
            cerere = " Duke ";
            out.println(cerere);
// Asteaptam raspunsul de la server (" Hello Duke !")
            raspuns = in.readLine();
            System.out.println(raspuns);
        } catch (UnknownHostException e) {
            System.err.println(" Serverul nu poate fi gasit \n " + e)
            ;
            System.exit(1);
        } finally {
            if (out != null)
                out.close();
            if (in != null)
                in.close();
            if (socket != null)
                socket.close();
        }
    }
}