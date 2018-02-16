package com.example.ejerciciofinal;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }//ON CREATE


    public void clickinfo (View view) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        AlertDialog dialogo = new AlertDialog();
        dialogo.show(fragmentManager, "dialogAlerta");



    }

    public void clickreserva (View view){

        Intent reserva = new Intent(getApplicationContext(),FormularioActivity.class);
        startActivity(reserva);
    }

    public void clicklistview (View view){

        Intent listview = new Intent(getApplicationContext(),ListviewActivity.class);
        startActivity(listview);
    }


}// No BORRAR
