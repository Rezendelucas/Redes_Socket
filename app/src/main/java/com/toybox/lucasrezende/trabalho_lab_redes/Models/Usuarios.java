package com.toybox.lucasrezende.trabalho_lab_redes.Models;

/**
 * Created by LucasRezende on 05/12/2017.
 */

public class Usuarios {
    private String usuario;
    private String tokenExterno;

    public Usuarios(String usuario, String tokenExterno) {
        this.usuario = usuario;
        this.tokenExterno = tokenExterno;
    }

    public Usuarios() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTokenExterno() {
        return tokenExterno;
    }

    public void setTokenExterno(String tokenExterno) {
        this.tokenExterno = tokenExterno;
    }
}
