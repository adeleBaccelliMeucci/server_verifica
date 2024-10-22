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
            
            System.out.println("n da indovinare: " + numero); // numero da indovinare POI COMMENTA

            String numeroRicevuto = new String(); // tentativo

            boolean uguale = false;
            int tentativi = 0;
            
            do {


               

                int nRicevuto;
                do {
                    numeroRicevuto = in.readLine(); // sta in ascolto
                    //System.out.println(" numeroRicevuto = in.readLine();  " + numeroRicevuto);
                    
                    
                    // da rivedere
                    // da fare la verifica se quello è non ha lettere ed è compreso DA FARE
                    nRicevuto = Integer.parseInt(numeroRicevuto);// prendo
                    //System.out.println("stringa a int: " + nRicevuto);

                    if (nRicevuto < 0 || nRicevuto > 99) {
                        out.writeBytes("?" + '\n');
                    }

                } while (nRicevuto < 0 || nRicevuto > 99);

                

                tentativi++;

                // comparo i numeri
                if (nRicevuto > numero) {
                    // quello dato è grosso
                    out.writeBytes(">" + '\n');

                } else if (nRicevuto < numero) {
                    out.writeBytes("<" + '\n');
                } else {
                    // uguali indovinato
                    out.writeBytes("=" + '\n');
                    uguale = true;
                }

            } while (!uguale); // ripeti finchè non è uguale

            out.writeBytes(Integer.toString(tentativi) + '\n');



        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
