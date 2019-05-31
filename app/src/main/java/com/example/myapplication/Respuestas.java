package com.example.myapplication;

import java.util.ArrayList;

public class Respuestas {

    private ArrayList<String> data;

    public Respuestas(){

    }

    public Respuestas(ArrayList<String> data){
        this.data=data;
    }

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }
}
