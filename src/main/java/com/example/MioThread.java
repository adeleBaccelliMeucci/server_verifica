package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Random;

public class MioThread extends Thread {

    private Socket s;

    public MioThread(Socket s) {
        this.s = s;
    }

    public void run() {

        // run
        
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            
            // numero
            Random random = new Random();
            int numero = random.nextInt(100);
            System.out.println(numero); //numero da indovinare POI COMMENTA
            
            String numeroRicevuto = new String(); //tentativo
            numeroRicevuto = in.readLine();

            //da fare la verifica se quello è non ha lettere ed è compreso DA FARE
            int nRicevuto = Integer.parseInt(numeroRicevuto);//prendo 

            //comparo i numeri





            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
