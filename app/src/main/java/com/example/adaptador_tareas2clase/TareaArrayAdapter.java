package com.example.adaptador_tareas2clase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class TareaArrayAdapter<T> extends ArrayAdapter<T> {
    List<T> datos;

    public TareaArrayAdapter(Context context, List<T> datos) {
        super(context, android.R.layout.simple_list_item_2, datos);
        this.datos = datos;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View listItemView = convertView;

        if (convertView==null) {

            LayoutInflater inflater =
                    (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            listItemView = inflater.inflate( android.R.layout.simple_list_item_2, parent, false);
        }

        TextView titulo = (TextView)listItemView.findViewById(android.R.id.text1);
        TextView subtitulo = (TextView)listItemView.findViewById(android.R.id.text2);
        titulo.setText(((Tarea)datos.get(position)).getNombre());
        subtitulo.setText(((Tarea)datos.get(position)).getEdad());


        return listItemView;
    }
}
