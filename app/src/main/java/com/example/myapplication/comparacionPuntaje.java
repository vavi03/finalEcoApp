package com.example.myapplication;

import java.util.Comparator;

public class comparacionPuntaje implements Comparator<usuarioRanking>{
    @Override
    public int compare(usuarioRanking o1, usuarioRanking o2) {
        return o2.getPuntajeTotal() - o1.getPuntajeTotal();
    }

}
