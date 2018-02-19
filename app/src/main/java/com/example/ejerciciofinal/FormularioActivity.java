package com.example.ejerciciofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class FormularioActivity extends AppCompatActivity {

    static final String EXTRA_FORMULARIO = "FORMULARIO";

    EditText form_etnombre, form_etpersonas, form_etobservaciones;
    Spinner form_spdia, form_sphora;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        form_etnombre=(EditText)findViewById(R.id.formu_et_nombre);
        form_etpersonas=(EditText)findViewById(R.id.formu_et_personas);
        form_etobservaciones=(EditText)findViewById(R.id.formu_et_observacion);

        form_spdia=(Spinner)findViewById(R.id.formu_sp_dia);
        form_sphora=(Spinner)findViewById(R.id.formu_sp_hora);

        String [] dia= {"","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
        ArrayAdapter<String> adaptadordia= new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,dia);

        form_spdia.setAdapter(adaptadordia);

        String [] hora= {"","11:00","12:00","13:00","14:00","15:00","16:00"};
        ArrayAdapter<String> adaptadorhora= new ArrayAdapter<String>(this,
                android.R.layout.simple_expandable_list_item_1,hora);
        form_sphora.setAdapter(adaptadorhora);

    }

    public void formu_clickreservar (View view){

        String nombre=form_etnombre.getText().toString();
        String personas=form_etpersonas.getText().toString();
        String observaciones= form_etobservaciones.getText().toString();
        String spdia= form_spdia.getSelectedItem().toString();
        String sphora= form_sphora.getSelectedItem().toString();




        if(nombre.equals("")|| personas.equals("")||spdia.equals("")||sphora.equals("")){

            Toast.makeText(this,"Debes rellenar todos los campos",Toast.LENGTH_LONG).show();

        }else{

            int persona = Integer.parseInt(personas);

            ReservaClass reserva = new ReservaClass(nombre,persona,observaciones,spdia,sphora);

            Intent form_reserva =new Intent(getApplicationContext(),ReservaActivity.class);
            form_reserva.putExtra(EXTRA_FORMULARIO,reserva);

            startActivity(form_reserva);




        }

    }
}
