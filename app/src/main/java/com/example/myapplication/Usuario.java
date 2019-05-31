package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nombre, correo, contraseña, uid, avatar;

    private ArrayList<Integer> puntajes;
    private ArrayList<String> resp;



    private int puntajeTotal;

    public Usuario(){

    }

    public Usuario(String nombre, String correo, String contraseña, String uid){
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;

        this.uid = uid;

        this.puntajeTotal=0;

        this.puntajes= new ArrayList<Integer>();

        for (int i=0; i<6; i++){
            puntajes.add(0);
        }
    }

    public Usuario(String nombre, String correo, String contraseña, String uid, String avatar, int puntajeTotal, ArrayList<Integer> puntajes ){
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;

        this.uid = uid;
        this.avatar= avatar;
        this.puntajeTotal=puntajeTotal;


        this.puntajes=puntajes;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public ArrayList<Integer> getPuntajes() {
        return puntajes;
    }

    public void setPuntajes(ArrayList<Integer> puntajes) {
        this.puntajes = puntajes;
    }

    public int getPuntajeTotal() {
        return puntajeTotal;
    }

    public void setPuntajeTotal(int puntajeTotal) {
        this.puntajeTotal = puntajeTotal;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public ArrayList<String> getResp() {
        return resp;
    }

    public void setResp(ArrayList<String> resp) {
        this.resp = resp;
    }
}
