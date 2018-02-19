package com.example.ejerciciofinal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by DIDACT on 16/02/2018.
 */

public class ListViewAdaptador extends ArrayAdapter<ReservaClass> {

    ArrayList<ReservaClass> clasereserva;
    Context c;

    public ListViewAdaptador (Context c, ArrayList<ReservaClass> reservado){

        super(c, R.layout.item_reservas, reservado);
        this.c =c;
        this.clasereserva = reservado;



    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater= LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.item_reservas,null);


        TextView tv_dia=(TextView)item.findViewById(R.id.item_dia);
        tv_dia.setText(clasereserva.get(position).getDia());


        TextView tv_hora=(TextView)item.findViewById(R.id.item_hora);
        tv_hora.setText(clasereserva.get(position).getHora());

        TextView tv_nombre=(TextView)item.findViewById(R.id.item_nombre);
        tv_nombre.setText(clasereserva.get(position).getNombre());




        return item;
    }
}

