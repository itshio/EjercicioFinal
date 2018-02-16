package com.example.ejerciciofinal;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by DIDACT on 16/02/2018.
 */

public class ReservaClass implements Parcelable{

    String nombre;
    int persona;
    String dia;
    String hora;
    String observacion;

    public static final Parcelable.Creator<ReservaClass> CREATOR = new Parcelable.Creator<ReservaClass>(){
        public ReservaClass createFromParcel(Parcel in) {
            return new ReservaClass(in);
        }
        public ReservaClass[] newArray(int size){
            return new ReservaClass[size];
        }
    };

    public ReservaClass(String nombre, int persona, String dia, String hora, String observacion) {
        this.nombre = nombre;
        this.persona = persona;
        this.dia = dia;
        this.hora = hora;
        this.observacion = observacion;
    }

    public ReservaClass (Parcel parcel){

        ReadFromParcel(parcel);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPersona() {
        return persona;
    }

    public void setPersona(int persona) {
        this.persona = persona;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public int describeContents() {

        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(this.nombre);
        dest.writeInt(this.persona);
        dest.writeString(this.dia);
        dest.writeString(this.hora);
        dest.writeString(this.observacion);

    }

    public void ReadFromParcel (Parcel parcel){

        this.nombre= parcel.readString();
        this.persona= parcel.readInt();
        this.dia= parcel.readString();
        this.hora= parcel.readString();
        this.observacion= parcel.readString();


    }
}
