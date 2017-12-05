package com.toybox.lucasrezende.trabalho_lab_redes;

import com.toybox.lucasrezende.trabalho_lab_redes.Models.Usuarios;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import ArquivoBase.AES;

/**
 * Created by LucasRezende on 22/11/2017.
 */

public class Server {
    public static void main(String argv[]) throws Exception {
        String clientSentence;
        String capitalizedSentence;
        String newString[] = new String[1];
        String secretKey = "secretKey";
        String hash;
        ArrayList<Usuarios> usuariosAtivos;


        ServerSocket welcomeSocket = new ServerSocket(6789);
        usuariosAtivos = carregaUsuarios();

        while (true) {
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());


            hash = inFromClient.readLine();
            clientSentence = AES.decrypt(hash, secretKey);
            switch (Integer.parseInt(clientSentence)) {
                case 1:
                    System.out.println("Requisiçao recebida: lista de usuarios ativos...");
                    StringBuilder sb = new StringBuilder();
                    for(Usuarios lst: usuariosAtivos){
                        sb.append(lst.getUsuario() + ">" + lst.getTokenExterno());
                        sb.append("/");
                    }
                    outToClient.writeBytes(AES.encrypt(sb.toString(),secretKey) + '\n');
                    break;
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
                    break;
            }
        }
    }

    private static ArrayList carregaUsuarios() {
        ArrayList<Usuarios> usuarios = new ArrayList<>();
        for(int i = 0 ; i < 10; i++){
          Usuarios newUsuario = new Usuarios("usuario:" + i, "token" + i);
          usuarios.add(newUsuario);
        }
        return  usuarios;
    }
}
