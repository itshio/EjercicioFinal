package com.example.ejerciciofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ReservaActivity extends AppCompatActivity {

    EditText reserv_nombre, reserv_persona, reserv_dia, reserv_hora, reserv_observacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        reserv_nombre = (EditText) findViewById(R.id.reserva_et_nombre);
        reserv_hora = (EditText) findViewById(R.id.reserva_et_hora);
        reserv_dia = (EditText) findViewById(R.id.reserva_et_dia);
        reserv_persona = (EditText) findViewById(R.id.reserva_et_persona);
        reserv_observacion = (EditText) findViewById(R.id.reserva_et_observacion);

        Bundle bundreserva= getIntent().getExtras();
        if(bundreserva!=null){

            ReservaClass reservados=bundreserva.getParcelable(FormularioActivity.EXTRA_FORMULARIO);
            reserv_nombre.setText(reservados.getNombre());
            reserv_dia.setText(reservados.getDia());
            reserv_hora.setText(reservados.getHora());
            reserv_persona.setText(reservados.getPersona()+"");
            reserv_observacion.setText(reservados.getObservacion());




        }else{

            Bundle bundreservados= getIntent().getExtras();

            if(bundreservados!=null){

                ListViewClass reservados = bundreservados.getParcelable(ListviewActivity.EXTRA_LIST);
                reserv_nombre.setText(reservados.getNombre());
                reserv_dia.setText(reservados.getDia());
                reserv_hora.setText(reservados.getHora());
            }


        }
    }

    public void clickaceptar (View view){

        Intent form_main =new Intent(getApplicationContext(),MainActivity.class);

        startActivity(form_main);

    }
}
