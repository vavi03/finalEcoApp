package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.LinkedList;

public class AdapterPuestoRanking extends BaseAdapter {

    protected Activity actividad;
    protected LinkedList<PuestoRanking> puestos;

    public AdapterPuestoRanking(Activity actividad, LinkedList<PuestoRanking> puestos){
        this.actividad = actividad;
        this.puestos = puestos;
    }

    @Override
    public int getCount() {
        return puestos.size();
    }

    @Override
    public Object getItem(int position) {
        return puestos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (convertView == null){
            LayoutInflater inf = (LayoutInflater) actividad.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.item_puestoranking_layout, null);
        }

        PuestoRanking puestoActual = puestos.get(position);

        TextView usuario = (TextView) v.findViewById(R.id.tv_puesto_usuario);
        TextView puntaje = (TextView) v.findViewById(R.id.tv_puesto_puntaje);
        ImageView avatar = (ImageView) v.findViewById(R.id.iv_puesto_avatar);
        ImageView fondo = (ImageView) v.findViewById(R.id.iv_puesto_fondo);

        usuario.setText(puestoActual.getUsuario());
        puntaje.setText(Integer.toString(puestoActual.getPuntaje()));

        //condiciones para el avatar-------------------------------------
        if(puestoActual.getAvatar().equals("uno")){
            avatar.setImageResource(R.drawable.avataruno);

        }
        if(puestoActual.getAvatar().equals("dos")){
            avatar.setImageResource(R.drawable.avatardos);

        }
        if(puestoActual.getAvatar().equals("tres")){
            avatar.setImageResource(R.drawable.avatartres);

        }
        if(puestoActual.getAvatar().equals("cuatro")){
            avatar.setImageResource(R.drawable.avatarcuatro);

        }
        if(puestoActual.getAvatar().equals("cinco")){
            avatar.setImageResource(R.drawable.avatarcinco);

        }
        if(puestoActual.getAvatar().equals("seis")){
            avatar.setImageResource(R.drawable.avatarseis);

        }

        //condiciones para el fondo-------------------------------------
        if(puestoActual.getFondo() == 1) {
            fondo.setImageResource(R.drawable.primerpuesto);
        }
        if(puestoActual.getFondo() == 2) {
            fondo.setImageResource(R.drawable.segundopuesto);
        }
        if(puestoActual.getFondo() == 3) {
            fondo.setImageResource(R.drawable.tercerpuesto);
        }
        if(puestoActual.getFondo() == 4) {
            fondo.setImageResource(R.drawable.cuartopuesto);
        }
        if(puestoActual.getFondo() == 5) {
            fondo.setImageResource(R.drawable.quintopuesto);
        }
        if(puestoActual.getFondo() == 6) {
            fondo.setImageResource(R.drawable.sextopuesto);
        }


        return v;
    }
}
