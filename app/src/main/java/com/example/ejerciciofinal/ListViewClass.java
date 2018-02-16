package com.example.ejerciciofinal;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by DIDACT on 16/02/2018.
 */

public class ListViewClass implements Parcelable{

    String nombre;
    String hora;
    String dia;

    public static final Parcelable.Creator<ListViewClass> CREATOR = new Parcelable.Creator<ListViewClass>(){
        public ListViewClass createFromParcel(Parcel in) {
            return new ListViewClass(in);
        }
        public ListViewClass[] newArray(int size){
            return new ListViewClass[size];
        }
    };

    public ListViewClass(String nombre, String hora, String dia) {
        this.nombre = nombre;
        this.hora = hora;
        this.dia = dia;
    }

    public ListViewClass(Parcel parcel){

        ReadFromParcel(parcel);

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(this.nombre);
        dest.writeString(this.hora);
        dest.writeString(this.dia);

    }

    public void ReadFromParcel (Parcel parcel){

        this.nombre=parcel.readString();
        this.hora=parcel.readString();
        this.dia=parcel.readString();


    }
}
