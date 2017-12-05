package com.toybox.lucasrezende.trabalho_lab_redes;

import android.widget.ListView;

import com.toybox.lucasrezende.trabalho_lab_redes.Models.Usuarios;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import ArquivoBase.AES;

/**
 * Created by LucasRezende on 22/11/2017.
 */

public class Client_Chosen_One {

    private static final int GET_USUARIOS_ATIVOS = 1;
    private final String tokenDeUsuario;
    private List<Usuarios> clientesAtivos;

    public Client_Chosen_One(){
        tokenDeUsuario = geraToken();
    }

    private String geraToken() {
        //gera um token para este usuario;
        return "token1";
    }

    public ArrayList getListUsuarios() throws Exception {
        Object obj = protocolo(GET_USUARIOS_ATIVOS);
        String[] newString ;
        newString = ((String)obj).split("/");
        for(int i = 0; i < newString.length; i++){
            Usuarios newUsuario = new Usuarios();
            String[] tempString = newString[i].split(">");
            newUsuario.setUsuario(tempString[0]);
            newUsuario.setTokenExterno(tempString[1]);
            clientesAtivos.add(newUsuario);
        }
        return ((ArrayList)obj);
    }

    public Object protocolo(int action) throws  Exception {
        switch (action) {
            case 1:
                System.out.println("Requisiçao para servidor: lista de usuarios ativos...");
                return conexao(GET_USUARIOS_ATIVOS);
            case 2:
                System.out.println("Segunda-feira");
                break;
            case 3:
                System.out.println("Terça-feira");
                break;
            case 4:
                System.out.println("Quarta-feira");
                break;
            case 5:
                System.out.println("Quinta-feira");
                break;
            case 6:
                System.out.println("Sexta-feira");
                break;
            case 7:
                System.out.println("Sábado");
                break;
            default:
                System.out.println("Este não é um dia válido!");
                return null;
        }
        return null;
    }

    public Object conexao(int protocolo) throws IOException {
        String sentence;
        String newString[] = new String[1];
        String secretKey = "secretKey";
        String resposta;


        //preparaçao
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("localhost", 6789);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        sentence = String.valueOf(protocolo);
        outToServer.writeBytes(AES.encrypt(sentence, secretKey));

        resposta = inFromServer.readLine();
        resposta = AES.decrypt(resposta, secretKey);
        clientSocket.close();
        return resposta;
    }

}
