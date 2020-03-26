package com.example.seccion_02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    //Paramtros necesarios

    // contexto donde va ser dibujado este adaptador
    private Context context;

    // un layout
    private int layout;

    //lista de string , con los nombres
    private List<String> names;



    //contructor
    public  MyAdapter(Context context, int layout, List<String> names){
        this.context = context;
        this.layout = layout;
        this.names = names;

    }




    //dice al adaptador cuantas veces iterar sobre una colección que le vamos a dar
    //el numero que resulta son los numeros de item que se renderizara
    @Override
    public int getCount() {
        return this.names.size();
    }

    //Obtener un item de la collecion
    @Override
    public Object getItem(int position) {
        return this.names.get(position);
    }

    //Obtener el id del elemento de la colleción
    @Override
    public long getItemId(int id) {
        return id;
    }

    //Coge cada elemento o item y desde aqui se dibujan
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {


        //copiamos la vista
        //View view = convertView;


        //View Holder Pattern
        ViewHolder holder;
        if (convertView ==null){

            // cogemos del contexto a un inflater e inflamos nuestro layout personalizado
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);

            //inflamos nuestro view con el layout personalizado
            convertView =  layoutInflater.inflate(this.layout, null);

            holder = new ViewHolder();

            //rellenamos el textview del layout personalizado, referenciandolo!!
            holder.nameTextView= convertView.findViewById(R.id.textView);
            convertView.setTag( holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }


        //automaticamente tomara cada valor de la lista de string, internamente itera
        String currentName = names.get(position);
        //currentName = (String)getItem(position);


        holder.nameTextView.setText(currentName);


        //devolvemos nuestro view
        return convertView;
    }

    static class ViewHolder{
        private TextView nameTextView;



    }

}
