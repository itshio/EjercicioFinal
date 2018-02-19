package com.example.ejerciciofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListviewActivity extends AppCompatActivity {

    static final String EXTRA_LIST = "FORMULARIO";

    TextView List_txtdia, List_txtnombre, List_txthora;
    ListView List_principal;
    ArrayList<ReservaClass> lista_reservas= new ArrayList<ReservaClass>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        List_txtnombre=(TextView)findViewById(R.id.listview_txt_nombre);
        List_txtdia=(TextView)findViewById(R.id.listview_txt_dia);
        List_txthora=(TextView)findViewById(R.id.listview_txt_hora);

        List_principal=(ListView)findViewById(R.id.List_reservas);
        ListViewAdaptador adaptador_reservado= new ListViewAdaptador(this,lista_reservas);
        List_principal.setAdapter(adaptador_reservado);

        cargarreservas();

        List_principal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ReservaClass c = ((ReservaClass)parent.getItemAtPosition(position));
                String nombre= c.getNombre();
                String hora= c.getHora();
                String dia= c.getDia();


                List_txtnombre.setText(nombre);
                List_txtdia.setText(dia);
                List_txthora.setText(hora);












            }
        });

        List_principal.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                ReservaClass c = ((ReservaClass)parent.getItemAtPosition(position));


                Intent form_lista =new Intent(getApplicationContext(),ReservaActivity.class);
                form_lista.putExtra(EXTRA_LIST,c);

                startActivity(form_lista);




                return true;
            }
        });




    }


    private void cargarreservas (){

        lista_reservas.add(new ReservaClass("Antonio", 2    , "15.00","Lunes", "voy solo" ));
        lista_reservas.add(new ReservaClass("Juan", 3   , "13.00","Martes", "voy solo"));
        lista_reservas.add(new ReservaClass("Maria", 1  , "16.00","Jueves", "voy solo"));
        lista_reservas.add(new ReservaClass("Pol", 3    , "11.00","Lunes", "voy solo"));
        lista_reservas.add(new ReservaClass("Isabel", 1 , "17.00","Martes", "voy solo"));
        lista_reservas.add(new ReservaClass("Paula", 4  , "14.00","Lunes", "voy solo"));
        lista_reservas.add(new ReservaClass("Alvaro", 2 , "15.00","Jueves", "voy solo"));
        lista_reservas.add(new ReservaClass("Juan Jose", 1  , "15.00","Lunes", "voy solo"));




    }



}//NO BORRAR
