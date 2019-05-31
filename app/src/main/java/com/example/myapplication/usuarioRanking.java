package com.example.myapplication;

public class usuarioRanking  {
    public String nombre;
    public int puntajeTotal;
    public String avatar;

    public usuarioRanking(){

    }

    public usuarioRanking(String nombre, int puntajeTotal, String avatar){
        this.nombre = nombre;
        this.puntajeTotal = puntajeTotal;
        this.avatar = avatar;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntajeTotal() {
        return puntajeTotal;
    }

    public String getAvatar() {
        return avatar;
    }
}
