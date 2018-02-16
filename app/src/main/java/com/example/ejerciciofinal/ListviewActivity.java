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

    static final String EXTRA_LIST = "LISTVIEW";

    TextView List_txtdia, List_txtnombre, List_txthora;
    ListView List_principal;
    ArrayList<ListViewClass> lista_reservas= new ArrayList<ListViewClass>();

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

                ListViewClass c = ((ListViewClass)parent.getItemAtPosition(position));
                String nombre= c.getNombre();
                String hora= c.getHora();
                String dia= c.getDia();


                List_txtnombre.setText(nombre);
                List_txtdia.setText(dia);
                List_txthora.setText(hora);

                ListViewClass lista = new ListViewClass(nombre,hora,dia);

                Intent form_lista =new Intent(getApplicationContext(),ReservaClass.class);
                form_lista.putExtra(EXTRA_LIST,lista);

                startActivity(form_lista);







            }
        });




    }


    private void cargarreservas (){

        lista_reservas.add(new ListViewClass("Antonio","15.00","Lunes"));
        lista_reservas.add(new ListViewClass("Juan","13.00","Martes"));
        lista_reservas.add(new ListViewClass("Maria","16.00","Jueves"));
        lista_reservas.add(new ListViewClass("Pol","11.00","Lunes"));
        lista_reservas.add(new ListViewClass("Isabel","17.00","Martes"));
        lista_reservas.add(new ListViewClass("Paula","14.00","Lunes"));
        lista_reservas.add(new ListViewClass("Alvaro","15.00","Jueves"));
        lista_reservas.add(new ListViewClass("Juan Jose","15.00","Lunes"));




    }



}//NO BORRAR
