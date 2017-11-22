package com.toybox.lucasrezende.trabalho_lab_redes;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import ArquivoBase.AES;

/**
 * Created by LucasRezende on 22/11/2017.
 */

public class Client_Chosen_One {

    public static void main(String argv[]) throws Exception {
        String sentence;
        String newString[] = new String[1];
        String secretKey = "secretKey";
        String hash;
        String modifiedSentence;

        //preparaçao
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("localhost", 6789);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        //definiçao do protocolo

        //Mensagem pedindo lista de usuarios ativos

        //escolhe alguem da lista e envia chave

        //recebe dados sobre o usuario

        //estabelece conexao com usuario

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
