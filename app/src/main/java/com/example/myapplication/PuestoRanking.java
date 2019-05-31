package com.example.myapplication;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class PuestoRanking {

    private String usuario;
    private int puntaje;
    private int fondo;
    private String avatar;

    public PuestoRanking(){
        super();
    }

    public PuestoRanking(String usuario, int puntaje, String avatar, int fondo){

        this.usuario = usuario;
        this.puntaje = puntaje;
        this.fondo = fondo;
        this.avatar = avatar;

    }


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getFondo() {
        return fondo;
    }

    public void setFondo(int fondo) {
        this.fondo = fondo;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
