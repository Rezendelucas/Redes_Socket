package com.toybox.lucasrezende.trabalho_lab_redes;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

import Models.AMensagem;

/**
 * Created by LucasRezende on 29/11/2017.
 */

public class Comunicaçao_Server {

    private static Comunicaçao_Server instance = null;
    private AMensagem msg;
    private ArrayList<String> listUsuarios;

    public Comunicaçao_Server(){
    }

    public static Comunicaçao_Server getInstance() {
        if (instance == null) {
            instance = new Comunicaçao_Server();
        }
        return instance;
    }

    public AMensagem getNovaMensagen() {
        return msg;
    }

    public ArrayList<String> getListUsuarios() {
        listUsuarios = PushUsuarios();
        return listUsuarios;  //eu quero a lista de usuarios pra setar no adpter
    }

    private ArrayList<String> PushUsuarios() {
        //pesca no server a list de usuarios ativos
        return null; //return a lista
    }
}
