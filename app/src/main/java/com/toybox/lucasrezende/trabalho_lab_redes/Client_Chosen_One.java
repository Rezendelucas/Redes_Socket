package com.toybox.lucasrezende.trabalho_lab_redes;

import android.widget.ListView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.List;

import ArquivoBase.AES;

/**
 * Created by LucasRezende on 22/11/2017.
 */

public class Client_Chosen_One {

    private List<String> clientes;

    public Client_Chosen_One() {}

    public void conexao() throws  Exception{
        String sentence;
        String newString[] = new String[1];
        String secretKey = "secretKey";
        String hash;
        String modifiedSentence;
        String tokenconversa;


        //preparaçao
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("localhost", 6789);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        //mensagem
        sentence = inFromUser.readLine();
        outToServer.writeBytes(AES.encrypt(sentence, secretKey) + ";" + sentence + '\n');
        modifiedSentence = inFromServer.readLine();
        newString = modifiedSentence.split(";");
        System.out.println(modifiedSentence);
        System.out.println(newString[0] + " " + newString[1]);
        hash = AES.decrypt(newString[0], secretKey);

        if (hash.equals(newString[1])) {
            System.out.println("FROM SERVER: " + newString[1]);
        }else{
            System.out.println("Mensagem adulterada!");
        }

        clientSocket.close();

    }
}
