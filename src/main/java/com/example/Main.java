package com.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        
        System.out.println("server avviato");
        ServerSocket s1 = new ServerSocket(3000); //server

        do {

            Socket s = s1.accept(); //sta fermo finchè non si collega
            System.out.println("un client si è collegato");

            

            MioThread t = new MioThread(s);
            t.start();

            

        } while (true);
        
        
        
    }
}