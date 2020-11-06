package com.example.adaptador_tareas2clase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.TwoLineListItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista= findViewById(R.id.lista);

        Tarea t1 = new Tarea("nadar","19");
        Tarea t2 = new Tarea("discoteca","21");
        Tarea t3 = new Tarea("correr","19");
        Tarea t4 = new Tarea("conducir","21");
        Tarea t5 = new Tarea("residencia","100");

        List<Tarea> list = new ArrayList<Tarea>();

        list.add(t1);
        list.add(t2);
        list.add(t3);
        list.add(t4);
        list.add(t5);


        TareaArrayAdapter<Tarea> adaptador = new TareaArrayAdapter<Tarea>(this, list);
        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

       String nombre = ((Tarea)parent.getItemAtPosition(position)).getNombre();
       String edad = ((Tarea)parent.getItemAtPosition(position)).getEdad();
       String nombre2 = String.valueOf(((TwoLineListItem)view).getText1().getText());
       String edad2 = String.valueOf(((TwoLineListItem)view).getText2().getText());

       Toast.makeText(this, nombre2 + " " + edad2, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onBackPressed(){
        finish();
    }
}