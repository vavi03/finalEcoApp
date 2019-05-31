package com.example.myapplication;

import java.util.ArrayList;

public class Nivel {
    private int id;
    private ArrayList<String> respuestas;

    public Nivel(){

    }

    public Nivel(int id, ArrayList<String> respuestas){
        this.id= id;
        this.respuestas=respuestas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<String> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(ArrayList<String> respuestas) {
        this.respuestas = respuestas;
    }
}
